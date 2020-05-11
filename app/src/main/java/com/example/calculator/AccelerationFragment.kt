package com.example.calculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_acceleration.*

/**
 * A simple [Fragment] subclass.
 */
class AccelerationFragment : Fragment() {

    private var done : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acceleration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        buttonAccelerationSubmit.setOnClickListener {

            if (!done) {
                val force: Int = editTextForce.text.toString().toInt()
                val mass = editTextMass.text.toString().toInt()
                val acceleration = calculateAcceleration(force, mass)

                val formattedString =
                    " The Acceleration of an object with a force of   ${force.toString()} " +
                            "and a mass of ${mass.toString()} is equal to " +
                            "${acceleration.toString()} m/s"

                //Add Text To Text View and make visible
                textViewAccelerationResult.text = formattedString
                textViewAccelerationResult.visibility = View.VISIBLE

                //Hide Keyboard
                val imm =
                    activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(requireView().windowToken, 0)

                buttonAccelerationSubmit.text = getString(R.string.done)
                done = true

            }else{
                it.findNavController().navigate(R.id.action_accelerationFragment_to_doneFragment)
            }
        }


    }

    private fun calculateAcceleration(force: Int, mass: Int): Int {
        return force / mass
    }

}
