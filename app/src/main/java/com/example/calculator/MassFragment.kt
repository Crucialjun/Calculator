package com.example.calculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.fragment_mass.*

/**
 * A simple [Fragment] subclass.
 */
class MassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonMassSubmit.setOnClickListener {
            val force : Int = editTextForce.text.toString().toInt()
            val acceleration = editTextAcceleration.text.toString().toInt()
            val mass  = calculatemass(force,acceleration)

            val formattedString = " The mass of an object with a force of   ${force.toString()} " +
                    "and an acceleration of ${acceleration.toString()} is equal to " +
                    "${mass.toString()} Kgs"

            //Add Text To Text View and make visible
            textViewMassResult.text = formattedString
            textViewMassResult.visibility = View.VISIBLE

            //Hide Keyboard
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireView().windowToken, 0)
        }


    }

    private fun calculatemass(force: Int, acceleration: Int): Int {
        return force / acceleration
    }

}
