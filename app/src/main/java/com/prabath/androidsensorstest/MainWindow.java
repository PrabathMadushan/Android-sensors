package com.prabath.androidsensorstest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainWindow extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_battery));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_light));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_wifi));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_accelerometer));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_gyroscope));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_gps));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_pressure));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_proximity));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_linear_accelerometer));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_magnetic_field));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_gravity));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_rotation_vector));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_ambient_temperature));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_orientation));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.menu_step_counter));

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (tabLayout.getTabCount() > 0) {
            if (id == R.id.nav_battery) {
                tabLayout.getTabAt(0).select();
            } else if (id == R.id.nav_light) {
                tabLayout.getTabAt(1).select();
            } else if (id == R.id.nav_wifi) {
                tabLayout.getTabAt(2).select();
            } else if (id == R.id.nav_accelerometer) {
                tabLayout.getTabAt(3).select();
            } else if (id == R.id.nav_gyroscope) {
                tabLayout.getTabAt(4).select();
            } else if (id == R.id.nav_gps) {
                tabLayout.getTabAt(5).select();
            } else if (id == R.id.nav_pressure) {
                tabLayout.getTabAt(6).select();
            } else if (id == R.id.nav_proximity) {
                tabLayout.getTabAt(7).select();
            } else if (id == R.id.nav_linear_accelerometer) {
                tabLayout.getTabAt(8).select();
            } else if (id == R.id.nav_magnetic_field) {
                tabLayout.getTabAt(9).select();
            } else if (id == R.id.nav_gravity) {
                tabLayout.getTabAt(10).select();
            } else if (id == R.id.nav_rotation_vector) {
                tabLayout.getTabAt(11).select();
            } else if (id == R.id.nav_ambient_temperature) {
                tabLayout.getTabAt(12).select();
            } else if (id == R.id.nav_orientation) {
                tabLayout.getTabAt(13).select();
            } else if (id == R.id.nav_step_counter) {
                tabLayout.getTabAt(14).select();
            }
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
