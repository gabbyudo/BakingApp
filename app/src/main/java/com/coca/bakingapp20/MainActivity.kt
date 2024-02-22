package com.coca.bakingapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coca.bakingapp20.databinding.ActivityMainBinding
import com.coca.edittextapp.RecipeAdapter
import com.coca.edittextapp.RecipeListener

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var myAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.myRecipe.observe(this, Observer {
            if (it != null) {
                myAdapter = RecipeAdapter(RecipeListener {
                    val intent = Intent(this, DetailDisplayActivity::class.java)
                    intent.putExtra(DetailDisplayActivity.BAKER, it)
                    startActivity(intent)
                })
                binding.recipeRV.adapter = myAdapter
                myAdapter.submitList(it)
            }
        })
        viewModel.getRecipes()
    }
}
