package admin.games.models

import models.Game

data class AdminGamesState(
    val games: List<Game> = emptyList()
)