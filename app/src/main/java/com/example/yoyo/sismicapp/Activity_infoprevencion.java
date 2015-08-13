package com.example.yoyo.sismicapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.yoyo.sismicapp.Fragments_Prevencion.ComoActuar;
import com.example.yoyo.sismicapp.Fragments_Prevencion.KitEmergencia;
import com.example.yoyo.sismicapp.Fragments_Prevencion.LugaresSeguros;


public class Activity_infoprevencion extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener  {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);

        /********************MODO TABS EN ACTIONBAR**************************/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("Información sobre Prevención");

        /**************************CREAR TABS******************************/
        ActionBar.Tab tab = actionBar.newTab().setText("Como actuar en un sismo").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Lugares seguros").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Kit de emergencia").setTabListener(this);
        actionBar.addTab(tab);


    }
    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new ComoActuar();
                case 1:
                    return new LugaresSeguros();
                case 2:
                    return new KitEmergencia();
                default:
                    return null;
            }
        }

        public int getCount() {
            return 3;
        }


    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }
    @Override
    public void onPageSelected(int i) {
        getSupportActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            event.startTracking();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled()) {
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

}