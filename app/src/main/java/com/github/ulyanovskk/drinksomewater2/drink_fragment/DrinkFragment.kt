package com.github.ulyanovskk.drinksomewater2.drink_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.github.ulyanovskk.drinksomewater2.R
import com.github.ulyanovskk.drinksomewater2.model.Note

class DrinkFragment : Fragment() {
    private lateinit var viewModel: DrinkViewModel
    private lateinit var percentsView: TextView
    private lateinit var progressView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        percentsView = requireView().findViewById(R.id.percentage)
        progressView = requireView().findViewById(R.id.todayProgressText)
        requireView().findViewById<Button>(R.id.drinkBtn).setOnClickListener {
            viewModel.noteCopy.progress += 100
            viewModel.saveData()
            Navigation.findNavController(requireView()).navigate(R.id.addDrinkAnimationFragment)
        }
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

}