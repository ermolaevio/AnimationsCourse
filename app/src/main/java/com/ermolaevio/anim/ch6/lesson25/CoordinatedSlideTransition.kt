package com.ermolaevio.anim.ch6.lesson25

import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_coordinated_slide_transiotion.*

class CoordinatedSlideTransition : AppCompatActivity() {

    private val transitionDuration = 100L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinated_slide_transiotion)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        for (i in 0 until linearLayout.childCount) {
            val view: View = linearLayout.getChildAt(i)

            view.postDelayed({
                TransitionManager.beginDelayedTransition(linearLayout, Slide(Gravity.END))
                view.visibility = if (view.visibility == View.VISIBLE) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
            }, transitionDuration * i)
        }
        return super.onOptionsItemSelected(item)
    }
}