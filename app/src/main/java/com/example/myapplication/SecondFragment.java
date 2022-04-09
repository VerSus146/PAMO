package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button submit_button = view.findViewById(R.id.submitButton_bmr);
        EditText WeightEditText = view.findViewById(R.id.weightInput_bmr);
        EditText HeightEditText = view.findViewById(R.id.heightInput_bmr);
        EditText AgeEditText = view.findViewById(R.id.ageinput_bmr);
        RadioButton MaleButton = view.findViewById(R.id.MaleRadio_bmr);
        TextView BMRTextView = view.findViewById(R.id.BMR_Result);

        binding.previousFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.mealBmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_mealFragment);
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float weight = Float.parseFloat(WeightEditText.getText().toString());
                float height = Float.parseFloat(HeightEditText.getText().toString());
                float age = Float.parseFloat(AgeEditText.getText().toString());

                boolean maleChecked = MaleButton.isChecked();

                height = height * 6.25f;
                weight = weight * 10.0f;
                age = age * 5.0f;

                double bmr = weight + height - age;

                if (maleChecked) {
                    bmr = bmr + 5.0f;
                } else {
                    bmr = bmr - 161.0f;
                }

                BMRTextView.setText("Your calories: " + bmr);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}