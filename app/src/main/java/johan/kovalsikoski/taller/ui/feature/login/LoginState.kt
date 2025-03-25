package johan.kovalsikoski.taller.ui.feature.login

import johan.kovalsikoski.taller.ui.UserCredentials

sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data class Error(val message: String) : LoginState()
    data class Success(val user: UserCredentials) : LoginState()
}
