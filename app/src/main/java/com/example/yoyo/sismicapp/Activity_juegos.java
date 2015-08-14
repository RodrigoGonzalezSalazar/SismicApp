package com.example.yoyo.sismicapp;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import android.view.Menu;
import android.view.MenuItem;

public class Activity_juegos extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trivias_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.Menudesafios));
        Button btnquiz2 = (Button) findViewById(R.id.button_quiz2);
        btnquiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor edit = settings.edit();
                edit.putString("whatQuiz", "prev");
                edit.apply();
                Intent p = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(p);

            }
        });

        Button btnquiz = (Button) findViewById(R.id.button_quiz);
        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor edit = settings.edit();
                edit.putString("whatQuiz", "info");
                edit.apply();
                Intent q = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(q);


            }
        });

        Button btnanki= (Button) findViewById(R.id.button_anki);
        btnanki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), Activity_Anki.class);
                startActivity(j);

            }
        });
        Button btntro = (Button) findViewById(R.id.button_trophy);
        btntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(getApplicationContext(), TrophyActivity.class);
                startActivity(j);

            }
        });
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
}
