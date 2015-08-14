package com.example.yoyo.sismicapp;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yoyo.sismicapp.ListAdapters.ListAdapter_kit;

import java.util.Arrays;
import java.util.List;

public class Fragment_miplan_Prepararmikit extends Fragment {
    View rootView;
    ListView lv;
    String auxlinterna;
    String auxbolsas;
    String auxsnack;
    String auxembotellada;
    String auxropa;
    String auxaseo;
    String auxpilas;
    String auxaux;
    String auxradio;

    List<String> items;
    List<String> descriptions;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_prepararmikit, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView2);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        auxlinterna = settings.getString("auxLinterna", "");
        auxbolsas= settings.getString("auxBolsas", "");
        auxsnack = settings.getString("auxSnack", "");
        auxembotellada = settings.getString("auxEmbotellada", "");
        auxropa = settings.getString("auxRopa", "");
        auxaseo = settings.getString("auxAseo", "");
        auxpilas = settings.getString("auxPilas", "");
        auxaux = settings.getString("auxAux", "");
        auxradio = settings.getString("auxRadio", "");
        items = Arrays.asList("Linterna", "Botiquín de primeros auxilios", "Pilas", "Agua embotellada", "Artículos de aseo", "Comida tipo Snack", "Radio portatíl", "Ropa", "Bolsas de basura");
        descriptions = Arrays.asList("Descripción 1..", "Descripción 2..", "Descripción 3..","Descripción 4..","Descripción 5..","Descripción 6..", "Descripción 7..","Descripción 8..", "Descripción 9..");
        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas,auxembotellada, auxaseo,auxsnack, auxradio,auxropa,auxbolsas);
        ListAdapter_kit adapter = new ListAdapter_kit(getActivity(), items, descriptions, vr);
        lv.setAdapter(adapter);

        return rootView;
        }

}
