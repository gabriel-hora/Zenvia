package com.example.poczenvia.data.network.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.poczenvia.data.network.ui.MainViewModel
import com.example.poczenvia.data.network.repository.RepositoryCall
import com.example.poczenvia.databinding.ActivityMainBinding
import com.example.poczenvia.data.network.ViewModelProvider
import com.example.poczenvia.data.network.response.OriginRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.time.LocalDateTime

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
                it.body()?.dados?.let { it1 -> Log.i("urlZenMA", it1.url) }

                val webPage = Uri.parse(it.body()?.dados?.url)
                val intent = Intent(Intent.ACTION_VIEW, webPage)
                startActivity(intent)
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
                Log.i("messagem", it.body().toString())
                Log.i("messagem", it.code().toString() + " code")
            }
        })
    }

    private fun callFast() {
        binding.btnCallFast.setOnClickListener {
            viewModel.pushCallFast(
                "floating",
                716148,
                "4000",
                "11977527475",
                false
            )
        }
    }

    private fun saveDataId(idCall: String) {
        if (idCall != null) {
            val ref: DatabaseReference = FirebaseDatabase.getInstance().reference

            val idFirebase = ref.push().key

            if (idFirebase != null) {
                ref.child("user").child(idFirebase).setValue(idCall)
            }
        }
    }
}
