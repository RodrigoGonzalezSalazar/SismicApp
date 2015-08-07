package com.example.yoyo.sismicapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MyActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = settings.edit();
        //edit.clear().commit();
        String aux = settings.getString("aux", "");
        if (!aux.equals("ok")){
            edit.putString ("familia", "Rodrigo;Yo, hijo" );
            edit.putString ("aux", "ok" );
            edit.apply();}


        ImageButton btnmiplan = (ImageButton) findViewById(R.id.button_miplan);
        btnmiplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Activity_miplan.class);
                startActivity(i);

            }
        });


        ImageButton btninfo = (ImageButton) findViewById(R.id.button_infosismos);
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext(), Activity_infosismos.class);
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
                Intent q = new Intent(getApplicationContext(), Activity_infoprevencion.class);
                startActivity(q);

            }
        });
    }
}

