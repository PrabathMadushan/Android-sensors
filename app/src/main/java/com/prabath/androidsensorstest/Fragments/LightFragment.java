package com.prabath.androidsensorstest.Fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prabath.androidsensorstest.R;

public class LightFragment extends Fragment {
    private SensorManager sensorManager;
    private Sensor light;

    private TextView lblIlluminancelx;
    private TextView lblIlluminancefc;
    private TextView lblSensor;
    private TextView lblVendor;
    private TextView lblVersion;
    private TextView lblPower;
    private TextView lblMaxRange;
    private TextView lblResolution;

    public LightFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        lblIlluminancelx = getView().findViewById(R.id.lblIlluminancelx);
        lblIlluminancefc = getView().findViewById(R.id.lblIlluminancefc);
        lblSensor = getView().findViewById(R.id.lblSensor);
        lblVendor = getView().findViewById(R.id.lblVendor);
        lblVersion = getView().findViewById(R.id.lblVersion);
        lblPower = getView().findViewById(R.id.lblPower);
        lblMaxRange = getView().findViewById(R.id.lblMaxRange);
        lblResolution = getView().findViewById(R.id.lblResolution);
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        lblVendor.setText(light.getVendor());
        lblVersion.setText(light.getVersion()+"");
        lblPower.setText(light.getPower()+" mA");
        lblMaxRange.setText(light.getMaximumRange()+" lx");
        lblResolution.setText(light.getResolution()+" lx");
        lblSensor.setText(light.getName());

    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float lightlx = event.values[0];
                double lightfc = event.values[0] * 10.7639104167097;
                lblIlluminancelx.setText(lightlx + " lx");
                lblIlluminancefc.setText(lightfc + " fc");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, light, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_light, container, false);
    }


}
