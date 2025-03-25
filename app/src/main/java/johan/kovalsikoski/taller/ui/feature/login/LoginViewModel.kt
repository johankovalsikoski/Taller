package johan.kovalsikoski.taller.ui.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import johan.kovalsikoski.taller.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginScreenUIEvent) {
        when (event) {
            is LoginScreenUIEvent.OnLogin -> {
                viewModelScope.launch {
                    loginRepository.login(event.userCredentials).collect {
                        _state.value = _state.value.copy(
                            loginState = it
                        )
                    }
                }
            }
        }
    }
}
