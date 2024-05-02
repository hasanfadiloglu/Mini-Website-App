package com.hasanfadiloglu.jpcomposewebviewdeneme

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.hasanfadiloglu.jpcomposewebviewdeneme.ui.theme.JPComposeWebViewDenemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPComposeWebViewDenemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    AndroidView(factory = {
    WebView(it).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        settings.javaScriptEnabled = true
        webViewClient = WebViewClient()
        loadUrl("https://www.trendyol.com/butik/liste/2/erkek")
    }
    }, update = {
        it.loadUrl("https://www.trendyol.com/butik/liste/2/erkek")
    })
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JPComposeWebViewDenemeTheme {
        Greeting()
    }
}