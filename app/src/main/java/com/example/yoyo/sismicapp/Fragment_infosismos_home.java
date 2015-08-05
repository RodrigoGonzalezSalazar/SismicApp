package com.example.yoyo.sismicapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Fragment_infosismos_home extends Fragment {
    View rootView, view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.infosismos_home, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        List<String> completes = Arrays.asList("sup1", "sup2", "sup3");
        List<String> summary = Arrays.asList("sup11", "sup22", "sup33");
        ListAdapter_InfoAndPrev adapter = new ListAdapter_InfoAndPrev(getActivity(),"prev",completes, summary);
        lv.setAdapter(adapter);

        //final TextView prueba = (TextView) rootView.findViewById(R.id.miplan_bienvenida_text);
        //prueba.setOnClickListener(new View.OnClickListener() {
        //    int i= 0;
        //    @Override
        //    public void onClick(View view) {
        //        if (i==0) {
        //        prueba.setText("Hola cambio");
        //        i=1;}
        //        else { prueba.setText("Hola cambio otra");
        //            i=0;}
        //        Toast.makeText(view.getContext(), "click",
        //                Toast.LENGTH_SHORT).show();

            //}
        //});
        return rootView;

    }

}
