package admin.create.models

sealed class CreateGameEvent {
    data class TitleChanged(val title: String): CreateGameEvent()
    data class Description(val description: String): CreateGameEvent()
    data class VersionChanged(val versionChanged: String): CreateGameEvent()
    data class SizeChanged(val sizeChanged: String): CreateGameEvent()
    object SubmitChanges: CreateGameEvent()
}
