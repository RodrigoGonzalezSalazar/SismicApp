package com.example.yoyo.sismicapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Fragment_miplan_plan extends Fragment {
    View rootView;

    TextView gastext;
    TextView aguatext;
    TextView luztext;
    TextView casatext;
    TextView oficinatext;
    TextView parquetext;
    TextView colegiotext;
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
        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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