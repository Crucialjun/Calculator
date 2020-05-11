package com.example.calculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_force.*

/**
 * A simple [Fragment] subclass.
 */
class ForceFragment : Fragment() {

    var done = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_force, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonForceSubmit.setOnClickListener {
            if (!done) {
                val mass: Int = editTextMass.text.toString().toInt()
                val acceleration = editTextAcceleration.text.toString().toInt()
                val force = calculateForce(mass, acceleration)

                val formattedString = " The force exerted by a mass of  ${mass.toString()} " +
                        "and an acceleration of ${acceleration.toString()} is equal to " +
                        "${force.toString()} Newtons"

                //Add Text To Text View and make visible
                textViewForceResult.text = formattedString
                textViewForceResult.visibility = View.VISIBLE

                //Hide Keyboard
                val imm =
                    activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(requireView().windowToken, 0)

                buttonForceSubmit.text = getText(R.string.done)
                done = true
            }else{
                it.findNavController().navigate(R.id.action_forceFragment_to_doneFragment)
            }
        }


    }

    private fun calculateForce(mass: Int, acceleration: Int): Int {
        return mass * acceleration
    }
    }


