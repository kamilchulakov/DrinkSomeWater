package com.github.ulyanovskk.drinksomewater2.animation_fragments

import android.animation.Animator
import androidx.navigation.NavController

class NavigationAnimatorListener(private val navController: NavController, private val action: Int,): Animator.AnimatorListener {
    override fun onAnimationStart(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
        navController.navigate(action)
    }

    override fun onAnimationCancel(animation: Animator?) {
        navController.navigate(action)
    }

    override fun onAnimationRepeat(animation: Animator?) {
        navController.navigate(action)
    }
}