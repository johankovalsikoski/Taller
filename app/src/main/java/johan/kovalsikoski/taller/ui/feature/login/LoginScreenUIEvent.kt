package johan.kovalsikoski.taller.ui.feature.login

import johan.kovalsikoski.taller.ui.UserCredentials

sealed class LoginScreenUIEvent {
    class OnLogin(val userCredentials: UserCredentials) : LoginScreenUIEvent()
}