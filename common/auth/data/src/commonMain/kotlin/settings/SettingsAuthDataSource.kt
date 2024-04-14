package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

class SettingsAuthDataSource(
    private val settings: Settings
) {
    fun saveToken(token: String) {
        settings.putString(TOKEN_KEY, token)
    }

    fun fetchToken(): String {
        return settings[TOKEN_KEY, ""]
    }

    companion object {
        private val TOKEN_KEY = "tokenKey"
    }
}