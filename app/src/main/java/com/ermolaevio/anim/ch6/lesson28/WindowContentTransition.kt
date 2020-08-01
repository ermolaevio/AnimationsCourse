package com.ermolaevio.anim.ch6.lesson28

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_window_content_transition.*

// Анимация переходов при открытии, закрытии активити с помощью window
// програмный способ создания анимации. Можно прописать в теме приложения или активити.
class WindowContentTransition : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window_content_transition)

        Explode().also {
            it.duration = 2000
            window.exitTransition = it // когда запускаем другую активити
            window.reenterTransition = it // при возвращении из пред активити
        }

        startContentTransitions.setOnClickListener {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@WindowContentTransition)
                    .toBundle()
            Intent(this, WindowContentTransitionDetails::class.java).apply {
                startActivity(this, options)
            }
        }
    }
}

class WindowContentTransitionDetails : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window_content_transition_details)

        Slide().also {
            window.allowEnterTransitionOverlap = false // не перекрывать транзакцию пред активити при открытии
            window.allowReturnTransitionOverlap = false // не перекрывать транзакцию пред активити при закрытии
            window.enterTransition = it // при старте
            window.returnTransition = it // при выходе
        }
    }
}