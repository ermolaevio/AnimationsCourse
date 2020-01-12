package com.ermolaevio.anim.ch5.lesson20

import android.os.Bundle
import android.transition.*
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.transition.doOnEnd
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_simple_transition.*

class SimpleTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_transition)

        start.setOnClickListener {
            val fade = Fade()
            val changeBounds = ChangeBounds()

            val set = TransitionSet().apply {
                addTransition(fade)
                addTransition(changeBounds)
                duration = 2000
                doOnEnd {
                    Toast.makeText(applicationContext, "Transition ended", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            val root = findViewById<ViewGroup>(android.R.id.content)
            // для эффекта перемешения должны быть одинаковые id
            val scene2 = Scene.getSceneForLayout(root, R.layout.second_layout, applicationContext)
            TransitionManager.go(scene2, set)
        }
    }
}