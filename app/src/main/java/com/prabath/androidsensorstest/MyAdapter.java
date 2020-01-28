package com.prabath.androidsensorstest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.prabath.androidsensorstest.Fragments.AccelerometerFragment;
import com.prabath.androidsensorstest.Fragments.AmbientTemperatureFragment;
import com.prabath.androidsensorstest.Fragments.BatteryFragment;
import com.prabath.androidsensorstest.Fragments.GPSFragment;
import com.prabath.androidsensorstest.Fragments.GravityFragment;
import com.prabath.androidsensorstest.Fragments.GyroscopeFragment;
import com.prabath.androidsensorstest.Fragments.LightFragment;
import com.prabath.androidsensorstest.Fragments.LinearAccelerometerFragment;
import com.prabath.androidsensorstest.Fragments.MagneticFieldFragment;
import com.prabath.androidsensorstest.Fragments.OrientationFragment;
import com.prabath.androidsensorstest.Fragments.PressureFragment;
import com.prabath.androidsensorstest.Fragments.ProximityFragment;
import com.prabath.androidsensorstest.Fragments.RotationVectorFragment;
import com.prabath.androidsensorstest.Fragments.StepCounterFragment;
import com.prabath.androidsensorstest.Fragments.WifiFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    private int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BatteryFragment();
            case 1:
                return new LightFragment();
            case 2:
                return new WifiFragment();
            case 3:
                return new AccelerometerFragment();
            case 4:
                return new GyroscopeFragment();
            case 5:
                return new GPSFragment();
            case 6:
                return new PressureFragment();
            case 7:
                return new ProximityFragment();
            case 8:
                return new LinearAccelerometerFragment();
            case 9:
                return new MagneticFieldFragment();
            case 10:
                return new GravityFragment();
            case 11:
                return new RotationVectorFragment();
            case 12:
                return new AmbientTemperatureFragment();
            case 13:
                return new OrientationFragment();
            case 14:
                return new StepCounterFragment();
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
