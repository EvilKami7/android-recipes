package com.example.lesson_10.ui.mvvm.details

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Html
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.lesson_10.R



class MvvmDetailsActivity :AppCompatActivity(){
    private val mvvmDetailsViewModel: MvvmDetailsViewModel by viewModels {MvvmDetailsViewModelFactory(uuid)}
    lateinit var uuid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uuid = getIntent().getSerializableExtra("id").toString()
        setContentView(R.layout.activity_mvvm_details)
        initViews()
    }

    private fun initViews() {
        mvvmDetailsViewModel.recipe.observe(this) {
            findViewById<ViewPager2>(R.id.viewPager2).adapter = PagerAdapter(it.images)
            findViewById<TextView>(R.id.details_name).text = it.name
            findViewById<RatingBar>(R.id.difficultyBar).rating = it.difficulty.toFloat()
            val detailsTextView = findViewById<TextView>(R.id.details_description)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                detailsTextView.setText(Html.fromHtml(it.instructions, Html.FROM_HTML_MODE_COMPACT));
            } else {
                detailsTextView.setText(Html.fromHtml(it.instructions));
            }
        }

        mvvmDetailsViewModel.errorMessage.observe(this) {message->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        mvvmDetailsViewModel.isLoading.observe(this){
            if(it) {
                findViewById<ProgressBar>(R.id.mvvmDetailsProgressBar).visibility = View.VISIBLE
                findViewById<ScrollView>(R.id.mvvmScrollView2).visibility = View.INVISIBLE
            }
            else {
                findViewById<ProgressBar>(R.id.mvvmDetailsProgressBar).visibility = View.INVISIBLE
                findViewById<ScrollView>(R.id.mvvmScrollView2).visibility = View.VISIBLE
            }
        }
    }


}