package com.aman.chittooassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aman.chittooassignment.databinding.FragmentChatBinding;


public class ChatFragment extends Fragment {
    private FragmentChatBinding fragmentChatBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChatBinding = FragmentChatBinding.inflate(inflater, container, false);

        return fragmentChatBinding.getRoot();
    }
}