package com.ermolaevio.anim.ch8.lesson43

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

class CustomGestureListener(private val animatedView: View) :
    GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent?) = true

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        SpringForce().apply {
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            stiffness = SpringForce.STIFFNESS_LOW
        }
        SpringAnimation(animatedView, DynamicAnimation.Y).apply {
            animateToFinalPosition(0f)
        }

        return super.onFling(e1, e2, velocityX, velocityY)
    }
}