package com.coca.bakingapp20

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = RecipeRepository()

    private val _myRecipe = MutableLiveData<List<Recipe>>()
    val myRecipe: LiveData<List<Recipe>>
        get() = _myRecipe

    fun getRecipes() {
        viewModelScope.launch {
            _myRecipe.value = repository.getRecipes()
        }
    }
}
