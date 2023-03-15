package com.example.poczenvia

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.poczenvia.data.network.repository.RepositoryCall
import com.example.poczenvia.databinding.ActivityMainBinding
import com.example.poczenvia.data.network.ViewModelProvider
import com.example.poczenvia.data.network.response.OriginRequest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callFast()
        val repository = RepositoryCall()
        val viewModelFactory = ViewModelProvider(repository)
        viewModel = androidx.lifecycle.ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

        viewModel.call.observe(this, Observer {
            if (it.isSuccessful) {
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show()
                Log.i("messagem", it.body().toString())
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                Log.i("messagem", it.body().toString())
                Log.i("messagem", it.code().toString() + " code")
            }
        })
    }

    private fun callFast() {
        // val current = LocalDateTime.now()
        binding.btnCallFast.setOnClickListener {
            viewModel.pushCallFast(
                OriginRequest(
                    numeroOrigem = "11977527475",
                    numeroDestino = "11971587577",
                    dataCriacao = null,
                    gravarAudio = null,
                    binaOrigem = null,
                    binaDestino = null,
                    tags = null,
                    detectaCaixaOrigem = null
                )
            )
        }
    }
}
