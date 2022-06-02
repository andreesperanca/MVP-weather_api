package com.voltaire.weather_api.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.voltaire.weather_api.R
import com.voltaire.weather_api.data.SearchRemoteDataSource
import com.voltaire.weather_api.databinding.ActivitySearchByCityBinding

class SearchByCity : AppCompatActivity() {

    private lateinit var binding : ActivitySearchByCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchByCityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSearch.setOnClickListener {
            val cState = binding.editTextSearch.text.toString()
            if (verifyTxtField()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("cState", cState)
                startActivity(intent)
            } else {
                Toast.makeText(this, R.string.invalidV, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verifyTxtField(): Boolean {
        val cState = binding.editTextSearch.text
        return cState != null  && cState.isNotBlank() && cState.isNotEmpty()
    }
}