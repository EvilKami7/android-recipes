package com.example.lesson_10

import android.app.Application
import com.example.lesson_10.data.Api
import com.example.lesson_10.data.NetworkService
import com.example.lesson_10.data.Repository

class App : Application() {


    companion object {
        lateinit var networkService: Api
        lateinit var repository: Repository

        fun initNetworkService(network: Api) {
            networkService = network
        }

        fun initRepository(rep: Repository) {
            repository = rep
        }
    }

    override fun onCreate() {
        super.onCreate()
        initNetworkService(NetworkService.networkService())
        initRepository(Repository())
    }
}