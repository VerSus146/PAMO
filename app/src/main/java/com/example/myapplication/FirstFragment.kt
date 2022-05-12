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
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val next_fragment = view.findViewById<Button?>(R.id.next_fragment)
        val submit_button = view.findViewById<Button?>(R.id.SubmitButton)
        val WeightEditText = view.findViewById<EditText?>(R.id.WeightInput)
        val HeightEditText = view.findViewById<EditText?>(R.id.HeightInput)
        val MaleButton = view.findViewById<RadioButton?>(R.id.MaleRadio_bmr)
        val HealthTextView = view.findViewById<TextView?>(R.id.HealthText)
        val BMITextView = view.findViewById<TextView?>(R.id.BMI_Result)
        next_fragment.setOnClickListener {
            NavHostFragment.findNavController(this@FirstFragment)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding?.meal?.setOnClickListener {
            NavHostFragment.findNavController(this@FirstFragment)
                    .navigate(R.id.action_FirstFragment_to_mealFragment)
        }
        submit_button.setOnClickListener {
            val weight = WeightEditText.text.toString().toFloat()
            var height = HeightEditText.text.toString().toFloat()
            val maleChecked = MaleButton.isChecked
            height = height / 100
            val bmi = (weight / (height * height)).toDouble()
            if (maleChecked) {
                if (bmi > 19.5 && bmi < 30) {
                    HealthTextView.text = "You're Healthy."
                } else {
                    HealthTextView.text = "There's something wrong with you!"
                }
            } else {
                if (bmi > 18 && bmi < 30) {
                    HealthTextView.text = "You're Healthy."
                } else {
                    HealthTextView.text = "There's something wrong with you!"
                }
            }
            BMITextView.text = "Your BMI: $bmi"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}