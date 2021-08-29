package com.github.ulyanovskk.drinksomewater2.animation_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.github.ulyanovskk.drinksomewater2.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainAnimationFragment : Fragment() {

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
        animationView.addAnimatorListener(NavigationAnimatorListener(findNavController(), R.id.action_animationFragment_to_drinkFragment2))
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView).isVisible = false
    }

}