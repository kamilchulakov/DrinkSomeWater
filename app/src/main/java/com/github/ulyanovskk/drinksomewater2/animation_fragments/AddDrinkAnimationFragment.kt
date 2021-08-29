package com.github.ulyanovskk.drinksomewater2.animation_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.github.ulyanovskk.drinksomewater2.R

class AddDrinkAnimationFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_drink_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animationView = view.findViewById<LottieAnimationView>(R.id.add_animation_view)
        animationView.addAnimatorListener(NavigationAnimatorListener(findNavController(), R.id.action_addDrinkAnimationFragment_to_drinkFragment24))
    }
}