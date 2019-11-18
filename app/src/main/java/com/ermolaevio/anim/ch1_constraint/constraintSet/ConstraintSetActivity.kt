package com.ermolaevio.anim.ch1_constraint.constraintSet

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_constraint_set.*

class ConstraintSetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set)

        start.setOnClickListener {
            /**
             * копируем настройки размещения дочерних вью
             * и применяем к нашей разметке
             */
            ConstraintSet().apply {
                clone(this@ConstraintSetActivity, R.layout.constraint_set_copy)
                applyTo(constRoot)
            }
            /**
             * анимация при изменении точек целевых вьюх
             */
            ChangeBounds().apply {
                interpolator = OvershootInterpolator()
                duration = 2000
                TransitionManager.beginDelayedTransition(constRoot, this)
            }
        }
    }
}