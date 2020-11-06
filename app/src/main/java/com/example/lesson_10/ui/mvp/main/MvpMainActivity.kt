package com.example.lesson_10.ui.mvp.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_10.R
import com.example.lesson_10.data.objects.Recipe
import com.example.lesson_10.ui.mvp.details.MvpDetailsActivity

class MvpMainActivity : AppCompatActivity(), IMainView {

    lateinit var presenter: MvpMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        initViews()
    }

    private fun initViews() {
        findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
    }

    private fun initPresenter() {
        presenter = MvpMainPresenter(this)
    }

    override fun showList(list: List<Recipe>) {
        val recyclerView = findViewById<RecyclerView>(R.id.mvpMainRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //TODO Adapter
        recyclerView.adapter = CustomAdapter(list, onClick = {
            val intent = Intent(this, MvpDetailsActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        })
    }

    override fun showLoader(flag: Boolean) {
        if (flag) {
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
            findViewById<RecyclerView>(R.id.mvpMainRecycler).visibility = View.GONE
        } else {
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.GONE
            findViewById<RecyclerView>(R.id.mvpMainRecycler).visibility = View.VISIBLE
        }

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}