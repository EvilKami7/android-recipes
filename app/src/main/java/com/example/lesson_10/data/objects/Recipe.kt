package com.example.lesson_10.data.objects

import com.google.gson.annotations.SerializedName

data class Recipe(

    @SerializedName("uuid")
    val uuid: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("images")
    val images: List<String>,

    @SerializedName("description")
    val description: String,

    @SerializedName("instructions")
    val instructions: String,

    @SerializedName("difficulty")
    val difficulty: Int
)