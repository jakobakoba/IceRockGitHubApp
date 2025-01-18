package com.bor96dev.icerockgithubapp.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.icerockgithubapp.data.AppRepository
import com.bor96dev.icerockgithubapp.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesListViewModel @Inject constructor(
    private val appRepository: AppRepository
): ViewModel() {

    private val _state = MutableLiveData<State>(State.Loading)
    val state: LiveData<State> = _state

    init {
        Log.d("GTA5", "INIT")
        loadRepos()
    }

    private fun loadRepos() {
        viewModelScope.launch {
            try {
                val repos = appRepository.getRepositories()
                Log.d("GTA5", "HELLO")
                Log.d("GTA5", repos.toString())
            } catch (e: Exception) {
                Log.d("GTA", "exception что то не так: $e")
            }
        }
    }

    sealed interface State {
        object Loading: State
        data class Loaded(val repos: List<Repo>) : State
        data class Error(val error: String) : State
        object Empty: State
    }
}