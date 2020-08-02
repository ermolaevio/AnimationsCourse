package com.ermolaevio.anim.ch8.lesson42

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import kotlin.math.abs

class CustomGestureListener(
    private val animated: View,
    private val minY: Float,
    private val maxY: Float,
    private val minX: Float,
    private val maxX: Float
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
        if (abs(velocityX) == abs(velocityY)) {
            return super.onFling(e1, e2, velocityX, velocityY)
        }

        if (abs(velocityX) > abs(velocityY)) {
            startFling(DynamicAnimation.X, minX, maxX, velocityX)
        } else {
            startFling(DynamicAnimation.Y, minY, maxY, velocityY)
        }

        return super.onFling(e1, e2, velocityX, velocityY)
    }

    private fun startFling(
        property: DynamicAnimation.ViewProperty,
        min: Float,
        max: Float,
        velocity: Float
    ) {
        FlingAnimation(animated, property).apply {
            setMinValue(min)
            setMaxValue(max)
            setStartVelocity(velocity)
            start()
        }
    }
}