package com.ermolaevio.anim.ch4.lesson18

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_from_animator_resources.*

class FromAnimatorResources : AppCompatActivity() {

    lateinit var animSet: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_from_animator_resources)

        animatedObject.setOnClickListener { img ->
            animSet = AnimatorInflater.loadAnimator(this, R.animator.my_animator) as AnimatorSet
            with(animSet) {
                duration = 2000
                setTarget(img)
                start()
            }
        }
    }
}