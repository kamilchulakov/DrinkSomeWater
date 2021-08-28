package com.github.ulyanovskk.drinksomewater2

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import java.lang.Exception

class AnimationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animationView = view.findViewById<LottieAnimationView>(R.id.animation_view)
        animationView.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                Navigation.findNavController(requireView()).navigate(R.id.drinkFragment2)
            }

            override fun onAnimationCancel(animation: Animator?) {
                Navigation.findNavController(requireView()).navigate(R.id.drinkFragment2)
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Navigation.findNavController(requireView()).navigate(R.id.drinkFragment2)
            }

        })
    }

}