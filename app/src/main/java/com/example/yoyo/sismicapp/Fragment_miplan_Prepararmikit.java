package com.example.yoyo.sismicapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.AnyRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Fragment_miplan_Prepararmikit extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_prepararmikit, container, false);

        //***************** BOTONERA PREPARAR MI KIT***************************

        final ImageButton btnLinterna = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonLinterna);
        final ImageButton btnBolsas = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonBolsas);
        final ImageButton btnAseo = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonArtAseo);
        final ImageButton btnEmbotellada = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonEmbotellada);
        final ImageButton btnRopa = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonRopa);
        final ImageButton btnPapel = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonPapel);
        final ImageButton btnPilas = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonPilas);
        final ImageButton btnAux = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonPrimerosAux);
        final ImageButton btnRadio = (ImageButton) rootView.findViewById(R.id.miplan_imageButtonRadio);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String auxlinterna = settings.getString("auxLinterna", "");
        String auxbolsas= settings.getString("auxBolsas", "");
        String auxaseo = settings.getString("auxAseo", "");
        String auxembotellada = settings.getString("auxEmbotellada", "");
        String auxropa = settings.getString("auxRopa", "");
        String auxpapel = settings.getString("auxPapel", "");
        String auxpilas = settings.getString("auxPilas", "");
        String auxaux = settings.getString("auxAux", "");
        String auxradio = settings.getString("auxRadio", "");


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

        if (auxaseo.equals("v")) {btnAseo.setBackgroundResource(R.drawable.kit_artaseo);
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
        if (auxpapel.equals("v")) {btnPapel.setBackgroundResource(R.drawable.kit_papel);
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
//--------------------------------Botones-----------------------------------------------------
        btnLinterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxlinterna = settings.getString("auxLinterna", "");
                if (auxlinterna.equals("r")){
                    btnLinterna.setBackgroundResource(R.drawable.kit_linterna);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxlinterna1="v";
                    edit.putString("auxLinterna", auxlinterna1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Linterna al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnLinterna.setBackgroundResource(R.drawable.kit_linterna_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxlinterna1="r";
                    edit.putString("auxLinterna", auxlinterna1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Linterna del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });
        btnBolsas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxbolsas = settings.getString("auxBolsas", "");
                if (auxbolsas.equals("r")){
                    btnBolsas.setBackgroundResource(R.drawable.kit_bolsas);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxbolsas1="v";
                    edit.putString("auxBolsas", auxbolsas1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Bolsas al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnBolsas.setBackgroundResource(R.drawable.kit_bolsas_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxbolsas1="r";
                    edit.putString("auxBolsas", auxbolsas1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Bolsas del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });

        btnAseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxaseo = settings.getString("auxAseo", "");
                if (auxaseo.equals("r")){
                    btnAseo.setBackgroundResource(R.drawable.kit_artaseo);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxaseo1="v";
                    edit.putString("auxAseo", auxaseo1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Comida al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnAseo.setBackgroundResource(R.drawable.kit_artaseo_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxaseo1="r";
                    edit.putString("auxAseo", auxaseo1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Comida del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });


        btnEmbotellada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxembotellada = settings.getString("auxEmbotellada", "");
                if (auxembotellada.equals("r")){
                    btnEmbotellada.setBackgroundResource(R.drawable.kit_embotellada);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxembotellada1="v";
                    edit.putString("auxEmbotellada", auxembotellada1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Agua al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnEmbotellada.setBackgroundResource(R.drawable.kit_embotellada_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxembotellada1="r";
                    edit.putString("auxEmbotellada", auxembotellada1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Agua del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });

        btnRopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxropa = settings.getString("auxRopa", "");
                if (auxropa.equals("r")){
                    btnRopa.setBackgroundResource(R.drawable.kit_ropa);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxropa1="v";
                    edit.putString("auxRopa", auxropa1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Ropa al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnRopa.setBackgroundResource(R.drawable.kit_ropa_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxropa1="r";
                    edit.putString("auxRopa", auxropa1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Ropa del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });

        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxpapel = settings.getString("auxPapel", "");
                if (auxpapel.equals("r")){
                    btnPapel.setBackgroundResource(R.drawable.kit_papel);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxpapel1="v";
                    edit.putString("auxPapel", auxpapel1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Papel Higiénico al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnPapel.setBackgroundResource(R.drawable.kit_papel_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxpapel1="r";
                    edit.putString("auxPapel", auxpapel1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Papel Higiénico del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });

        btnPilas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxpilas = settings.getString("auxPilas", "");
                if (auxpilas.equals("r")){
                    btnPilas.setBackgroundResource(R.drawable.kit_pilas);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxpilas1="v";
                    edit.putString("auxPilas", auxpilas1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Pilas al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnPilas.setBackgroundResource(R.drawable.kit_pilas_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxpilas1="r";
                    edit.putString("auxPilas", auxpilas1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Pilas del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }



        });

        btnAux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxaux= settings.getString("auxAux", "");
                if (auxaux.equals("r")){
                    btnAux.setBackgroundResource(R.drawable.kit_primerosaux);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxaux1="v";
                    edit.putString("auxAux", auxaux1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Art. de Primeros Auxilios al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnAux.setBackgroundResource(R.drawable.kit_primerosaux_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxaux1="r";
                    edit.putString("auxAux", auxaux1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Art. de Primeros Auxilios del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });


        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String auxradio = settings.getString("auxRadio", "");
                if (auxradio.equals("r")){
                    btnRadio.setBackgroundResource(R.drawable.kit_radio);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxradio1="v";
                    edit.putString("auxRadio", auxradio1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se agregó Radio al Kit",
                            Toast.LENGTH_SHORT).show();



                }
                else {
                    btnRadio.setBackgroundResource(R.drawable.kit_radio_r);
                    SharedPreferences.Editor edit = settings.edit();
                    String auxradio1="r";
                    edit.putString("auxRadio", auxradio1);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se quitó Radio del Kit",
                            Toast.LENGTH_SHORT).show();
                }
            }


        });


        return rootView;
        }


}
