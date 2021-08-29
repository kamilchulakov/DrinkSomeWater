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
import com.google.android.material.snackbar.Snackbar

class SugarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animationView = view.findViewById<LottieAnimationView>(R.id.animation_sugar)
        animationView.addAnimatorListener(NavigationAnimatorListener(findNavController(), R.id.action_sugarFragment_to_drinkFragment2))
        Snackbar.make(requireView(), "Your progress was ruined!", Snackbar.LENGTH_SHORT).show()
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView).isVisible = false
    }

}