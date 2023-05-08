package com.coca.bakingapp20

class RecipeRepository() {
    private fun getIngredients(): List<Ingredient> {
        val firstIngredient = Ingredient(2.0, "cup", "maggi")
        val secondIngredient = Ingredient(30.0, "plate", "salt")
        val myIngredient = listOf<Ingredient>(firstIngredient, secondIngredient)
        return myIngredient
    }

    private fun getSteps(): List<Step> {
        val firstStep = Step(1, "", "hytrfds", "", "")
        val secondStep = Step(3, "", "mkijuhg", "", "")
        val myStep = listOf<Step>(firstStep, secondStep)
        return myStep
    }

    fun getRecipes(): List<Recipe> {
        val firstRecipe = Recipe(
            1, "Nutella Pie", getIngredients(), getSteps(), 1, ""
        )
        val secondRecipe = Recipe(1, "Brownies", getIngredients(), getSteps(), 1, "")

        val myRecipe = listOf<Recipe>(firstRecipe, secondRecipe)
        return myRecipe
    }
}
