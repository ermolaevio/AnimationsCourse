package com.ermolaevio.anim.ch5.lesson21

import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ermolaevio.anim.R
import kotlinx.android.synthetic.main.activity_transtion_resources.*

class TransitionResourcesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainScene: Scene
    private lateinit var loginScene: Scene
    private lateinit var signUpScene: Scene
    private lateinit var transitionSet: TransitionSet // never used
    private lateinit var transitionMng: TransitionManager

    private lateinit var loginBtn: View
    private lateinit var signUpBtn: View

    private var started = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transtion_resources)

        mainScene = Scene.getSceneForLayout(
            root,
            R.layout.activity_transtion_resources,
            applicationContext
        )
        loginScene = Scene.getSceneForLayout(
            root,
            R.layout.layout_login,
            applicationContext
        )
        signUpScene = Scene.getSceneForLayout(
            root,
            R.layout.layout_signup,
            applicationContext
        )
        /**
         * Должны совпадать ids. Работает ок только на новых версиях,
         * ниже 7 стандартная тема применяется некорректно к элементам,
         * эдиттексты будут белыми
         */

        transitionSet = TransitionInflater.from(applicationContext)
            .inflateTransition(R.transition.my_transitions) as TransitionSet

        transitionMng = TransitionInflater.from(applicationContext)
            .inflateTransitionManager(R.transition.transition_mgr, root)

        loginBtn = findViewById<View>(R.id.login).apply {
            setOnClickListener(this@TransitionResourcesActivity)
        }
        signUpBtn = findViewById<View>(R.id.signup).apply {
            setOnClickListener(this@TransitionResourcesActivity)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.login -> {
                if (!started) {
                    transitionMng.transitionTo(loginScene)
                    started = true
                }
            }
            R.id.signup -> {
                if (!started) {
                    transitionMng.transitionTo(signUpScene)
                    started = true
                }
            }
        }
    }

    override fun onBackPressed() {
        if (started) {
            transitionMng.transitionTo(mainScene)
            findViewById<View>(R.id.login).apply {
                setOnClickListener(this@TransitionResourcesActivity)
            }
            findViewById<View>(R.id.signup).apply {
                setOnClickListener(this@TransitionResourcesActivity)
            }
            started = false
        } else {
            super.onBackPressed()
        }
    }
}