package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_force.*

/**
 * A simple [Fragment] subclass.
 */
class ForceFragment : Fragment() {

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
            val mass : Int = editTextMass.text.toString().toInt()
            val acceleration = editTextAcceleration.text.toString().toInt()
            var force  = calculateForce(mass,acceleration)

            val formattedString = " The force exerted by a mass of  ${mass.toString()} " +
                    "and an acceleration of ${acceleration.toString()} is equal to " +
                    "${force.toString()} Newtons"

            textViewForceResult.text = formattedString
            textViewForceResult.visibility = View.VISIBLE
        }


    }

    private fun calculateForce(mass: Int, acceleration: Int): Int {
        val force = mass * acceleration
        return force
    }
    }


