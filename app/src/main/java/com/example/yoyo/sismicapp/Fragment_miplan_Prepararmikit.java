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


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long arg3) {

                ImageView imageView = (ImageView) view.findViewById(R.id.typeicon);
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String item = String.valueOf(lv.getItemAtPosition(position));
                auxlinterna = settings.getString("auxLinterna", "");
                auxbolsas = settings.getString("auxBolsas", "");
                auxsnack = settings.getString("auxSnack", "");
                auxembotellada = settings.getString("auxEmbotellada", "");
                auxropa = settings.getString("auxRopa", "");
                auxaseo = settings.getString("auxAseo", "");
                auxpilas = settings.getString("auxPilas", "");
                auxaux = settings.getString("auxAux", "");
                auxradio = settings.getString("auxRadio", "");
                if (item.equals("Linterna")) {
                    auxlinterna = settings.getString("auxLinterna", "");
                    if (auxlinterna.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_linterna_r);
                        edit.putString("auxLinterna", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList("r", auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_linterna);
                        edit.putString("auxLinterna", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList("v", auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }

                } else if (item.equals("Bolsas de basura")) {
                    auxbolsas = settings.getString("auxBolsas", "");
                    if (auxbolsas.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_bolsas_r);
                        edit.putString("auxBolsas", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, auxropa, "r");
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_bolsas);
                        edit.putString("auxBolsas", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, auxropa, "v");
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                } else if (item.equals("Comida tipo Snack")) {
                    auxsnack = settings.getString("auxSnack", "");
                    if (auxsnack.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_snack_r);
                        edit.putString("auxSnack", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, "r", auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_snack);
                        edit.putString("auxSnack", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, "v", auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                } else if (item.equals("Agua embotellada")) {
                    auxembotellada = settings.getString("auxEmbotellada", "");
                    if (auxembotellada.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_embotellada_r);
                        edit.putString("auxEmbotellada", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, "r", auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_embotellada);
                        edit.putString("auxEmbotellada", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, "v", auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }

                } else if (item.equals("Ropa")) {
                    auxropa = settings.getString("auxRopa", "");
                    if (auxropa.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_ropa_r);
                        edit.putString("auxRopa", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, "r", auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_ropa);
                        edit.putString("auxRopa", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, "v", auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                } else if (item.equals("Artículos de aseo")) {
                    auxaseo = settings.getString("auxAseo", "");
                    if (auxaseo.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_aseo_r);
                        edit.putString("auxAseo", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, "r", auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_aseo);
                        edit.putString("auxAseo", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, "v", auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                } else if (item.equals("Pilas")) {
                    auxpilas = settings.getString("auxPilas", "");
                    if (auxpilas.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_pilas_r);
                        edit.putString("auxPilas", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, "r", auxembotellada, auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_pilas);
                        edit.putString("auxPilas", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, "v", auxembotellada, auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                } else if (item.equals("Botiquín de primeros auxilios")) {
                    auxaux = settings.getString("auxAux", "");
                    if (auxaux.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_primerosaux_r);
                        edit.putString("auxAux", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, "r", auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_primerosaux);
                        edit.putString("auxAux", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, "v", auxpilas, auxembotellada, auxaseo, auxsnack, auxradio, auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                } else if (item.equals("Radio portatíl")) {
                    auxradio = settings.getString("auxRadio", "");
                    if (auxradio.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_radio_r);
                        edit.putString("auxRadio", "r");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, "r", auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);


                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_radio);
                        edit.putString("auxRadio", "v");
                        edit.apply();
                        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas, auxembotellada, auxaseo, auxsnack, "v", auxropa, auxbolsas);
                        ListAdapter_kit adapter1 = new ListAdapter_kit(getActivity(), items, descriptions, vr);
                        lv.setAdapter(adapter1);
                    }
                }
            }
        });
        return rootView;
        }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

}
