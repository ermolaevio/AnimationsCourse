package com.ermolaevio.anim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.activity2.ActivityA
import com.ermolaevio.anim.ch1_constraint.constraintSet.ConstraintSetActivity
import com.ermolaevio.anim.ch1_constraint.group.GroupAnimationActivity
import com.ermolaevio.anim.ch1_constraint.group.LinearRelativeAnimationActivity
import com.ermolaevio.anim.ch1_constraint.lesson_5_Placeholder.PlaceholderActivity
import com.ermolaevio.anim.ch2.lesson7_android_view_anim.ClassicAnimation
import com.ermolaevio.anim.ch2.lesson9.AnimResourcesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constBtn.setOnClickListener {
            Intent(this@MainActivity, GroupAnimationActivity::class.java).apply {
                startActivity(this)
            }
        }

        relativeBtn.setOnClickListener {
            Intent(this@MainActivity, LinearRelativeAnimationActivity::class.java).apply {
                startActivity(this)
            }
        }

        openAnimBtn.setOnClickListener {
            Intent(this@MainActivity, ActivityA::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn4.setOnClickListener {
            Intent(this@MainActivity, ConstraintSetActivity::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn5.setOnClickListener {
            Intent(this@MainActivity, PlaceholderActivity::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn6.setOnClickListener {
            Intent(this@MainActivity, ClassicAnimation::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn7.setOnClickListener {
            Intent(this@MainActivity, AnimResourcesActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}
