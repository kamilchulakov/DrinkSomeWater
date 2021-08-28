package com.github.ulyanovskk.drinksomewater2.drink_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.github.ulyanovskk.drinksomewater2.R
import com.google.android.material.chip.ChipGroup

class DrinkFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val chipGroup = requireView().findViewById<ChipGroup>(R.id.chipGroup)
        requireView().findViewById<Button>(R.id.drinkBtn).setOnClickListener {
            Log.d("CHIPS", chipGroup.checkedChipId.toString())
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