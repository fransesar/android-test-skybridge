package com.fransiscuscaesar.skybridge.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fransiscuscaesar.skybridge.data.models.Movie
import com.fransiscuscaesar.skybridge.data.network.MainAPI
import com.fransiscuscaesar.skybridge.util.State
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val api: MainAPI
) : ViewModel() {
    private val mutableState = MutableLiveData<State<List<Movie>>>()
    val state: LiveData<State<List<Movie>>> = mutableState

    init {
        getLatestMovies()
    }

    fun getLatestMovies() {
        mutableState.value = State.Loading
        viewModelScope.launch {
            try {
                val listMovie: ArrayList<Movie> = arrayListOf()
                val result = api.getLatestMovies()
                listMovie.add(result)
                mutableState.value = State.Success(listMovie)
            } catch (e: Exception) {
                mutableState.value = State.Error(e)
            }
        }
    }

    fun getUpcomingMovies() {
        mutableState.value = State.Loading
        viewModelScope.launch {
            try {
                val result = api.getUpcomingMovies()
                val listMovie = result.result ?: mutableListOf()
                mutableState.value = State.Success(listMovie)
            } catch (e: Exception) {
                mutableState.value = State.Error(e)
            }
        }
    }
}