package com.bor96dev.icerockgithubapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class AuthViewModel() {
    val token = MutableLiveData<String>()
    private val _state = MutableLiveData<State>(State.Idle)
    val state: LiveData<State> = _state
    private val _actions = MutableSharedFlow<Action>()
    val actions: Flow<Action> = _actions

    fun onSignButtonPressed() {

    }

    sealed interface State {
        object Idle : State
        object Loading : State
        data class InvalidInput(val reason: String) : State
    }

    sealed interface Action {
        data class ShowError(val message: String) : Action
        object RouteToMain : Action
    }
}