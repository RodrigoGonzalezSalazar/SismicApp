package com.example.yoyo.sismicapp.Fragments_Prevencion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yoyo.sismicapp.ListAdapters.ListAdapter_InfoAndPrev;
import com.example.yoyo.sismicapp.R;

import java.util.Arrays;
import java.util.List;

public class KitEmergencia extends Fragment {
    View rootView;
    String aux;
    ListView lv;
    List<String> completes;
    List<String> summary;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.infosismos_prevencion_gen, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView);
        completes = Arrays.asList("Extenso Situaciones de riesgo", "Extenso Forma de prevenir", "Extenso Dato Freak");
        summary = Arrays.asList("Preview Situaciones de riesgo 3", "Preview Forma de prevenir", "Preview Dato Freak");
        ListAdapter_InfoAndPrev adapter = new ListAdapter_InfoAndPrev(getActivity(),"prev",completes, summary);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long arg3) {
                TextView text = (TextView) view.findViewById(R.id.textView6);
                if (text.getText().equals(completes.get(position))) {
                    text.setText(summary.get(position));
                } else if (text.getText().equals(summary.get(position))) {
                    text.setText(completes.get(position));
                }
            }

            ;
        });

        return rootView;

    }
}
