package com.example.lesson_10.ui.mvvm.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lesson_10.App
import com.example.lesson_10.data.objects.Recipe

class MvvmDetailsViewModelFactory(private val uuid: String): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MvvmDetailsViewModel(uuid) as T
}

class MvvmDetailsViewModel(private val uuid: String): ViewModel() {
    val recipe = MutableLiveData<Recipe>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        isLoading.postValue(true)
        fetchData()
    }

    private fun fetchData() {
        App.repository.fetchRecipe(uuid,
            onResult = {
                recipe.postValue(it)
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