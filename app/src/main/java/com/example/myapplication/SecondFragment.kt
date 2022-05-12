package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.os.Bundle
import androidx.navigation.NavController
import com.example.myapplication.R
import androidx.navigation.ui.NavigationUI
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.MealFragment
import com.example.myapplication.Question
import com.example.myapplication.QuizFragment
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.HelloFragment
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.LineGraphSeries
import com.example.myapplication.BMIGraphFragment
import com.example.myapplication.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var binding: FragmentSecondBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val submit_button = view.findViewById<Button?>(R.id.submitButton_bmr)
        val WeightEditText = view.findViewById<EditText?>(R.id.weightInput_bmr)
        val HeightEditText = view.findViewById<EditText?>(R.id.heightInput_bmr)
        val AgeEditText = view.findViewById<EditText?>(R.id.ageinput_bmr)
        val MaleButton = view.findViewById<RadioButton?>(R.id.MaleRadio_bmr)
        val BMRTextView = view.findViewById<TextView?>(R.id.BMR_Result)
        binding?.previousFragment?.setOnClickListener {
            NavHostFragment.findNavController(this@SecondFragment)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding?.mealBmr?.setOnClickListener {
            NavHostFragment.findNavController(this@SecondFragment)
                    .navigate(R.id.action_SecondFragment_to_mealFragment)
        }
        submit_button.setOnClickListener {
            var weight = WeightEditText.text.toString().toFloat()
            var height = HeightEditText.text.toString().toFloat()
            var age = AgeEditText.text.toString().toFloat()
            val maleChecked = MaleButton.isChecked
            height = height * 6.25f
            weight = weight * 10.0f
            age = age * 5.0f
            var bmr = (weight + height - age).toDouble()
            bmr = if (maleChecked) {
                bmr + 5.0f
            } else {
                bmr - 161.0f
            }
            BMRTextView.text = "Your calories: $bmr"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}