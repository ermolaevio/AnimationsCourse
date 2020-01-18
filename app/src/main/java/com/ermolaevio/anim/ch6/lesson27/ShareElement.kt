package com.ermolaevio.anim.ch6.lesson27

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_share_element.*

class ShareElementFrom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element)

        sharedImage.setOnClickListener {

            Intent(this, ShareElementDetail::class.java).apply {

                val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@ShareElementFrom,
                    Pair(sharedImage as View, "coffee"),
                    Pair(description as View, "description")
                )
                startActivity(this, optionsCompat.toBundle())
            }
        }
    }
}

class ShareElementDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_detail)


    }
}