package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {

    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Now", color = Theme.colors.thirdTextColor,
            fontSize = 24.sp, fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back to PlayZone! Enter your email address and your password to enjoy the latest features of PlayZone",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Theme.colors.hintTextColor
        )

        Spacer(modifier = Modifier.height(50.dp))

        CommonTextField(text = state.email, hint = "Your login", enabled = !state.isSending) {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }

        Spacer(modifier = Modifier.height(24.dp))

        CommonTextField(
            text = state.password,
            hint = "Your password",
            enabled = !state.isSending,
            isSecure = state.passwordHidden,
            trailingIcon = {
                Icon(
                    imageVector = if (state.passwordHidden) Icons.Outlined.Clear else Icons.Outlined.Lock,
                    contentDescription = "",
                    modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.PasswordShowClick) },
                    tint = Theme.colors.highlightTextColor,
                )
            }
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Forgot Password",
                modifier = Modifier.clickable { eventHandler.invoke(LoginEvent.ForgotClick) },
                color = Theme.colors.primaryAction,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(84.dp))

        ActionButton(title = "Login Now", isSending = state.isSending) {
            eventHandler.invoke(LoginEvent.LoginClick)
        }
    }
}