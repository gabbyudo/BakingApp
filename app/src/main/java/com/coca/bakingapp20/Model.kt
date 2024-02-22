package com.coca.bakingapp20

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Recipe (
    val id : Int,
    val name : String,
    val ingredients : List<Ingredient>,
    val steps: List<Step>,
    val servings: Int,
    val image: String
    ): Parcelable

@Parcelize
data class Ingredient (
    val quantity : Double,
    val measure : String,
    val ingredient: String
): Parcelable

@Parcelize
data class Step (
    val id: Int,
    val shortDescription: String,
    //val description: String,
    val videoURL: String?,
    //val thumbnailURL: String
):Parcelable