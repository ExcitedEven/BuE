package com.excitedeven.bue.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.excitedeven.bue.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllOrderFragment extends Fragment {

    public AllOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_order, container, false);
    }
}
