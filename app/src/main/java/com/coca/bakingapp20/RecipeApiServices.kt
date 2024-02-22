package com.coca.bakingapp20

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://d17h27t6h515a5.cloudfront.net/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface RecipeApiService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun getRecipe():
            List<Recipe>
}

object RecipeApi {
    val retrofitService : RecipeApiService =
        retrofit.create(RecipeApiService::class.java)

}

