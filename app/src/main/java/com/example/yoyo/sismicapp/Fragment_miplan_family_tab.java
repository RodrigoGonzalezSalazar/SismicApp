package com.example.yoyo.sismicapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.yoyo.sismicapp.ListAdapters.ListAdapter_familytab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rodrigo on 06-08-2015.
 */
public class Fragment_miplan_family_tab extends Fragment {
    View rootView;
    List<String> list= new ArrayList();;
    List<String> type= new ArrayList();;
    int j=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_family_tab, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String familia = settings.getString("familia", "");
        if (j==0) {
            List<String> items = new ArrayList<String>(Arrays.asList(familia.split(";")));
            Log.i("el log", familia);
            for (int i = 0; i < items.size(); i++) {
                list.add(items.get(i));
                type.add(items.get(i + 1));
                i = i + 1;
            }
            j=1;
        }
        ListAdapter_familytab adapter = new ListAdapter_familytab(getActivity(), list, type);
        lv.setAdapter(adapter);
        ImageButton delete = (ImageButton) rootView.findViewById(R.id.delete);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long arg3) {
                Log.i("tag", String.valueOf(position));
            }
        });
        Button agregar = (Button) rootView.findViewById(R.id.but);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Activity_miplan_family_create.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        return rootView;
    }
}
