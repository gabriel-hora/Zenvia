package com.example.poczenvia.data.network.ui

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.poczenvia.BuildConfig
import com.example.poczenvia.databinding.ActivityWebphoneBinding
import com.zenvia.api.sdk.client.apache.Client

class WebphoneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebphoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebphoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")

        binding.tvUrl.text = url

        binding.webViewPhone.settings.javaScriptEnabled = true
        binding.webViewPhone.loadUrl("file:///android_asset/zenvia.html")
        binding.webViewPhone.webChromeClient = WebChromeClient()
        // TODO : Resolver problema de chamada no webview.
    }
}