package com.example.androidpoint.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidpoint.R;

public class AdvanceFragment extends Fragment {


    public AdvanceFragment() {
        // Required empty public constructor
    }

    public static AdvanceFragment newInstance(String param1, String param2) {
        AdvanceFragment fragment = new AdvanceFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_advance, container, false);


        return view;

    }
}