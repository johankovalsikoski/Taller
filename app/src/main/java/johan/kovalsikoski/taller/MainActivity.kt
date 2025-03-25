package johan.kovalsikoski.taller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import johan.kovalsikoski.taller.ui.feature.login.LoginScreen
import johan.kovalsikoski.taller.ui.feature.login.LoginScreenState
import johan.kovalsikoski.taller.ui.feature.login.LoginViewModel
import johan.kovalsikoski.taller.ui.theme.TallerTheme

class MainActivity : ComponentActivity() {
    private val viewModel by lazy {
        LoginViewModel(
            loginRepository = LoginRepositoryImpl()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TallerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val state = viewModel.state.collectAsState()

                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        screenState = LoginScreenState(loginState = state.value.loginState)
                    ) {
                        viewModel.onEvent(it)
                    }
                }
            }
        }
    }
}

/*
* Create an Android app that simulates a login process using Kotlin coroutines.
* The app should have the following features:

LoginUI form: Design a simple login form with fields for username and password.
Simulated authentication: Utilize Kotlin coroutines to simulate an authentication process.
For example, you can use a coroutine with a delay to mimic the authentication process taking some time.
Display login result: After the simulated authentication, display a message indicating whether the login was successful or not.
Error handling: Handle cases where the login process encounters errors or invalid credentials gracefully, displaying appropriate error messages to the user.

Bonus (optional):

Loading indicator: Show a loading indicator while the authentication process is ongoing.
Remember me: Add an option to remember the user's login credentials for future sessions.
* */
