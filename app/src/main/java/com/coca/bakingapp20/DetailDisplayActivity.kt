package com.coca.bakingapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.StringRes
import com.coca.bakingapp20.databinding.DetailDisplayBinding

class DetailDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipe: Recipe? = intent?.getParcelableExtra(RECIPE)
        if (recipe != null) {
            binding.name.text = recipe.name
            binding.serving.text = recipe.servings.toString()

            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                //submitting the list to the adapter. i.e the getdescription
                android.R.layout.simple_list_item_1, getDescriptions(recipe.steps)
            )
            binding.step.adapter = adapter
            //adapter.submitList(listOf<String>()) second way
        }
    }

    fun getDescriptions(steps: List<Step>): List<String> {
        val descriptions = mutableListOf<String>()
        steps.forEach {
            descriptions.add(it.description)
        }
        return descriptions
    }

    companion object {
        const val RECIPE = "extra_recipe"
    }
}




