package com.coca.bakingapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coca.bakingapp20.databinding.ActivityMainBinding
import com.coca.edittextapp.RecipeAdapter
import com.coca.edittextapp.RecipeListener

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

   viewModel.myRecipe.observe(this,Observer {
       if (it != null){
           adapter = RecipeAdapter(RecipeListener {

               val intent = Intent(this, DetailDisplayActivity::class.java)
               intent.putExtra(DetailDisplayActivity.RECIPE, it)
               startActivity(intent)
           })
           binding.recipeRV.adapter = adapter
           adapter.submitList(it)
       }
   })
        viewModel.getRecipes()
    }
}
