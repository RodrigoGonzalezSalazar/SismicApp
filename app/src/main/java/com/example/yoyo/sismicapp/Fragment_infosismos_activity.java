package com.example.yoyo.sismicapp;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Fragment_infosismos_activity extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener  {

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
        ActionBar.Tab tab = actionBar.newTab().setText("Home").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Info Sismos").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Escala de Mercalli").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Escala de Richter").setTabListener(this);
        actionBar.addTab(tab);

       //ing.setOnClickListener(new View.OnClickListener() {
       //     @Override
      //      public void onClick(View view) {
      //          Intent p = new Intent(getApplicationContext(), Fragment_infosismos_activity_ingles.class);
      //          startActivity(p);

          //  }
       // });
    }
    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new Fragment_infosismos_home();
                case 1:
                    return new Fragment_infosismos_infosismos();
                case 2:
                    return new Fragment_infosismos_escmerc();
                case 3:
                    return new Fragment_infosismos_escritch();
                default:
                    return null;
            }
        }

        public int getCount() {
            return 4;
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