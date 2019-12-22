package com.ermolaevio.anim.ch4.lesson17

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_simple_view_property.*

class SimpleViewProperty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_view_property)


        /*
         * более простой способ работы с анимацией
         */
        start.setOnClickListener {
            it.animate()
                .translationY(300F)
                .scaleX(2f)
                .alpha(0.5f)
                .setDuration(2000)
                .withEndAction {
                    Toast.makeText(this, "anim ended", Toast.LENGTH_SHORT).show()
                    // продолжаем анимацию
                    it.animate().translationY(0f).setDuration(2000).alpha(1f).scaleX(1f)
                    //.start() необязательно вызывать т.к. анимация начнется автоматически при возможности,
                    // но нужно вызвать для немедленного начала анимации
                }
        }
    }
}