package com.example.lesson_10.ui.mvp.main

import com.example.lesson_10.data.objects.Recipe

interface IMainView {
    fun showList(list: List<Recipe>)
    fun showLoader(flag: Boolean)
    fun showError(message: String)
}

interface IMainPresenter {
    fun init()
    fun destroy()
    fun refresh()
}