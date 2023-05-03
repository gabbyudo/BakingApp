package com.coca.bakingapp20

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _myRecipe = MutableLiveData<List<Recipe>>()
    val myRecipe: LiveData<List<Recipe>>
        get() = _myRecipe

    fun getRecipes(){
        val firstRecipe = Recipe(1, "Nutella Pie", getIngredients(), getSteps(), 1, ""
        )
        val secondRecipe = Recipe(1, "Brownies", getIngredients(), getSteps(), 1, "")

        val myRecipe = listOf<Recipe>(firstRecipe,secondRecipe)

        _myRecipe.value = myRecipe
    }
    fun getIngredients (): List<Ingredient>{
        val firstIngredient = Ingredient(2.0, "", "")
        val secondIngredient = Ingredient( 30.0, "", "")
        val myIngredient = listOf<Ingredient>(firstIngredient, secondIngredient)
        return myIngredient
    }

    fun getSteps(): List<Step>{
        val firstStep = Step(1, "","hytrfds", "", "")
        val secondStep =Step(3, "", "mkijuhg", "", "")
        val myStep = listOf<Step>(firstStep,secondStep)
        return myStep
    }


}