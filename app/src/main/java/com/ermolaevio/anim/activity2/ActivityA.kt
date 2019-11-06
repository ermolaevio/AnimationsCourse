package com.ermolaevio.anim.activity2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        activity_a_btn.setOnClickListener {
            Intent(this@ActivityA, ActivityB::class.java).also {
                startActivity(it)
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out)
            }
        }
    }
}

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        /**
         * не уверен что оно тут должно быть,
         * а что в случае если активити будет закрываться по кнопке например
         * или по события???
         */
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out)
    }
}