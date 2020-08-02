package com.ermolaevio.anim.ch8.lesson42

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation

class CustomGestureListener(
    private val animated: View,
    private val min: Float,
    private val max: Float
) : GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent?): Boolean {
        return true // ???
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {

        FlingAnimation(animated, DynamicAnimation.Y).apply {
            setMinValue(min)
            setMaxValue(max)
            setStartVelocity(velocityY)
            start()
        }

        return super.onFling(e1, e2, velocityX, velocityY)
    }
}