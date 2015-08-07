package com.example.yoyo.sismicapp;

import android.content.SharedPreferences;
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
        List<String> items = Arrays.asList("Linterna", "Botiquín de primeros auxilios", "Pilas", "Agua embotellada", "Artículos de aseo", "Comida tipo Snack", "Radio portatíl", "Ropa", "Bolsas de basura");
        List<String> descriptions = Arrays.asList("Descripción 1..", "Descripción 2..", "Descripción 3..","Descripción 4..","Descripción 5..","Descripción 6..", "Descripción 7..","Descripción 8..", "Descripción 9..");
        List<String> vr = Arrays.asList(auxlinterna, auxaux, auxpilas,auxembotellada, auxaseo,auxsnack, auxradio,auxropa,auxbolsas);
        ListAdapter_kit adapter = new ListAdapter_kit(getActivity(), items, descriptions, vr);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long arg3) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String item = String.valueOf(lv.getItemAtPosition(position));
                ImageView imageView = (ImageView) view.findViewById(R.id.typeicon);
                if (item.equals("Linterna")) {
                    auxlinterna = settings.getString("auxLinterna", "");
                    if (auxlinterna.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_linterna_r);
                        edit.putString("auxLinterna", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Linterna del Kit", Toast.LENGTH_SHORT).show();
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_linterna);
                        edit.putString("auxLinterna", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Linterna al Kit", Toast.LENGTH_SHORT).show();
                    }

                } else if (item.equals("Bolsas de basura")) {
                    auxbolsas = settings.getString("auxBolsas", "");
                    if (auxbolsas.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_bolsas_r);
                        edit.putString("auxBolsas", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Bolsas del Kit", Toast.LENGTH_SHORT).show();
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_bolsas);
                        edit.putString("auxBolsas", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Bolsas al Kit", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("Comida tipo Snack")) {
                    auxsnack = settings.getString("auxSnack", "");
                    if (auxsnack.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_snack_r);
                        edit.putString("auxSnack", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Comida del Kit", Toast.LENGTH_SHORT).show();

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_snack);
                        edit.putString("auxSnack", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Comida al Kit", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("Agua embotellada")) {
                    auxembotellada = settings.getString("auxEmbotellada", "");
                    if (auxembotellada.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_embotellada_r);
                        edit.putString("auxEmbotellada", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Agua del Kit", Toast.LENGTH_SHORT).show();
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_embotellada);
                        edit.putString("auxEmbotellada", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Agua al Kit", Toast.LENGTH_SHORT).show();
                    }

                } else if (item.equals("Ropa")) {
                    auxropa = settings.getString("auxRopa", "");
                    if (auxropa.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_ropa_r);
                        edit.putString("auxRopa", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Ropa del Kit", Toast.LENGTH_SHORT).show();
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_ropa);
                        edit.putString("auxRopa", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Ropa al Kit", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("Artículos de aseo")) {
                    auxaseo = settings.getString("auxAseo", "");
                    if (auxaseo.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_aseo_r);
                        edit.putString("auxAseo", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Artículos de aseo del Kit", Toast.LENGTH_SHORT).show();

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_aseo);
                        edit.putString("auxAseo", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Artículos de aseo al Kit", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("Pilas")) {
                    auxpilas = settings.getString("auxPilas", "");
                    if (auxpilas.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_pilas_r);
                        edit.putString("auxPilas", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Pilas del Kit", Toast.LENGTH_SHORT).show();
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_pilas);
                        edit.putString("auxPilas", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Pilas al Kit", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("Botiquín de primeros auxilios")) {
                    auxaux = settings.getString("auxAux", "");
                    if (auxaux.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_primerosaux_r);
                        edit.putString("auxAux", "r");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se quitó Art. de Primeros Auxilios del Kit", Toast.LENGTH_SHORT).show();
                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_primerosaux);
                        edit.putString("auxAux", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Art. de Primeros Auxilios al Kit", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("Radio portatíl")) {
                    auxradio = settings.getString("auxRadio", "");
                    if (auxradio.equals("v")) {
                        imageView.setBackgroundResource(R.drawable.kit_radio_r);
                        edit.putString("auxRadio", "r");
                        edit.apply();

                        Toast.makeText(view.getContext(), "Se quitó Radio del Kit", Toast.LENGTH_SHORT).show();

                    } else {
                        imageView.setBackgroundResource(R.drawable.kit_radio);
                        edit.putString("auxRadio", "v");
                        edit.apply();
                        Toast.makeText(view.getContext(), "Se agregó Radio al Kit", Toast.LENGTH_SHORT).show();

                    }
                }
            }

        });
        //ImageView imageView1= (ImageView) getViewByPosition(1,lv).findViewById(R.id.typeicon);
        //imageView1.setBackgroundResource(R.drawable.kit_bolsas);

        /**
        if (auxlinterna.equals("v")) {btnLinterna.setBackgroundResource(R.drawable.kit_linterna);
            String auxlinterna1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxLinterna", auxlinterna1);
            edit.apply();
        }
        else {btnLinterna.setBackgroundResource(R.drawable.kit_linterna_r);
            String auxlinterna1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxLinterna", auxlinterna1);
            edit.apply();

        }

        if (auxbolsas.equals("v")) {btnBolsas.setBackgroundResource(R.drawable.kit_bolsas);
            String auxbolsa1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxBolsas", auxbolsa1);
            edit.apply();

        }
        else {btnBolsas.setBackgroundResource(R.drawable.kit_bolsas_r);
            String auxbolsa1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxBolsas", auxbolsa1);
            edit.apply();
        }

        if (auxsnack.equals("v")) {btnAseo.setBackgroundResource(R.drawable.kit_artaseo);
            String auxaseo1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxAseo", auxaseo1);
            edit.apply();
        }
        else {btnAseo.setBackgroundResource(R.drawable.kit_artaseo_r);
            String auxaseo1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxAseo", auxaseo1);
            edit.apply();
        }

        if (auxembotellada.equals("v")) {btnEmbotellada.setBackgroundResource(R.drawable.kit_embotellada);
            String auxembotellada1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxEmbotellada", auxembotellada1);
            edit.apply();
        }
        else {btnEmbotellada.setBackgroundResource(R.drawable.kit_embotellada_r);
            String auxembotellada1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxEmbotellada", auxembotellada1);
            edit.apply();
        }

        if (auxropa.equals("v")) {btnRopa.setBackgroundResource(R.drawable.kit_ropa);
            String auxropa1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxRopa", auxropa1);
            edit.apply();
        }
        else {btnRopa.setBackgroundResource(R.drawable.kit_ropa_r);
            String auxropa1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxRopa", auxropa1);
            edit.apply();
        }
        if (auxaseo.equals("v")) {btnPapel.setBackgroundResource(R.drawable.kit_papel);
            String auxpapel1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxPapel", auxpapel1);
            edit.apply();
        }
        else {btnPapel.setBackgroundResource(R.drawable.kit_papel_r);
            String auxpapel1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxPapel", auxpapel1);
            edit.apply();
        }

        if (auxaux.equals("v")) {btnAux.setBackgroundResource(R.drawable.kit_primerosaux);
            String auxaux1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxAux", auxaux1);
            edit.apply();
        }
        else {btnAux.setBackgroundResource(R.drawable.kit_primerosaux_r);
            String auxaux1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxAux", auxaux1);
            edit.apply();
        }

        if (auxpilas.equals("v")) {btnPilas.setBackgroundResource(R.drawable.kit_pilas);
            String auxpilas1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxPilas", auxpilas1);
            edit.apply();
        }
        else {btnPilas.setBackgroundResource(R.drawable.kit_pilas_r);
            String auxpilas1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxPilas", auxpilas1);
            edit.apply();
        }

        if (auxradio.equals("v")) {btnRadio.setBackgroundResource(R.drawable.kit_radio);
            String auxradio1="v";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxRadio", auxradio1);
            edit.apply();
        }
        else {btnRadio.setBackgroundResource(R.drawable.kit_radio_r);
            String auxradio1="r";
            SharedPreferences.Editor edit = settings.edit();
            edit.putString("auxRadio", auxradio1);
            edit.apply();
        }

         */
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
