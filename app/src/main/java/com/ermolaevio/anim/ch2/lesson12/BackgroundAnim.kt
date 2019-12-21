package com.ermolaevio.anim.ch2.lesson12

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_background.*

class BackgroundAnim : AppCompatActivity() {

    private var animRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        val animBackground = start.background as AnimationDrawable
        start.setOnClickListener {
            animRunning = if (animRunning) {
                animBackground.stop()
                start.setText(R.string.start)
                false
            } else {
                animBackground.start()
                start.setText(R.string.stop)
                true
            }
        }
    }
}