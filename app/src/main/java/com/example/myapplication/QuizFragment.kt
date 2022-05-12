package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentQuizBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Question {
    private final String Question;
    private final List<String> Answers;
    private final int CorrectAnswer;

    public Question(String question, List<String> answers, int correctAnswer) {
        Question = question;
        Answers = answers;
        CorrectAnswer = correctAnswer;
    }

    public String getQuestion() {
        return Question;
    }

    public List<String> getAnswers() {
        return Answers;
    }

    public int getCorrectAnswer() {
        return CorrectAnswer;
    }
}

public class QuizFragment extends Fragment {

    int setQuestion (@NonNull Question question){
        binding.Question.setText(question.getQuestion());
        binding.answer1.setText(question.getAnswers().get(0));
        binding.answer2.setText(question.getAnswers().get(1));
        return question.getCorrectAnswer();
    }

    int points = 0;
    int currentQuestion = 0;

    private FragmentQuizBinding binding;

    Random random = new Random();

    final Question[] questions = new Question[]{
            new Question("How many calories are in a banana?", Arrays.asList("100", "200"), 1),
            new Question("How many calories are in a chocolate bar?", Arrays.asList("300", "200"), 0),
            new Question("How many calories are in a piece of cake?", Arrays.asList("400", "300"), 0),
            new Question("How many calories are in a piece of chocolate?", Arrays.asList("100", "400"), 1),
            new Question("How many calories are in a piece of ice cream?", Arrays.asList("100", "300"), 2),
            new Question("How many calories are in a piece of bread?", Arrays.asList("100", "200"), 0),
            new Question("How many calories are in a piece of candy?", Arrays.asList("100", "200"), 1),
            new Question("How many calories are in a piece of pie?", Arrays.asList("400", "200"), 0),
            new Question("How many calories are in a piece of pasta?", Arrays.asList("100", "200"), 0),
            new Question("How many calories are in a piece of salmon?", Arrays.asList("100", "400"), 3),
            new Question("How many calories are in a piece of chicken?", Arrays.asList("100", "300"), 2),
            new Question("How many calories are in a piece of steak?", Arrays.asList("100", "200"), 0),
            new Question("How many calories are in a piece of pizza?", Arrays.asList("100", "200"), 1),
            new Question("How many calories are in a piece of bread?", Arrays.asList("100", "200"), 0),
            new Question("How many calories are in a piece of ice cream?", Arrays.asList("300", "200"), 2)
    };

    Question question;
    int CorrectAnswer;

    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        {
            question = questions[random.nextInt(questions.length+1 )];
            CorrectAnswer = setQuestion(question);

            binding.submitAnswer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (binding.answer1.isChecked()) {
                        if (CorrectAnswer == 0) {
                            points++;
                        }
                    }

                    if (binding.answer2.isChecked()) {
                        if (CorrectAnswer == 1) {
                            points++;
                        }
                    }

                    currentQuestion++;

                    if (currentQuestion == 6) {
                        binding.radioGroup.setVisibility(View.GONE);
                        binding.submitAnswer.setVisibility(View.GONE);
                        binding.Question.setText("You scored " + points + " out of 6");
                        binding.ExitButton.setVisibility(View.VISIBLE);
                    } else {
                        binding.radioGroup.clearCheck();
                        question = questions[random.nextInt(questions.length+1 )];
                        CorrectAnswer = setQuestion(question);

                    }
                }
            });

            binding.ExitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavHostFragment.findNavController(QuizFragment.this)
                            .navigate(R.id.action_quizFragment_to_helloFragment);
                }
            });
        }
    }


}