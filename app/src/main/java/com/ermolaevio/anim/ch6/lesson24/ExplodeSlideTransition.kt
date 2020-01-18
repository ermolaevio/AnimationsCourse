package com.ermolaevio.anim.ch6.lesson24

import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_explose_slide_transitions.*

class ExplodeSlideTransition : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explose_slide_transitions)

        start.setOnClickListener {
            /**
             * новые транзакции появились в Lolipop
             */

            TransitionManager.beginDelayedTransition(
                findViewById(android.R.id.content),

//                Explode()
                Slide(Gravity.BOTTOM) // указывается в какую сторону view будет скрываться
            )

            image.visibility = if (image.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            image2.visibility = if (image2.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }
    }
}