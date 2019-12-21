package com.ermolaevio.anim.ch2.lesson11

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_combine_a.*


class A_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combine_a)

        start.setOnClickListener {
            val viewAnim = AnimationUtils.loadAnimation(this, R.anim.animate_view)
            start.startAnimation(viewAnim)
            viewAnim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) = Unit

                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(Intent(this@A_Activity, B_Activity::class.java))
                    overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit)
                }

                override fun onAnimationStart(animation: Animation?) = Unit
            })
        }
    }

}

class B_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combine_b)
    }
}