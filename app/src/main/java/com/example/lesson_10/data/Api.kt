package com.example.lesson_10.data

import com.example.lesson_10.data.objects.Recipe
import com.example.lesson_10.data.objects.RecipeWrapper
import com.example.lesson_10.data.objects.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("recipes")
    fun fetchRecipes(): Call<Recipes>

    @GET("recipes/{uuid}")
    fun fetchRecipe(@Path("uuid") id: String): Call<RecipeWrapper>

}