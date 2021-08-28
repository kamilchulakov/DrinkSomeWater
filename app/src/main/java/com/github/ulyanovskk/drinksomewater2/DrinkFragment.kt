package com.github.ulyanovskk.drinksomewater2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class DrinkFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireView().findViewById<Button>(R.id.drinkBtn).setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.addDrinkAnimationFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

}