package com.ermolaevio.anim.ch1_constraint.group

import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import com.ermolaevio.anim.R

class GroupAnimationActivity : AppCompatActivity() {

    private lateinit var group: Group
    private lateinit var start: Button
    private lateinit var rootLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        group = findViewById(R.id.group)
        start = findViewById(R.id.start)
        rootLayout = findViewById(R.id.rootLayout)

        start.setOnClickListener {
            start.visibility = View.GONE
            group.visibility = View.VISIBLE

            val fade = Fade().apply {
                duration = 1000
            }
            TransitionManager.beginDelayedTransition(rootLayout, fade)
        }
    }
}