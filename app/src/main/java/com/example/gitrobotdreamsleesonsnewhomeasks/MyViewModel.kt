package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrobotdreamsleesonsnewhomeasks.MyViewModel.UIState.Clean
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val repo = MyApplication.getApp().repo
    private var _uiState = MutableLiveData<UIState>(UIState.Empty)
    val uiState: LiveData<UIState> = _uiState
    fun getData() {
        _uiState.value = UIState.Processing
        viewModelScope.launch(Dispatchers.IO) {
            val result = async { repo.getSuperHeroesByCR() }.await()
            if (result.isNotEmpty()) {
                _uiState.postValue(UIState.Result(result))
            }
        }
    }

    fun removeData(){
        _uiState.value = UIState.Clean
        val emptyList = mutableListOf<SuperHero>()
        _uiState.postValue(UIState.Result(emptyList))
    }
    sealed class UIState {
        object Empty : UIState()
        object Processing : UIState()
        class Result(val list: List<SuperHero>) : UIState()
        object Clean : UIState()
    }
}

//    private val _listState = MutableLiveData<ListState>(ListState.EmptyList)
//    val listState: LiveData<ListState> = _listState
//    private val observer = Observer<List<SuperHero>> {
//        _listState.postValue(ListState.UpdatedList(list = it))
//    }


//        sealed class ListState {
//            object EmptyList : ListState()
//            class UpdatedList(val list: List<SuperHero>) : ListState()
//        }


//fun getData() {
//    var result = ""
//    _uiState.value = UIState.Processing
//    viewModelScope.launch (Dispatchers.IO){
//        val superHeroes = async{repo.getSuperHeroesByCR()}.await()
//        if(superHeroes.isNotEmpty()) result = "List updated!"
//        _uiState.postValue(UIState.Result(result))
//    }
//
//}

//    sealed class UIState {
//        object Empty : UIState()
//        object Processing : UIState()
//        class Result(val title:String) : UIState()
//
//    }
//    }
//}