package com.ermolaevio.anim.ch1_constraint.group

import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_with_relative.*

class LinearRelativeAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_relative)

        start.setOnClickListener {
            start.visibility = View.GONE
            linear_container.visibility = View.VISIBLE

            Fade().apply {
                duration = 2000
                TransitionManager.beginDelayedTransition(root, this)
            }
            image.visibility = View.VISIBLE
            username.visibility = View.VISIBLE
            password.visibility = View.VISIBLE
            login.visibility = View.VISIBLE
        }
    }
}