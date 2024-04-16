package admin.create.models

data class CreateGameState(
    val title: String = "",
    val description: String = "",
    val version: String = "",
    val size: String = "",
    val isSending: Boolean = false,
)
