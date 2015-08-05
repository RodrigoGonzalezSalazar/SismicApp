package com.example.yoyo.sismicapp;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        ImageButton btnmiplan = (ImageButton) findViewById(R.id.button_miplan);
        btnmiplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fragment_miplan_activity.class);
                startActivity(i);

            }
        });


        ImageButton btninfo = (ImageButton) findViewById(R.id.button_infosismos);
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext(), Fragment_infosismos_activity.class);
                startActivity(p);

            }
        });

        ImageButton btnquiz = (ImageButton) findViewById(R.id.button_quiz);
        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(getApplicationContext(), SuperQuizActivity.class);
                startActivity(q);

            }
        });

        ImageButton btnprev = (ImageButton) findViewById(R.id.button_prevencion);
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(getApplicationContext(), Fragment_infoprevencion_activity.class);
                startActivity(q);

            }
        });
    }
}

