package com.example.yoyo.sismicapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity_miplan_family_create extends ActionBarActivity {

    String familia;
    String tipo="a";
    ImageView mama;
    ImageView papa;
    ImageView hijo;
    ImageView hija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.miplan_family_create);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        familia = settings.getString("familia", "");
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button añadir = (Button) findViewById(R.id.button);
        mama = (ImageView) findViewById(R.id.imageView3);
        papa = (ImageView) findViewById(R.id.imageView5);
        hijo = (ImageView) findViewById(R.id.imageView4);
        hija = (ImageView) findViewById(R.id.imageView6);
        mama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mama.setBackgroundResource(R.drawable.mama_pressed);
                papa.setBackgroundResource(R.drawable.papa);
                hijo.setBackgroundResource(R.drawable.hijo);
                hija.setBackgroundResource(R.drawable.hija);
                tipo="mama";
            }
            });
        papa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mama.setBackgroundResource(R.drawable.mama);
                papa.setBackgroundResource(R.drawable.papa_pressed);
                hijo.setBackgroundResource(R.drawable.hijo);
                hija.setBackgroundResource(R.drawable.hija);
                tipo="papa";
            }
        });
        hijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mama.setBackgroundResource(R.drawable.mama);
                papa.setBackgroundResource(R.drawable.papa);
                hijo.setBackgroundResource(R.drawable.hijo_pressed);
                hija.setBackgroundResource(R.drawable.hija);
                tipo = "hijo";
            }
        });
        hija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mama.setBackgroundResource(R.drawable.mama);
                papa.setBackgroundResource(R.drawable.papa);
                hijo.setBackgroundResource(R.drawable.hijo);
                hija.setBackgroundResource(R.drawable.hija_pressed);
                tipo="hija";
            }
        });
        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipo.equals("a")||editText.getText().toString().equals("")){
                    Toast.makeText(view.getContext(), "Por favor selecciona un integrante y escribe su nombre",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor edit = settings.edit();
                    String nombre = editText.getText().toString();
                    edit.putString("familia", familia+";" + nombre+";" + tipo);
                    edit.apply();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Se añadió el integrante a la familia",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    Intent i = new Intent(getApplicationContext(), Activity_miplan.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent i = new Intent(getApplicationContext(), Activity_miplan.class);
                startActivity(i);
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
            Intent i = new Intent(getApplicationContext(), Activity_miplan.class);
            startActivity(i);
            finish();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
