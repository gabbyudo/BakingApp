package com.coca.bakingapp20

class RecipeRepository() {
    suspend fun getRecipes(): List<Recipe> {
            var recipe = RecipeApi.retrofitService.getRecipe()

        return recipe
    }
}
