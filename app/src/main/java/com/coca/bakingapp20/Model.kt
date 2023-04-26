package com.coca.bakingapp20

data class Recipe (
    val id : Int,
    val name : String,
    val ingredients : List<Ingredient>,
    val steps: List<Step>,
    val servings: Int,
    val image: String


)

data class Ingredient (
    val quantity : Double,
    val measure : String,
    val ingredient: String
)
data class Step (
    val id: Int,
    val shortDescription: String,
    val description: String,
    val videoURL: String,
    val thumbnailURL: String
)