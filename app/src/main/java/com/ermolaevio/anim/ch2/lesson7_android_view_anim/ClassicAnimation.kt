package com.ermolaevio.anim.ch2.lesson7_android_view_anim

import android.os.Bundle
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_classic.*

class ClassicAnimation : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classic)

        val translateAnimation = TranslateAnimation(0f, 200f, 0f, 200f)
        val rotateAnimation = RotateAnimation(0f, 360f)
        val scaleAnimation = ScaleAnimation(0f, 3f, 0f, 3f)

        val set = AnimationSet(this, null).apply {
            addAnimation(translateAnimation)
            addAnimation(rotateAnimation)
            addAnimation(scaleAnimation)
            // без этого анимация будет незаметна
            duration = 4000
        }
        hello.setOnClickListener {
            it.startAnimation(set)
        }
    }
}