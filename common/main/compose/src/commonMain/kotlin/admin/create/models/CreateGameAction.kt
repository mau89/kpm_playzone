package admin.create.models

sealed class CreateGameAction {
    object CloseScreen : CreateGameAction()
}
