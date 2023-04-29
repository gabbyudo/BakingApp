package com.coca.bakingapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.coca.bakingapp20.databinding.ActivityMainBinding
import com.coca.bakingapp20.databinding.DetailDisplayBinding

class DetailDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("dre", "juy")
        val recipe: Recipe? = intent!!.getParcelableExtra<Recipe>(RECIPE)
        if (recipe !== null) {
            return
        }





    }

    companion object {
        const val RECIPE = "extra_position"
        private const val DEFAULT = -1
    }
}



