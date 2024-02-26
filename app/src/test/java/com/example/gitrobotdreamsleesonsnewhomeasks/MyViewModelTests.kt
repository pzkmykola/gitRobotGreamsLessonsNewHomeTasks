package com.example.gitrobotdreamsleesonsnewhomeasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import retrofit2.Response
import com.example.gitrobotdreamsleesonsnewhomeasks.SuperHeroDataResponse as SuperHeroDataResponse

class MyViewModelTests {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun getEmptyResponse(){
        val repository = Mockito.mock(Repository::class.java)
        var currentResponse = emptyList<SuperHero>()
        val viewModel = MyViewModel(repository)
        val eventList = mutableListOf<MyViewModel.UIState>()
        viewModel.uiState.observeForever {
            eventList.add(it)
        }
        runBlocking(Dispatchers.IO) {
            Mockito.`when`(repository.getSuperHeroesByCR()).thenReturn(currentResponse)
        }
        viewModel.getData()

        Assert.assertEquals(MyViewModel.UIState.Empty,eventList[0])
        Assert.assertEquals(MyViewModel.UIState.Processing,eventList[1])
        runBlocking(Dispatchers.IO) {
            delay(100)
        }
        Assert.assertEquals(0, currentResponse.size)
    }

    @Test
    fun getSuccessfulResponse(){
        val repository = Mockito.mock(Repository::class.java)
        var currentResponseExample = emptyList<SuperHero>()
        currentResponseExample = listOf(DataExample)
        val viewModel = MyViewModel(repository)
        val eventList = mutableListOf<MyViewModel.UIState>()
        viewModel.uiState.observeForever {
            eventList.add(it)
        }
        runBlocking(Dispatchers.IO) {
            Mockito.`when`(repository.getSuperHeroesByCR()).thenReturn(currentResponseExample as SuperHeroDataResponse)
        }
        viewModel.getData()

        Assert.assertEquals(MyViewModel.UIState.Empty,eventList[0])
        Assert.assertEquals(MyViewModel.UIState.Processing,eventList[1])
        runBlocking(Dispatchers.IO) {
            delay(100)
        }
        val uiState = eventList[2] as MyViewModel.UIState.Result
        Assert.assertEquals(1, uiState.list.size)
    }
}