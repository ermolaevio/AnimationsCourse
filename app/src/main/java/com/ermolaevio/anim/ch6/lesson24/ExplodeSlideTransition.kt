package com.ermolaevio.anim.ch6.lesson24

import android.os.Build
import android.os.Bundle
import android.os.Handler
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
             * новые транзакции, которые появились в Lolipop
             */

            TransitionManager.beginDelayedTransition(
                findViewById(android.R.id.content),
//                Explode()
                Slide(Gravity.START) // указывается в какую сторону view будет скрываться
            )

            image.visibility = if (image.visibility == View.VISIBLE) {
                View.INVISIBLE
            } else {
                View.VISIBLE
            }

            /**
             * откладываем анимацию, чтобы вьюхи в разные стороны разъехались
             */
            Handler().postDelayed({
                TransitionManager.beginDelayedTransition(
                    findViewById(android.R.id.content),
//                Explode()
                    Slide(Gravity.END) // указывается в какую сторону view будет скрываться
                )
                image2.visibility = if (image2.visibility == View.VISIBLE) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
            }, 10)
        }
    }
}