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
import com.example.myapplication.databinding.FragmentQuizBinding
import java.util.*

class Question(private val Question: String?, private val Answers: MutableList<String?>?, private val CorrectAnswer: Int) {
    fun getQuestion(): String? {
        return Question
    }

    fun getAnswers(): MutableList<String?>? {
        return Answers
    }

    fun getCorrectAnswer(): Int {
        return CorrectAnswer
    }
}

class QuizFragment : Fragment() {
    fun setQuestion(question: Question): Int {
        binding?.Question?.text = question.getQuestion()
        binding?.answer1?.text = question.getAnswers()?.get(0)
        binding?.answer2?.text = question.getAnswers()?.get(1)
        return question.getCorrectAnswer()
    }

    var points = 0
    var currentQuestion = 0
    private var binding: FragmentQuizBinding? = null
    var random: Random? = Random()
    val questions: Array<Question?>? = arrayOf(
            Question("How many calories are in a banana?", Arrays.asList("100", "200"), 1),
            Question("How many calories are in a chocolate bar?", Arrays.asList("300", "200"), 0),
            Question("How many calories are in a piece of cake?", Arrays.asList("400", "300"), 0),
            Question("How many calories are in a piece of chocolate?", Arrays.asList("100", "400"), 1),
            Question("How many calories are in a piece of ice cream?", Arrays.asList("100", "300"), 2),
            Question("How many calories are in a piece of bread?", Arrays.asList("100", "200"), 0),
            Question("How many calories are in a piece of candy?", Arrays.asList("100", "200"), 1),
            Question("How many calories are in a piece of pie?", Arrays.asList("400", "200"), 0),
            Question("How many calories are in a piece of pasta?", Arrays.asList("100", "200"), 0),
            Question("How many calories are in a piece of salmon?", Arrays.asList("100", "400"), 3),
            Question("How many calories are in a piece of chicken?", Arrays.asList("100", "300"), 2),
            Question("How many calories are in a piece of steak?", Arrays.asList("100", "200"), 0),
            Question("How many calories are in a piece of pizza?", Arrays.asList("100", "200"), 1),
            Question("How many calories are in a piece of bread?", Arrays.asList("100", "200"), 0),
            Question("How many calories are in a piece of ice cream?", Arrays.asList("300", "200"), 2)
    )
    var question: Question? = null
    var CorrectAnswer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        run {
            question = random?.let { questions?.get(it.nextInt(questions.size + 1)) }
            CorrectAnswer = question?.let { setQuestion(it) }!!
            binding?.submitAnswer?.setOnClickListener {
                if (binding?.answer1?.isChecked == true) {
                    if (CorrectAnswer == 0) {
                        points++
                    }
                }
                if (binding?.answer2?.isChecked == true) {
                    if (CorrectAnswer == 1) {
                        points++
                    }
                }
                currentQuestion++
                if (currentQuestion == 6) {
                    binding?.radioGroup?.visibility = View.GONE
                    binding?.submitAnswer?.visibility = View.GONE
                    binding?.Question?.text = "You scored $points out of 6"
                    binding?.ExitButton?.visibility = View.VISIBLE
                } else {
                    binding?.radioGroup?.clearCheck()
                    question = random?.let { it1 -> questions?.get(it1.nextInt(questions.size + 1)) }
                    CorrectAnswer = question?.let { it1 -> setQuestion(it1) }!!
                }
            }
            binding?.ExitButton?.setOnClickListener {
                NavHostFragment.findNavController(this@QuizFragment)
                        .navigate(R.id.action_quizFragment_to_helloFragment)
            }
        }
    }

    companion object {
        fun newInstance(param1: String?, param2: String?): QuizFragment? {
            val fragment = QuizFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}