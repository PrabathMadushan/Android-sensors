package com.prabath.androidsensorstest.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prabath.androidsensorstest.R;

public class BatteryFragment extends Fragment {

    private TextView lblPercent;
    private TextView lblVoltage;
    private TextView lblTemperature;
    private TextView lblHealth;
    private TextView lblTechnology;

    public BatteryFragment() {
    }


    @Override
    public void onStart() {
        super.onStart();
        lblPercent = getView().findViewById(R.id.lblPercent);
        lblVoltage = getView().findViewById(R.id.lblVoltage);
        lblTemperature = getView().findViewById(R.id.lblTemperature);
        lblHealth = getView().findViewById(R.id.lblHealth);
        lblTechnology = getView().findViewById(R.id.lblTechnology);
        BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctxt, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
                float temperature = (float)intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
                temperature=temperature/10f;
                String technology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                lblPercent.setText(level + "%");
                lblVoltage.setText(voltage + "mV");
                lblTemperature.setText(temperature + "°C");
                lblTechnology.setText(technology);
                int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

                if (deviceHealth == BatteryManager.BATTERY_HEALTH_COLD) lblHealth.setText("Cold");
                if (deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD) lblHealth.setText("Dead");
                if (deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD) lblHealth.setText("Good");
                if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT)lblHealth.setText("OverHeat");
                if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE)lblHealth.setText("Over voltage");
                if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN)lblHealth.setText("Unknown");
                if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE)lblHealth.setText("Unspecified Failure");

            }
        };
        getActivity().registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_battery, container, false);
    }
}
