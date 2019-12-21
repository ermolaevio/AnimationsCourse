package com.ermolaevio.anim.ch4.lesson15

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_simple_animator.*

/*
* Object Animator
**/
class SimpleAnimator : AppCompatActivity() {

    lateinit var objectAnim: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_animator)

        start.setOnClickListener {

            /*
            * https://developer.android.com/guide/topics/graphics/prop-animation.html#object-animator
            * закидываем обьект и названия свойства и оно будет обновляться через set метод
            * а для получения будет использоваться get
            **/
            objectAnim = ObjectAnimator.ofFloat(start, "alpha", 1f, .2f)
            objectAnim.duration = 1000
            objectAnim.repeatCount = ObjectAnimator.INFINITE
            objectAnim.repeatMode = ObjectAnimator.REVERSE
            objectAnim.start()
        }
    }
}