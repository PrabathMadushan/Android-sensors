package com.prabath.androidsensorstest.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prabath.androidsensorstest.R;

public class LinearAccelerometerFragment extends Fragment {

    public LinearAccelerometerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_linear_accelerometer, container, false);
    }
}
