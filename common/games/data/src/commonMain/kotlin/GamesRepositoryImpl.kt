import ktor.KtorGamesDataSource
import ktor.models.KtorSearchGame
import ktor.models.mapToGame
import models.CreateGameInfo
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoreDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource,
) : GamesRepository {

    override suspend fun fetchAllGames(): List<Game> {

        val remoteDeprecated = remoreDataSource.fetchAllGames().map { it.mapToGame() }
        return localDataSource.fetchLocalGames()
    }

    override suspend fun searchGame(query: String): List<Game> {
        return localDataSource.fetchLocalGames()//remoreDataSource.searchGame(query).map { it.mapToGame() }
    }

    override suspend fun createGame(token: String, createGameInfo: CreateGameInfo) {
        remoreDataSource.createGame(token, createGameInfo)
//        localDataSource.insertGame(game = createGameInfo.toMapKtorGame())
    }


//    private fun toMapKtorGame(game: CreateGameInfo): KtorSearchGame {
//        return KtorSearchGame(
//            gameId = game.title,
//            title = game.title
//        )
//    }
}
