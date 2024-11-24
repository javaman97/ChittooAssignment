package com.aman.chittooassignment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aman.chittooassignment.databinding.FragmentCertificateBinding;


public class CertificateFragment extends Fragment {
private FragmentCertificateBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding.btnCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScoreFragment.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}