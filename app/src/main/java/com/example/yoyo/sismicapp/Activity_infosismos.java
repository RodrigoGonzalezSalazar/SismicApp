package com.example.yoyo.sismicapp;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;


public class Activity_infosismos extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener  {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_infosismos);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager_infosismos);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);

        /********************MODO TABS EN ACTIONBAR**************************/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("Info Sismo");

        /**************************CREAR TABS******************************/
        ActionBar.Tab tab = actionBar.newTab().setText("Info Sismos").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Escala de Mercalli").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Escala de Richter").setTabListener(this);
        actionBar.addTab(tab);


    }
    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    //info sismos
                    return new Fragment_gen();
                case 1:
                    //escala mercali
                    return new Fragment_gen();
                case 2:
                    //escala richter
                    return new Fragment_gen();
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

}