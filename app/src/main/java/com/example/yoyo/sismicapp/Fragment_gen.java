package com.example.yoyo.sismicapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Fragment_gen extends Fragment {
    View rootView;
    String aux;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.infosismos_prevencion_gen, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        List<String> completes = Arrays.asList("12345678901234567890123456789012345678901234567890123456789012345678901234567890...", "12345678901234567890123456789012345678901234567890123456789012345678901234567890...", "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890...");
        List<String> summary = Arrays.asList("sup11", "sup22", "sup33");
        ListAdapter_InfoAndPrev adapter = new ListAdapter_InfoAndPrev(getActivity(),"prev",completes, summary);
        lv.setAdapter(adapter);
        Button  butt = (Button) rootView.findViewById(R.id.but);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        aux = settings.getString("fm", "");

        //final TextView prueba = (TextView) rootView.findViewById(R.id.miplan_bienvenida_text);
         butt.setOnClickListener(new View.OnClickListener() {
             //    int i= 0;
             @Override
             public void onClick(View view) {

                 //if (i==0) {
                 //prueba.setText("Hola cambio");
                 //i=1;}
                 //else { prueba.setText("Hola cambio otra");
                 //    i=0;}
                 Toast.makeText(view.getContext(), aux,
                         Toast.LENGTH_SHORT).show();

             }
         });
        return rootView;

    }




}

