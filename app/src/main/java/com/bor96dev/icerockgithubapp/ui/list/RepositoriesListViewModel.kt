package com.bor96dev.icerockgithubapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bor96dev.icerockgithubapp.data.AppRepository
import com.bor96dev.icerockgithubapp.data.network.RepoService
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class RepositoriesListViewModel(
    private val appRepositor: AppRepository
): ViewModel() {

    private val _state = MutableLiveData<State>(State.Loading)
    val state: LiveData<State> = _state

    sealed interface State {
        object Loading: State
//        data class Loaded(val repos: List<Repo>) : State
        data class Error(val error: String) : State
        object Empty: State
    }
}