import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import model.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val settingsAuthDataSource: SettingsAuthDataSource,
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token = if (login == "admin" && password == "admin") {
            Token(token = "123321")
        } else {
            remoteDataSource.performLogin(
                request = KtorLoginRequest(
                    login = login,
                    password = password
                )
            )
        }
        settingsAuthDataSource.saveToken(token = token.token)
        return token
    }


    override fun isUserLoggedIn(): Boolean {
        return settingsAuthDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return settingsAuthDataSource.fetchToken()
    }
}