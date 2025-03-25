package johan.kovalsikoski.taller.ui.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import johan.kovalsikoski.taller.ui.UserCredentials

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    screenState: LoginScreenState,
    onEvent: (LoginScreenUIEvent) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        var user by remember {
            mutableStateOf("")
        }

        var pswd by remember {
            mutableStateOf("")
        }

        if (screenState.loginState is LoginState.Error) {
            Text("Error: ${screenState.loginState.message}")
        }

        if (screenState.loginState is LoginState.Success) {
            Text("Success: ${screenState.loginState.user.email}")
        }

        TextField(
            value = user,
            onValueChange = {
                user = it
            },
            label = { Text("Username") },
            modifier = Modifier
                .padding(16.dp)
        )

        TextField(
            value = pswd,
            onValueChange = {
                pswd = it
            },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Password") },
            modifier = Modifier
                .padding(16.dp)
        )

        Button(
            onClick = {
                onEvent(LoginScreenUIEvent.OnLogin(UserCredentials(user, pswd)))
            },
            enabled = screenState.loginState !is LoginState.Loading,
        ) {
            if (screenState.loginState is LoginState.Loading) {
                Text("Loading")
            } else {
                Text("LoginUI")
            }
        }

    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(screenState = LoginScreenState(loginState = LoginState.Idle)) {}
}