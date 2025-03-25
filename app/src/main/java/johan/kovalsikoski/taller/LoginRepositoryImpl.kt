package johan.kovalsikoski.taller

import johan.kovalsikoski.taller.ui.UserCredentials
import johan.kovalsikoski.taller.ui.feature.login.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginRepositoryImpl: LoginRepository {
    override fun login(user: UserCredentials): Flow<LoginState> = flow {
        emit(LoginState.Loading)
        delay(2000)

        if (user.email.isEmpty() || user.password.isEmpty()) {
            emit(LoginState.Error("Invalid credentials"))
            return@flow
        }

        emit(LoginState.Success(user))

    }.flowOn(Dispatchers.IO)
}
