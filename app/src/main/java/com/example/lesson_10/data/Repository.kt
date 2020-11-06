package com.example.lesson_10.data

import com.example.lesson_10.App
import com.example.lesson_10.data.objects.Recipe
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
            object : Callback<Recipe> {
                override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                    onResult.invoke(response.body()!!)
                }

                override fun onFailure(call: Call<Recipe>, t: Throwable) {
                    onError.invoke(t.message!!)
                }

            }
        )
    }


    fun fetchRecipeList(
        onResult: (List<Recipe>) -> Unit,
        onError: (String) -> Unit,
    ): List<Recipe> {
        return listOf()
    }
}