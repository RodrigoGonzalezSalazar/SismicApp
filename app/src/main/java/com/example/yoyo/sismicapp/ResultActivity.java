package com.example.yoyo.sismicapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by tino on 17-11-2014.
 */
public class ResultActivity extends ActionBarActivity {
    int trophy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.Menudesafios));
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score)
        {
            case 1: t.setText("Lo sentimos, vuelve a intentarlo más tarde");
                break;
            case 2: t.setText("Debes prepararte más, sigue así");
                break;
            case 3:t.setText("Estas a mitad de camino, aún puedes mejorar más");
                break;
            case 4:t.setText("Veo que te estas preparando, sólo falta un poco más");
                break;
            case 5:t.setText("Felicidades, estas bien preparado para una Emergencia");

        }
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