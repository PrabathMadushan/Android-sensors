package com.prabath.androidsensorstest.Fragments;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prabath.androidsensorstest.R;

public class WifiFragment extends Fragment {

    private TextView lblStatus;
    private TextView lblEnableLevel;
    private TextView lblSSID;
    private TextView lblBSSID;
    private TextView lblRSSI;
    private TextView lblLinkSpeed;
    private TextView lblIP;
    private TextView lblMAC;

    public WifiFragment() {
    }


    @Override
    public void onStart() {
        super.onStart();
        lblStatus=getView().findViewById(R.id.lblStatus);
        lblEnableLevel=getView().findViewById(R.id.lblEnableLevel);
        lblSSID=getView().findViewById(R.id.lblSSID);
        lblBSSID=getView().findViewById(R.id.lblBSSID);
        lblRSSI=getView().findViewById(R.id.lblRSSI);
        lblLinkSpeed=getView().findViewById(R.id.lblLinkSpeed);
        lblIP=getView().findViewById(R.id.lblIP);
        lblMAC=getView().findViewById(R.id.lblMAC);

        android.net.wifi.WifiManager wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        android.net.wifi.SupplicantState s = m.getConnectionInfo().getSupplicantState();
//        NetworkInfo.DetailedState state = WifiInfo.getDetailedStateOf(s);
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        lblSSID.setText(connectionInfo.getSSID());
        lblBSSID.setText(connectionInfo.getBSSID());
        lblRSSI.setText(connectionInfo.getRssi()+" dBm");
        lblLinkSpeed.setText(connectionInfo.getLinkSpeed()+" Mbps");
        lblIP.setText(Formatter.formatIpAddress(connectionInfo.getIpAddress()));
        lblMAC.setText(connectionInfo.getMacAddress());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wifi, container, false);
    }
}
