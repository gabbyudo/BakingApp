package com.coca.bakingapp20

import android.icu.util.Measure
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.StringRes
import com.coca.bakingapp20.databinding.DetailDisplayBinding
import com.squareup.picasso.Picasso
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty

class DetailDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe: Recipe? = intent?.getParcelableExtra(RECIPE)
        if (recipe != null) {

           val image = binding.image
            Picasso.with(this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXWI2scXOnCZyu63frAvg2P_V7cvaHYXKKTKYg0H4kNQ&s")
                .into(image)

            binding.name.text = recipe.name
            binding.serving.text = recipe.servings.toString()


            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
               // submitting the list to the adapter. i.e the getdescription
                android.R.layout.simple_list_item_1, getDescriptions(recipe.steps)
            )
            binding.step.adapter = adapter
            //adapter.submitList(listOf<String>()) second way

            val ingredientadapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                // submitting the list to the adapter. i.e the getMappedIngredients
                android.R.layout.simple_list_item_1, getMappedIngredients(recipe.ingredients)
            )
            binding.ingredient.adapter = ingredientadapter
        }
    }



    fun getDescriptions(steps: List<Step>): List<String> {
        //map is used to convert a list  to another list
       val descriptionsMap: List<String> = steps.map {
           it.description
        }
        return descriptionsMap
    }
    fun getMappedIngredients(ingredients: List<Ingredient>): List<String>{
        return ingredients.map {
            "○ ${it.quantity} ${it.measure} ${it.ingredient}"
        }

    }

    companion object {
        const val RECIPE = "extra_recipe"
    }
}




