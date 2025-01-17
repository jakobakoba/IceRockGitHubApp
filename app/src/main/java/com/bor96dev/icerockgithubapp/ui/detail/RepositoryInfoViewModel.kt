package com.bor96dev.icerockgithubapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bor96dev.icerockgithubapp.domain.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepositoryInfoViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableLiveData<State>(State.Loading)
    val state: LiveData<State> = _state

    sealed interface State {
        object Loading: State
        data class Error(val error: String) : State

        data class Loaded(
            val githubRepo: Repo,
            val readmeState: ReadmeState
        ) : State
    }

    sealed interface ReadmeState {
        object Loading: ReadmeState
        object Empty: ReadmeState
        data class Error (val error: String) : ReadmeState
        data class Loaded (val markdown: String) : ReadmeState
    }
}