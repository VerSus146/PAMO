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

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.SubmitButton);
        EditText WeightEditText = view.findViewById(R.id.WeightInput);
        EditText HeightEditText = view.findViewById(R.id.HeightInput);
        RadioButton MaleButton = view.findViewById(R.id.MaleRadio);
        TextView HealthTextView = view.findViewById(R.id.HealthText);
        TextView BMITextView = view.findViewById(R.id.BMI_Result);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float weight = Float.parseFloat(WeightEditText.getText().toString());
                float height = Float.parseFloat(HeightEditText.getText().toString());

                boolean maleChecked = false;

                if (MaleButton.isChecked()){
                    maleChecked = true;
                }

                height = height/100;

                double bmi = weight/(height*height);

                if (maleChecked){
                    if ( bmi > 19.5 && bmi < 30){
                        HealthTextView.setText("You're Healthy.");
                    } else {
                        HealthTextView.setText("There's something wrong with you!");
                    }
                } else {
                    if ( bmi > 18 && bmi < 30){
                        HealthTextView.setText("You're Healthy.");
                    } else {
                        HealthTextView.setText("There's something wrong with you!");
                    }
                }

                BMITextView.setText("Your BMI: " + bmi);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}