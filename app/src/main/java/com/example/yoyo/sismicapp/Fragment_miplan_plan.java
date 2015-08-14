package com.example.yoyo.sismicapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoyo.sismicapp.ListAdapters.ListAdapter_familytab;
import com.example.yoyo.sismicapp.ListAdapters.ListAdapter_spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fragment_miplan_plan extends Fragment {
    View rootView;

    TextView gastext;
    TextView aguatext;
    TextView luztext;
    TextView casatext;
    TextView oficinatext;
    TextView parquetext;
    TextView colegiotext;
    Spinner menu;
    int spinnerIndex;
    List<String> list= new ArrayList();
    List<String> type= new ArrayList();
    String itemPressed="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_plan, container, false);
        gastext = (TextView) rootView.findViewById(R.id.textView13);
        aguatext = (TextView) rootView.findViewById(R.id.textView16);
        luztext = (TextView) rootView.findViewById(R.id.textView15);
        casatext = (TextView) rootView.findViewById(R.id.textView5);
        oficinatext = (TextView) rootView.findViewById(R.id.textView9);
        parquetext = (TextView) rootView.findViewById(R.id.textView10);
        colegiotext = (TextView) rootView.findViewById(R.id.textView11);
        LinearLayout gas = (LinearLayout) rootView.findViewById(R.id.gas);
        LinearLayout luz = (LinearLayout) rootView.findViewById(R.id.luz);
        LinearLayout agua = (LinearLayout) rootView.findViewById(R.id.agua);
        LinearLayout casa = (LinearLayout) rootView.findViewById(R.id.casa);
        LinearLayout oficina = (LinearLayout) rootView.findViewById(R.id.oficina);
        LinearLayout parque = (LinearLayout) rootView.findViewById(R.id.parque);
        LinearLayout colegio = (LinearLayout) rootView.findViewById(R.id.colegio);
        menu = (Spinner) rootView.findViewById(R.id.spinner);
        Button guardar = (Button) rootView.findViewById(R.id.guardar);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String familia = settings.getString("familia", "");
        gastext.setText(settings.getString("gas", ""));
        aguatext.setText(settings.getString("agua", ""));
        luztext.setText(settings.getString("luz", ""));
        List<String> items = new ArrayList<String>(Arrays.asList(familia.split(";")));
        Log.i("el log", familia);
        for (int i = 0; i < items.size(); i++) {
            list.add(items.get(i));
            type.add(items.get(i + 1));
            i = i + 1;
        }
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String person = list.get(spinnerIndex);
                if (spinnerIndex==0){
                    person="Yo";
                }
                if (itemPressed.equals("gas")){
                    gastext.setText("Cortar Gas"+"\n"+person);
                    edit.putString ("gas", "Cortar Gas"+"\n"+person );
                    edit.apply();
                }
                else if (itemPressed.equals("agua")){
                    aguatext.setText("Cortar Agua"+"\n"+person);
                    edit.putString ("agua", "Cortar Agua"+"\n"+person );
                    edit.apply();
                }
                else if (itemPressed.equals("luz")){
                    luztext.setText("Cortar Luz"+"\n"+person);
                    edit.putString ("luz","Cortar Luz"+"\n"+person );
                    edit.apply();
                }
                else {
                    Toast.makeText(getActivity(), "No has seleccionado un ícono de tarea", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ListAdapter_spinner adapter = new ListAdapter_spinner(getActivity(), list, type);
        menu.setAdapter(adapter);
        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                spinnerIndex = menu.getSelectedItemPosition();
                Log.i("log", String.valueOf(spinnerIndex));
            }

            public void onNothingSelected(AdapterView<?> arg0) {// do nothing
            }
        });
          gas.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  itemPressed="gas";
                  gastext.setTypeface(null, Typeface.BOLD);
                  aguatext.setTypeface(null, Typeface.NORMAL);
                  luztext.setTypeface(null, Typeface.NORMAL);
                  gastext.setTextColor(Color.parseColor("#000000"));
                  luztext.setTextColor(Color.parseColor("#666666"));
                  aguatext.setTextColor(Color.parseColor("#666666"));
              }
          });
          agua.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  itemPressed="agua";
                  gastext.setTypeface(null, Typeface.NORMAL);
                  aguatext.setTypeface(null, Typeface.BOLD);
                  luztext.setTypeface(null, Typeface.NORMAL);
                  aguatext.setTextColor(Color.parseColor("#000000"));
                  luztext.setTextColor(Color.parseColor("#666666"));
                  gastext.setTextColor(Color.parseColor("#666666"));
              }
          });
          luz.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  itemPressed="luz";
                  gastext.setTypeface(null, Typeface.NORMAL);
                  aguatext.setTypeface(null, Typeface.NORMAL);
                  luztext.setTypeface(null, Typeface.BOLD);
                  luztext.setTextColor(Color.parseColor("#000000"));
                  gastext.setTextColor(Color.parseColor("#666666"));
                  aguatext.setTextColor(Color.parseColor("#666666"));
              }
          });
          casa.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  casatext.setTypeface(null, Typeface.BOLD);
                  oficinatext.setTypeface(null, Typeface.NORMAL);
                  parquetext.setTypeface(null, Typeface.NORMAL);
                  colegiotext.setTypeface(null, Typeface.NORMAL);
                  casatext.setTextColor(Color.parseColor("#000000"));
                  oficinatext.setTextColor(Color.parseColor("#666666"));
                  parquetext.setTextColor(Color.parseColor("#666666"));
                  colegiotext.setTextColor(Color.parseColor("#666666"));

                  SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                  SharedPreferences.Editor edit = settings.edit();
                  edit.putString("lugarDeEncuentro", "casa");
                  edit.apply();
              }
          });
          oficina.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  casatext.setTypeface(null, Typeface.NORMAL);
                  oficinatext.setTypeface(null, Typeface.BOLD);
                  parquetext.setTypeface(null, Typeface.NORMAL);
                  colegiotext.setTypeface(null, Typeface.NORMAL);
                  casatext.setTextColor(Color.parseColor("#666666"));
                  oficinatext.setTextColor(Color.parseColor("#000000"));
                  parquetext.setTextColor(Color.parseColor("#666666"));
                  colegiotext.setTextColor(Color.parseColor("#666666"));
                  SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                  SharedPreferences.Editor edit = settings.edit();
                  edit.putString("lugarDeEncuentro", "oficina");
                  edit.apply();
              }
          });
          parque.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  casatext.setTypeface(null, Typeface.NORMAL);
                  oficinatext.setTypeface(null, Typeface.NORMAL);
                  parquetext.setTypeface(null, Typeface.BOLD);
                  colegiotext.setTypeface(null, Typeface.NORMAL);
                  casatext.setTextColor(Color.parseColor("#666666"));
                  oficinatext.setTextColor(Color.parseColor("#666666"));
                  parquetext.setTextColor(Color.parseColor("#000000"));
                  colegiotext.setTextColor(Color.parseColor("#666666"));
                  SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                  SharedPreferences.Editor edit = settings.edit();
                  edit.putString("lugarDeEncuentro", "parque");
                  edit.apply();
              }
          });
          colegio.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  casatext.setTypeface(null, Typeface.NORMAL);
                  oficinatext.setTypeface(null, Typeface.NORMAL);
                  parquetext.setTypeface(null, Typeface.NORMAL);
                  colegiotext.setTypeface(null, Typeface.BOLD);
                  casatext.setTextColor(Color.parseColor("#666666"));
                  oficinatext.setTextColor(Color.parseColor("#666666"));
                  parquetext.setTextColor(Color.parseColor("#666666"));
                  colegiotext.setTextColor(Color.parseColor("#000000"));
                  SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                  SharedPreferences.Editor edit = settings.edit();
                  edit.putString("lugarDeEncuentro", "colegio");
                  edit.apply();
              }
          });
          return rootView;
      }
  }