package com.ermolaevio.anim.ch8.lesson43

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_spring_animation.*

class SpringPhysicsAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring_animation)

        val detector = GestureDetectorCompat(this, CustomGestureListener(bottomSheet))

        bottomSheet.setOnTouchListener { _, motionEvent ->
            detector.onTouchEvent(motionEvent)
        }
    }
}