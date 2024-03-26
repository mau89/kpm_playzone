import ktor.KtorGamesDataSource
import ktor.models.mapToGame
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoreDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource,
) : GamesRepository {

    override suspend fun fetchAllGames(): List<Game> {
        return remoreDataSource.fetchAllGames().map { it.mapToGame() }
    }

    override suspend fun searchGame(query: String): List<Game> {
        return remoreDataSource.searchGame(query).map { it.mapToGame() }
    }
}