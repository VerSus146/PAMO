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
import com.example.myapplication.databinding.FragmentBMIGraphBinding
import com.jjoe64.graphview.series.DataPoint

class BMIGraphFragment : Fragment() {
    private var binding: FragmentBMIGraphBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBMIGraphBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val graph = binding?.graph as GraphView
        val series = LineGraphSeries(arrayOf<DataPoint?>(
                DataPoint(0.0, 20.0),
                DataPoint(1.0, 22.0),
                DataPoint(2.0, 27.0),
                DataPoint(3.0, 26.0),
                DataPoint(4.0, 21.0)
        ))
        graph.addSeries(series)
        binding?.ExitBMI?.setOnClickListener {
            NavHostFragment.findNavController(this@BMIGraphFragment)
                    .navigate(R.id.action_BMIGraphFragment_to_helloFragment)
        }
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): BMIGraphFragment? {
            val fragment = BMIGraphFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}