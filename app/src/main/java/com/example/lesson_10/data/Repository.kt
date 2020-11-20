package com.example.lesson_10.data

import com.example.lesson_10.App
import com.example.lesson_10.data.objects.Recipe
import com.example.lesson_10.data.objects.RecipeWrapper
import com.example.lesson_10.data.objects.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun fetchRecipe(
        uuid: String,
        onResult: (Recipe) -> Unit,
        onError: (String) -> Unit,
    ) {
        App.networkService.fetchRecipe(uuid).enqueue(
            object : Callback<RecipeWrapper> {
                override fun onResponse(call: Call<RecipeWrapper>, response: Response<RecipeWrapper>) {
                    onResult.invoke(response.body()?.recipe!!)
                }

                override fun onFailure(call: Call<RecipeWrapper>, t: Throwable) {
                    onError.invoke(t.message!!)
                }

            }
        )
    }


    fun fetchRecipeList(
        onResult: (Recipes) -> Unit,
        onError: (String) -> Unit,
    ) {
        App.networkService.fetchRecipes().enqueue(
            object : Callback<Recipes> {
                override fun onResponse(
                    call: Call<Recipes>,
                    response: Response<Recipes>
                ) {
                    onResult.invoke(response.body()!!)
                }

                override fun onFailure(call: Call<Recipes>, t: Throwable) {
                    onError.invoke(t.message!!)
                }
            }
        )
    }
}