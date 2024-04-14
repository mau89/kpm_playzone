import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import model.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val settingsAuthDataSource: SettingsAuthDataSource,
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token = remoteDataSource.performLogin(
            request = KtorLoginRequest(
                login = login,
                password = password
            )
        )
        settingsAuthDataSource.saveToken(token = token.token)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return settingsAuthDataSource.fetchToken().isNotBlank()
    }
}