package com.example.lesson_10.ui.mvp.main

import com.example.lesson_10.data.objects.Recipe
import com.example.lesson_10.data.objects.Recipes

interface IMainView {
    fun showList(list: Recipes)
    fun showLoader(flag: Boolean)
    fun showError(message: String)
}

interface IMainPresenter {
    fun init()
    fun destroy()
    fun refresh()
}