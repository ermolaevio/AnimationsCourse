package com.ermolaevio.anim.lesson_5_Placeholder

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Placeholder
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_placeholder.*

class PlaceholderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)

        imageView1.setOnClickListener { showAnim(it) }
        imageView2.setOnClickListener { showAnim(it) }
        imageView3.setOnClickListener { showAnim(it) }
    }

    private fun showAnim(v: View) {
        ChangeBounds().apply {
            duration = 2000
            interpolator = BounceInterpolator()
            TransitionManager.beginDelayedTransition(rootLayout, this)
        }
        Placeholder(this)
        placeholder.setContentId(v.id)
    }
}