package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState(email = "", password = "")
) {

    private val authRepository: AuthRepository = Inject.instance()

    init {
        checkUserLoginIn()
    }

    private fun checkUserLoginIn() {
        if (authRepository.isUserLoggedIn()) {
            viewAction = LoginAction.OpenMainFlow
        }
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.RegistrationClick -> openRegistration()
            LoginEvent.PasswordShowClick -> changePasswordVisibility()
        }

    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(
            email = value
        )
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
            try {
                val response = authRepository.login(viewState.email, viewState.password)
                 if (response.token.isNotBlank()) {
                     viewState =viewState.copy(email = "", password = "", isSending = false)
                    viewAction = LoginAction.OpenMainFlow
                } else {
                     viewState = viewState.copy(isSending = false)
                }

            } catch (e: Exception) {
                viewState.copy(isSending = false)
            }
        }
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }
}