package com.coca.bakingapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.coca.bakingapp20.databinding.DetailDisplayBinding
import com.squareup.picasso.Picasso

class DetailDisplayActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailDisplayViewModel
    lateinit var myStepAdapter: StepAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(DetailDisplayViewModel::class.java)
        val recipe: Recipe? = intent?.getParcelableExtra(BAKER)
        val collectStep = recipe?.steps?.filter {
            it.videoURL?.isNotEmpty() ?: false
        }
        if (recipe != null) {
            val image = binding.image
            Picasso.with(this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXWI2scXOnCZyu63frAvg2P_V7cvaHYXKKTKYg0H4kNQ&s")
                .into(image)
            binding.name.text = recipe.name
            binding.serving.text = recipe.servings.toString()

            viewModel.mySteps.observe(this, Observer {
                myStepAdapter = StepAdapter(StepListener {
                    val intent = Intent(this, VideoActivity::class.java)
                    intent.putExtra(VideoActivity.BAKER, it.videoURL)
                    startActivity(intent)
                })
                if (it.isNotEmpty()) {
                    binding.stepRV.adapter = myStepAdapter
                    myStepAdapter.submitList(it)
                }
            })
            viewModel.getDescriptions(recipe.steps)

            val ingredientadapter: ArrayAdapter<String> = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, getMappedIngredients(recipe.ingredients)
            )
            binding.ingredient.adapter = ingredientadapter
        }
        binding.playButton.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            if (recipe != null) {
                intent.putExtra(VideoActivity.BAKER, collectStep?.get(0))
            }
            startActivity(intent)
        }
    }

    fun getMappedIngredients(ingredients: List<Ingredient>): List<String> {
        return ingredients.map {
            "○ ${it.quantity} ${it.measure} ${it.ingredient}"
        }
    }

    companion object {
        const val BAKER = "extra_baking"
    }
}




