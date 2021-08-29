package com.github.ulyanovskk.drinksomewater2.drink_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.github.ulyanovskk.drinksomewater2.R
import com.github.ulyanovskk.drinksomewater2.model.Note
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textview.MaterialTextView


class DrinkFragment : Fragment() {
    private lateinit var viewModel: DrinkViewModel
    private lateinit var percentsView: TextView
    private lateinit var progressView: TextView
    private lateinit var defaultValuesForCups: IntArray
    private var drinkSize = 200
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        percentsView = requireView().findViewById(R.id.percentage)
        progressView = requireView().findViewById(R.id.todayProgressText)
        requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView).isVisible = true
        requireView().findViewById<Button>(R.id.drinkBtn).setOnClickListener {
            viewModel.noteCopy.progress += getCheckedChipValue() ?: drinkSize
            viewModel.saveData()
            val navController = Navigation.findNavController(requireView())
            navController.navigate(R.id.addDrinkAnimationFragment)
        }
        requireView().findViewById<Button>(R.id.sugarBtn).setOnClickListener {
            viewModel.noteCopy.progress = 0
            viewModel.saveData()
            findNavController().navigate(R.id.sugarFragment)
        }
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        defaultValuesForCups = intArrayOf(Integer.parseInt(sharedPreferences.getString("glass", "200") ?: "200")
            , Integer.parseInt(sharedPreferences.getString("cup", "300") ?: "300"), 500)
        requireView().findViewById<MaterialTextView>(R.id.hintGlass).text = "${defaultValuesForCups[0]} ml"
        drinkSize = defaultValuesForCups[0]
        requireView().findViewById<MaterialTextView>(R.id.hintCup).text = "${defaultValuesForCups[1]} ml"

        viewModel = DrinkViewModel(requireContext())
        viewModel.liveData.observe(viewLifecycleOwner, Observer{
                note -> if (note != null) {
                            updateUI(note)
                        }
        })


    }

    private fun updateUI(note: Note) {
        percentsView.text = (note.progress * 100 / note.goal).toString() + "%"
        progressView.text = "${note.progress}/${note.goal} ml"
    }

    private fun getCheckedChipValue(): Int? {
        val chipGroup = requireView().findViewById<ChipGroup>(R.id.chipGroup)
        val ids: List<Int> = chipGroup.checkedChipIds
        for (id in ids) {
            val chip: Chip = chipGroup.findViewById(id)
            return defaultValuesForCups[chip.id % 10]
        }
        return null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

    override fun onDestroy() {
        viewModel.saveData()
        super.onDestroy()
    }

}