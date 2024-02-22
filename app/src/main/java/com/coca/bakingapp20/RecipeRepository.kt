package com.coca.bakingapp20

import android.util.Log

class RecipeRepository() {
    suspend fun getRecipes(): List<Recipe> {
            var recipe = RecipeApi.retrofitService.getRecipe()
        Log.e("tagz", "mmm $recipe")

        return recipe
    }
}
