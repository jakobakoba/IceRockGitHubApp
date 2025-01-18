package com.bor96dev.icerockgithubapp.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bor96dev.icerockgithubapp.data.AppRepository
import com.bor96dev.icerockgithubapp.data.KeyValueStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val keyValueStorage: KeyValueStorage,
    private val appRepository: AppRepository
) : ViewModel() {
    init {
        Log.d("GTA5", "INIT Auth")
    }
    val token = MutableLiveData<String>()
    private val _state = MutableLiveData<State>(State.Idle)
    val state: LiveData<State> = _state
    private val _actions = MutableSharedFlow<Action>()
    val actions: Flow<Action> = _actions

    fun onSignButtonPressed() {
        viewModelScope.launch {
            if (token.value.isNullOrEmpty()) {
                _state.value = State.InvalidInput("Token can not be empty!")
                return@launch
            }
            _state.value = State.Loading
            keyValueStorage.authToken = token.value
            _actions.emit(Action.RouteToMain)
        }
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