package johan.kovalsikoski.taller

import johan.kovalsikoski.taller.ui.UserCredentials
import johan.kovalsikoski.taller.ui.feature.login.LoginState
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(user: UserCredentials): Flow<LoginState>
}
