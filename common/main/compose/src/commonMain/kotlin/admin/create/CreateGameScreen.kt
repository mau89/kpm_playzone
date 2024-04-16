package admin.create

import admin.create.models.CreateGameAction
import admin.create.models.CreateGameEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun CreateGameScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({ CreateGameViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState().value
        val viewAction = viewModel.viewActions().observeAsState().value

        when (viewAction) {
            CreateGameAction.CloseScreen -> rootController.popBackStack()
            null -> {}
        }

        Column(modifier = Modifier.padding(16.dp)) {
            CommonTextField(text = viewState.title, hint = "Game tint", enabled = !viewState.isSending) {
                viewModel.obtainEvent(CreateGameEvent.TitleChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(text = viewState.description, hint = "Game description", enabled = !viewState.isSending) {
                viewModel.obtainEvent(CreateGameEvent.Description(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(text = viewState.version, hint = "Game version", enabled = !viewState.isSending) {
                viewModel.obtainEvent(CreateGameEvent.VersionChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(text = viewState.size, hint = "Game size", enabled = !viewState.isSending) {
                viewModel.obtainEvent(CreateGameEvent.SizeChanged(it))
            }

            Spacer(modifier = Modifier.height(16.dp))

            ActionButton(title = "Save changes", isSending = !viewState.isSending) {
                viewModel.obtainEvent(CreateGameEvent.SubmitChanges)
            }
        }
    }
}