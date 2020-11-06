package com.example.lesson_10.ui.mvvm.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson_10.App
import com.example.lesson_10.data.objects.Recipe

class MvvmMainViewModel : ViewModel() {

    val recipeList = MutableLiveData<List<Recipe>>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        isLoading.postValue(true)
        fetchData()
    }

    private fun fetchData() {
        App.repository.fetchRecipeList(
            onResult = {
                recipeList.postValue(it)
                isLoading.postValue(false)
            },
            onError = {
                errorMessage.postValue(it)
                isLoading.postValue(false)
            }
        )
    }

    fun refresh() {
        isLoading.postValue(true)
        fetchData()
    }
}