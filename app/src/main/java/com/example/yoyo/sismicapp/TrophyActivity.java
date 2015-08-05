package com.example.yoyo.sismicapp;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;



public class TrophyActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophy);
        final TextView campeon1 = (TextView) findViewById(R.id.campeon1);
        final TextView campeon2 = (TextView) findViewById(R.id.campeon2);
        final TextView nada = (TextView) findViewById(R.id.nada);
        final ImageView copa1 = (ImageView) findViewById(R.id.copa1);
        final ImageView copa2= (ImageView) findViewById(R.id.copa2);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String trophy1 = settings.getString("trophy1", "");
        String trophy2 = settings.getString("trophy2", "");
        if (trophy1.equals("si")){campeon1.setText("Sabelotodo de sismos");
            copa1.setBackgroundResource(R.drawable.trofeo);
            nada.setText("");
        }

        if (trophy2.equals("si")){campeon2.setText("Maestro en prevención");
            copa2.setBackgroundResource(R.drawable.trofeo);
            nada.setText("");
        }
        if (trophy2.equals("no") && trophy1.equals("no")){nada.setText("No has conseguido ningun logro :(");}
    }


}