package login.models

sealed class LoginAction {
    object OpenRegistration: LoginAction()
    object OpenForgotPasswordScreen: LoginAction()
    object OpenMainFlow: LoginAction()
}