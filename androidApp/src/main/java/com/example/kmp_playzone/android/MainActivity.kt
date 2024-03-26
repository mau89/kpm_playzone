package com.example.kmp_playzone.android

import GamesRepository
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import di.Inject.instance
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gamesRepository = instance<GamesRepository>()
        CoroutineScope(context = Dispatchers.IO).launch {
            val games =
                try {
                    gamesRepository.searchGame("a")
                } catch (e:Exception){
                    Log.e("test", "e $e")
                    emptyList()
                }
            withContext(Dispatchers.Main) {
                val tv = findViewById<TextView>(R.id.text_view)
                tv.text = "Title: ${games.size}"
            }
        }

    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
