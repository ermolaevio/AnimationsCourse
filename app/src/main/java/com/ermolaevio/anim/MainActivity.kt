package com.ermolaevio.anim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.activity2.ActivityA
import com.ermolaevio.anim.ch1_constraint.constraintSet.ConstraintSetActivity
import com.ermolaevio.anim.ch1_constraint.group.GroupAnimationActivity
import com.ermolaevio.anim.ch1_constraint.group.LinearRelativeAnimationActivity
import com.ermolaevio.anim.ch1_constraint.lesson_5_Placeholder.PlaceholderActivity
import com.ermolaevio.anim.ch2.lesson11.A_Activity
import com.ermolaevio.anim.ch2.lesson12.BackgroundAnim
import com.ermolaevio.anim.ch2.lesson7_android_view_anim.ClassicAnimation
import com.ermolaevio.anim.ch2.lesson9.AnimResourcesActivity
import com.ermolaevio.anim.ch4.lesson16.SeveralAnimators
import com.ermolaevio.anim.ch4.lesson15.SimpleAnimator
import com.ermolaevio.anim.ch4.lesson17.SimpleViewProperty
import com.ermolaevio.anim.ch4.lesson18.FromAnimatorResources
import com.ermolaevio.anim.ch5.lesson20.SimpleTransitionActivity
import com.ermolaevio.anim.ch5.lesson21.TransitionResourcesActivity
import com.ermolaevio.anim.ch6.lesson24.ExplodeSlideTransition
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

        constSetBtn8.setOnClickListener {
            Intent(this@MainActivity, A_Activity::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn9.setOnClickListener {
            Intent(this@MainActivity, BackgroundAnim::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn10.setOnClickListener {
            Intent(this@MainActivity, SimpleAnimator::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn11.setOnClickListener {
            Intent(this@MainActivity, SeveralAnimators::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn12.setOnClickListener {
            Intent(this@MainActivity, SimpleViewProperty::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn13.setOnClickListener {
            Intent(this@MainActivity, FromAnimatorResources::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn14.setOnClickListener {
            Intent(this@MainActivity, SimpleTransitionActivity::class.java).apply {
                startActivity(this)
            }
        }
        constSetBtn15.setOnClickListener {
            Intent(this@MainActivity, TransitionResourcesActivity::class.java).apply {
                startActivity(this)
            }
        }

        constSetBtn16.setOnClickListener {
            Intent(this@MainActivity, ExplodeSlideTransition::class.java).apply {
                startActivity(this)
            }
        }
    }
}
