package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.ActivityRetainedSavedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyViewModel @Inject constructor(val repo: Repository): ViewModel() {
    private val _uiState = MutableLiveData<UIState>(UIState.Empty)
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
