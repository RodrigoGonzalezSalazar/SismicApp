package com.example.yoyo.sismicapp;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.view.Menu;
import android.view.MenuItem;

public class SuperQuizActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trivias_home);

        Button btnquiz2 = (Button) findViewById(R.id.button_quiz2);
        btnquiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext(), QuizActivityy.class);
                startActivity(p);

            }
        });

        Button btnquiz = (Button) findViewById(R.id.button_quiz);
        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(q);

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
