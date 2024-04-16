package sqldelight

import com.example.kmp_playzone.DataBase
import ktor.KtorGamesDataSource
import ktor.models.KtorSearchGame
import models.Game

class SqlDelightGamesDataSource(val dataBase: DataBase) {

    fun fetchLocalGames(): List<Game> {
        return dataBase.gameQueries.getAllGames().executeAsList()
            .map {
                Game(
                    gameId = it.game_id,
                    title = it.game_title,
                )
            }
    }

    fun insertGame(game: KtorSearchGame) {
        dataBase.gameQueries.insertGame(
            game_id = game.gameId,
            game_title = game.title,
            game_size = game.size,
            game_version = game.version
        )
    }
}