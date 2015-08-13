package com.example.yoyo.sismicapp.Fragments_Infosismos;



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

public class EscMercalli extends Fragment {
    View rootView;
    String aux;
    ListView lv;
    List<String> completes;
    List<String> summary;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.infosismos_prevencion_gen, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView);
        //reconocer tab actual y hacer if tab actual: complete y summary == esto.
        completes = Arrays.asList("Extenso Información detallada, esto es un texto de prueba para mostrar la diferencia real que podría tener el preview con el texto extenso. 1234567890 1234567890 ABC", "Extenso Resumen información detallada", "Extenso Dato Freak");
        summary = Arrays.asList("Preview Información detallada 2", "Preview  Resumen información detallada", "Preview Dato Freak");
        ListAdapter_InfoAndPrev adapter = new ListAdapter_InfoAndPrev(getActivity(),"info",completes, summary);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long arg3) {
                TextView text = (TextView) view.findViewById(R.id.textView6);
                if (text.getText().equals(completes.get(position))){
                    text.setText(summary.get(position));
                }
                else if (text.getText().equals(summary.get(position))){
                    text.setText(completes.get(position));
                }
            };
        });

        return rootView;

    }
}

