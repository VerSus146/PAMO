package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {

    private FragmentHelloBinding binding;

    public HelloFragment() {
        // Required empty public constructor
    }

    public static HelloFragment newInstance(String param1, String param2) {
        HelloFragment fragment = new HelloFragment();
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

        binding = FragmentHelloBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HelloFragment.this)
                        .navigate(R.id.action_helloFragment_to_FirstFragment);
            }
        });

        binding.quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HelloFragment.this)
                        .navigate(R.id.action_helloFragment_to_quizFragment);
            }
        });

        binding.bmiGraphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HelloFragment.this)
                        .navigate(R.id.action_helloFragment_to_BMIGraphFragment);
            }
        });
    }
}