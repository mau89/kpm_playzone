package sqldelight

import com.example.kmp_playzone.DataBase
import database.DbDriverFactory
import ktor.KtorGamesDataSource
import ktor.models.KtorSearchGame
import models.Game

class SqlDelightGamesDataSource(private val dbDriverFactory: DbDriverFactory) {

    suspend fun fetchLocalGames(): List<Game> {
        val dataBase = DataBase(dbDriverFactory.provideDbDriver(DataBase.Schema ))
        return dataBase.gameQueries.getAllGames().executeAsList()
            .map {
                Game(
                    gameId = it.game_id,
                    title = it.game_title,
                )
            }
    }

    suspend fun insertGame(game: KtorSearchGame) {
        val dataBase = DataBase(dbDriverFactory.provideDbDriver(DataBase.Schema ))
        dataBase.gameQueries.insertGame(
            game_id = game.gameId,
            game_title = game.title,
            game_size = game.size,
            game_version = game.version
        )
    }
}