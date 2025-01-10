package auth.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import auth.ui.navigation.AuthNavigation

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
    onNavigation: (AuthNavigation) -> Unit,
    modifier: Modifier = Modifier,
) {
    var emailOrPhoneNumber by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    if (state.login.isSuccess) {
        onNavigation(AuthNavigation.Out)
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            Text("Home")
        }
    } else {
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            Column(
                modifier =
                    Modifier
                        .align(Alignment.Center),
            ) {
                TextField(
                    value = emailOrPhoneNumber,
                    onValueChange = { newValue ->
                        emailOrPhoneNumber = newValue
                    },
                    label = {
                        Text("Email")
                    },
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = password,
                    onValueChange = { newValue ->
                        password = newValue
                    },
                    label = {
                        Text("Password")
                    },
                )

                Button(
                    onClick = {
                        onEvent(
                            LoginEvent.Login(
                                email = emailOrPhoneNumber,
                                password = password,
                            ),
                        )

                        onNavigation(AuthNavigation.Out)
                    },
                    enabled = state.error.isNullOrBlank(),
                    modifier =
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(fraction = 0.7f),
                ) {
                    Box(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .background(
                                    shape = RoundedCornerShape(20.dp),
                                    color = MaterialTheme.colorScheme.primary,
                                ),
                    ) {
                        if (state.error.isNullOrBlank()) {
                            Text(
                                text = "Login ..",
                            )
                        } else {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}
