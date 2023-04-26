package com.coca.bakingapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.coca.bakingapp20.databinding.ActivityMainBinding
import com.coca.bakingapp20.databinding.DetailDisplayBinding

class DetailDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val position = intent!!.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION)
        if (position == DEFAULT_POSITION) {

            return

        }







    }

    companion object {
        const val EXTRA_POSITION = "extra_position"
        private const val DEFAULT_POSITION = -1
    }
}



