package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentMealBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Meal{
    private String name;
    private String description;

    public Meal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}

public class MealFragment extends Fragment {

    private FragmentMealBinding binding;

    public MealFragment() {
        // Required empty public constructor
    }

    public static MealFragment newInstance() {
        MealFragment fragment = new MealFragment();
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

        binding = FragmentMealBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        {
            List<String> recipes = new ArrayList<>();


            recipes.add("Pizza is a savory dish of Italian origin, consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients (anchovies, olives, meat, etc.) baked at a high temperature, traditionally in a wood-fired oven.");
            recipes.add("Spaghetti is a type of noodle dish from the Italian cuisine. It is a staple food of Italian cuisine and is often served as an individual serving, as opposed to as part of a main meal.");

            binding.BMRMeal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(MealFragment.this)
                            .navigate(R.id.action_mealFragment_to_SecondFragment);
                }
            });

            binding.BMIMeal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(MealFragment.this)
                            .navigate(R.id.action_mealFragment_to_FirstFragment);
                }
            });

            Random random = new Random();
            binding.RecipeText.setText(recipes.get(random.nextInt(recipes.size())));
        }
    }
}