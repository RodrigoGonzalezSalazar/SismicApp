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

public class Fragment_info_gen extends Fragment {
    View rootView;
    String aux;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.infosismos_prevencion_gen, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        List<String> completes = Arrays.asList("Extenso 1", "Extenso 2", "Extenso Dato Freak");
        List<String> summary = Arrays.asList("Preview 1", "Preview 2", "Preview Dato Freak");
        ListAdapter_InfoAndPrev adapter = new ListAdapter_InfoAndPrev(getActivity(),"info",completes, summary);
        lv.setAdapter(adapter);


        return rootView;

    }




}

