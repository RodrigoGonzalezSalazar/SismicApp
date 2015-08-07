package com.example.yoyo.sismicapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Fragment_miplan_home extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_home, container, false);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());

        List<String> total = Arrays.asList(settings.getString("auxLinterna", ""), settings.getString("auxBolsas", ""),
                settings.getString("auxSnack", ""),settings.getString("auxEmbotellada", ""), settings.getString("auxRopa", ""),
                settings.getString("auxAseo", ""), settings.getString("auxPilas", ""), settings.getString("auxAux", ""),
                settings.getString("auxRadio", ""));
        int auxtotal=0;
        for(String str: total) {
            if (str.equals("v")){auxtotal=auxtotal+1;}
        }
        final ImageView deboHacer = (ImageView) rootView.findViewById(R.id.debohacer);
        final ImageView deboJuntarme = (ImageView) rootView.findViewById(R.id.debojuntarme);
        final TextView falta = (TextView) rootView.findViewById(R.id.falta);
        String lugardeencuentro = settings.getString("lugarDeEncuentro", "");

        String checkagua = settings.getString("checkAgua", "");
        String checkluz = settings.getString("checkLuz", "");
        String checkgas = settings.getString("checkGas", "");
        String tareastuyas="";
        if (checkgas.equals("c")){tareastuyas=tareastuyas+"Cortar el gas, ";}
        if (checkluz.equals("c")){tareastuyas=tareastuyas+"Cortar la luz, ";}
        if (checkagua.equals("c")){tareastuyas=tareastuyas+"Cortar el agua";}

        falta.setText(Html.fromHtml("Aún te falta(n) <b>" + (String.valueOf(9 - auxtotal)) + "</b> item(s) por agregar a tu Kit."));

        return rootView;
    }
}