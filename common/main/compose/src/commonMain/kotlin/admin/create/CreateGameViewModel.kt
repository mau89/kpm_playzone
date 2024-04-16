package admin.create

import AuthRepository
import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import admin.create.models.CreateGameAction
import admin.create.models.CreateGameEvent
import admin.create.models.CreateGameState
import di.Inject
import kotlinx.coroutines.launch
import models.CreateGameInfo

class CreateGameViewModel : BaseSharedViewModel<
        CreateGameState,
        CreateGameAction,
        CreateGameEvent>(CreateGameState()) {

    private val gamesRepository: GamesRepository = Inject.instance()
    private val authRepository: AuthRepository = Inject.instance()

    override fun obtainEvent(viewEvent: CreateGameEvent) {
        when (viewEvent) {
            is CreateGameEvent.Description -> viewState = viewState.copy(description = viewEvent.description)
            is CreateGameEvent.SizeChanged -> viewState = viewState.copy(size = viewEvent.sizeChanged)
            is CreateGameEvent.TitleChanged -> viewState = viewState.copy(title = viewEvent.title)
            is CreateGameEvent.VersionChanged -> viewState = viewState.copy(version = viewEvent.versionChanged)
            is CreateGameEvent.SubmitChanges -> createGame()
        }
    }

    private fun createGame() {
        viewModelScope.launch {
            viewState = viewState.copy(isSending = true)

            try {
                val token = authRepository.fetchToken()
                gamesRepository.createGame(token, CreateGameInfo(
                    title = viewState.title,
                    description = viewState.description,
                    version = viewState.version,
                    size = viewState.size,
                ))

                viewAction = CreateGameAction.CloseScreen
            } catch (e: Exception) {
                viewState = viewState.copy(isSending = false)
            }
        }
    }
}