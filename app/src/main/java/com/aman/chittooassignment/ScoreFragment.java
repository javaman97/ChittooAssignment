package com.aman.chittooassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aman.chittooassignment.databinding.FragmentScoreBinding;

public class ScoreFragment extends Fragment {
    private FragmentScoreBinding binding;
    private CountDownTimer countDownTimer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentScoreBinding.inflate(inflater, container, false);
        // Start a 30-second countdown
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.textViewTimer.setText("Time left: " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                binding.editTextAnswer.setEnabled(false);
                binding.buttonSubmit.setEnabled(true);
                binding.editTextAnswer.setText("Time is up!");
            }
        }.start();

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = binding.editTextAnswer.getText().toString();
                if (!answer.isEmpty()) {

                    Toast.makeText(requireContext(), "Answer submitted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireContext(), "Please provide an answer.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}