package com.ermolaevio.anim.ch2.lesson9

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_resources.*

class AnimResourcesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resources)

        start.setOnClickListener {
            val anim1 = AnimationUtils.loadAnimation(this, R.anim.animate_one)
            val anim2 = AnimationUtils.loadAnimation(this, R.anim.animate_two)

            it.startAnimation(anim1)
            heart.startAnimation(anim2)
        }

    }
}