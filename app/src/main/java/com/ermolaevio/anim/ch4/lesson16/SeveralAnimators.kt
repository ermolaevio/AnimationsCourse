package com.ermolaevio.anim.ch4.lesson16

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_simple_animator.*

/*
* Animation Set with Object Animators
* played at the same time
**/
class SeveralAnimators : AppCompatActivity() {


    lateinit var translateAnim: ObjectAnimator
    lateinit var xScaleAnim: ObjectAnimator
    lateinit var colorAnim: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_several_anim)

        translateAnim = ObjectAnimator.ofFloat(start, "translationY", 300f).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }
        xScaleAnim = ObjectAnimator.ofFloat(start, "scaleX", 3f).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }

        // ArgbEvaluator - преобразовывает значения в цвета
        colorAnim = ObjectAnimator.ofObject(
            start,
            "textColor",
            ArgbEvaluator(),
            ResourcesCompat.getColor(resources, R.color.colorAccent, null),
            ResourcesCompat.getColor(resources, R.color.colorPrimary, null)
        ).apply {
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }

        val set = AnimatorSet().apply {
            // не заметил разницы
            playTogether(translateAnim, xScaleAnim, colorAnim)
//            playSequentially(translateAnim, xScaleAnim, colorAnim)
            duration = 1000
            start()
        }

        start.setOnClickListener {
            if (set.isRunning) {
                set.end()
            } else {
                set.start()
            }
        }
    }
}