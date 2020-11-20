package com.example.lesson_10.data.objects

import com.google.gson.annotations.SerializedName

data class Recipes (
    @SerializedName("recipes")
    val recipes: List<Recipe>
)