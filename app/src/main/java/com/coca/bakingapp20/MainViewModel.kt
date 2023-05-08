package com.coca.bakingapp20

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val repository = RecipeRepository()

    private val _myRecipe = MutableLiveData<List<Recipe>>()
    val myRecipe: LiveData<List<Recipe>>
        get() = _myRecipe

    fun getRecipes() {
        _myRecipe.value = repository.getRecipes()
    }
}
