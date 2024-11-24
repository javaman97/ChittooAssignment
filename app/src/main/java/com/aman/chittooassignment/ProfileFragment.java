package com.aman.chittooassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aman.chittooassignment.databinding.FragmentProfileBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding fragmentProfileBinding ;
    private DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false);
            databaseReference = FirebaseDatabase.getInstance().getReference("users");

            // Fetch data from Firebase Realtime Database
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    StringBuilder userInfo = new StringBuilder();
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        String name = userSnapshot.child("name").getValue(String.class);
                        int age = userSnapshot.child("age").getValue(Integer.class);
                        boolean isPremium = userSnapshot.child("premium").getValue(Boolean.class);

                        userInfo.append("Name: ").append(name).append("\n")
                                .append("Age: ").append(age).append("\n")
                                .append("Premium: ").append(isPremium).append("\n\n");
                    }
                    fragmentProfileBinding.txtuserInfo.setText(userInfo.toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle error
                }
            });
      return fragmentProfileBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Set the binding to null when the view is destroyed to avoid memory leaks
        fragmentProfileBinding = null;
    }
}