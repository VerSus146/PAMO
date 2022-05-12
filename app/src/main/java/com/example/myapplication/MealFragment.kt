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
import com.example.myapplication.databinding.FragmentMealBinding
import java.util.*

internal class Meal(private val name: String?, private val description: String?) {
    fun getName(): String? {
        return name
    }

    fun getDescription(): String? {
        return description
    }
}

class MealFragment : Fragment() {
    private var binding: FragmentMealBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMealBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        run {
            val recipes: MutableList<String?> = ArrayList()
            recipes.add("Pizza is a savory dish of Italian origin, consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients (anchovies, olives, meat, etc.) baked at a high temperature, traditionally in a wood-fired oven.")
            recipes.add("Spaghetti is a type of noodle dish from the Italian cuisine. It is a staple food of Italian cuisine and is often served as an individual serving, as opposed to as part of a main meal.")
            binding?.BMRMeal?.setOnClickListener {
                NavHostFragment.findNavController(this@MealFragment)
                        .navigate(R.id.action_mealFragment_to_SecondFragment)
            }
            binding?.BMIMeal?.setOnClickListener {
                NavHostFragment.findNavController(this@MealFragment)
                        .navigate(R.id.action_mealFragment_to_FirstFragment)
            }
            val random = Random()
            binding?.RecipeText?.text = recipes[random.nextInt(recipes.size)]
        }
    }

    companion object {
        fun newInstance(): MealFragment? {
            val fragment = MealFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}