package navigation

import SplashScreen
import admin.create.CreateGameScreen
import admin.navifation.adminFlow
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

enum class NavigationSource {
    Desktop, Android, IOS
}

fun RootComposeBuilder.generateGraph(source: NavigationSource) {
    screen(name = NavigationTree.Splash.SplashScreen.name){
        SplashScreen()
    }

    screen(name = NavigationTree.Main.Game.name){
        Text("Hello, Game detail", color = Color.White)
    }

    authFlow()

    when (source){
        NavigationSource.Desktop -> {
            adminFlow()
            screen(name = NavigationTree.Admin.CreateGame.name){
                CreateGameScreen()
            }
        }
        NavigationSource.Android -> mainFlow()
        NavigationSource.IOS -> {}
    }

}