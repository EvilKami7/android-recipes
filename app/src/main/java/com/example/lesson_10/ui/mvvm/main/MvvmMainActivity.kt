package com.example.lesson_10.ui.mvvm.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_10.R
import com.example.lesson_10.ui.mvp.details.MvpDetailsActivity
import com.example.lesson_10.ui.mvp.main.CustomAdapter

class MvvmMainActivity : AppCompatActivity() {

    private val mvvmMainViewModel: MvvmMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_main)
        initViews()
    }

    private fun initViews() {
        mvvmMainViewModel.recipeList.observe(this) { list ->
            val recyclerView = findViewById<RecyclerView>(R.id.mvvmRecycler)
            recyclerView.layoutManager = LinearLayoutManager(this)
            //TODO Adapter
            recyclerView.adapter = CustomAdapter(list, onClick = {
                val intent = Intent(this, MvpDetailsActivity::class.java)
                intent.putExtra("id", it)
                startActivity(intent)
            })
        }

        mvvmMainViewModel.errorMessage.observe(this) {message->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        mvvmMainViewModel.isLoading.observe(this) {
            if (it) {
                findViewById<ProgressBar>(R.id.mvvmProgressBar).visibility = View.VISIBLE
                findViewById<RecyclerView>(R.id.mvvmRecycler).visibility = View.GONE
            } else {
                findViewById<ProgressBar>(R.id.mvvmProgressBar).visibility = View.GONE
                findViewById<RecyclerView>(R.id.mvvmRecycler).visibility = View.VISIBLE
            }
        }
    }

}