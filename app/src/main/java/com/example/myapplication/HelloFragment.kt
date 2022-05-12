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
import com.example.myapplication.databinding.FragmentHelloBinding

class HelloFragment : Fragment() {
    private var binding: FragmentHelloBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHelloBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.Enter?.setOnClickListener {
            NavHostFragment.findNavController(this@HelloFragment)
                    .navigate(R.id.action_helloFragment_to_FirstFragment)
        }
        binding?.quiz?.setOnClickListener {
            NavHostFragment.findNavController(this@HelloFragment)
                    .navigate(R.id.action_helloFragment_to_quizFragment)
        }
        binding?.bmiGraphButton?.setOnClickListener {
            NavHostFragment.findNavController(this@HelloFragment)
                    .navigate(R.id.action_helloFragment_to_BMIGraphFragment)
        }
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): HelloFragment? {
            val fragment = HelloFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}