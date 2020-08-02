package com.ermolaevio.anim.ch8.lesson42

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_fling_animation.*

class FlingPhysicsAnimActivity : AppCompatActivity(), View.OnTouchListener {

    private lateinit var detector1: GestureDetectorCompat
    private lateinit var detector2: GestureDetectorCompat
    private lateinit var detector3: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fling_animation)

        image1.setOnTouchListener(this)
        image2.setOnTouchListener(this)
        image3.setOnTouchListener(this)

        playground.viewTreeObserver.addOnGlobalLayoutListener(

            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (playground.height <= 0) return

                    val max = (playground.height - image1.height).toFloat()

                    detector1 = GestureDetectorCompat(
                        this@FlingPhysicsAnimActivity,
                        CustomGestureListener(image1, 0f, max)
                    )
                    detector2 = GestureDetectorCompat(
                        this@FlingPhysicsAnimActivity,
                        CustomGestureListener(image2, 0f, max)
                    )
                    detector3 = GestureDetectorCompat(
                        this@FlingPhysicsAnimActivity,
                        CustomGestureListener(image3, 0f, max)
                    )

                    playground.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            }
        )
    }

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (view.id) {
            R.id.image1 -> return detector1.onTouchEvent(event)
            R.id.image2 -> return detector2.onTouchEvent(event)
            R.id.image3 -> return detector3.onTouchEvent(event)
        }

        return super.onTouchEvent(event)
    }
}