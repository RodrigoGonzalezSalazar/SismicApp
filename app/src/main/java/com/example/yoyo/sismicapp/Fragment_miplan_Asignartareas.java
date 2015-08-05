package com.example.yoyo.sismicapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment_miplan_Asignartareas extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_asignartareas, container, false);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());

        final CheckBox miplan_check_gas = (CheckBox) rootView.findViewById(R.id.asignarmegas);
        final CheckBox miplan_check_agua = (CheckBox) rootView.findViewById(R.id.asignarmeagua);
        final CheckBox miplan_check_luz = (CheckBox) rootView.findViewById(R.id.asignarmeluz);

        final EditText miplan_campo_gas = (EditText) rootView.findViewById(R.id.miplan_ingresagas_text);

        final EditText miplan_campo_agua = (EditText) rootView.findViewById(R.id.miplan_ingresagua_text);
        final EditText miplan_campo_luz = (EditText) rootView.findViewById(R.id.miplan_ingresaluz_text);

//----------------------------------------- If check-----------------------------------------
        String checkagua = settings.getString("checkAgua", "");
        if (checkagua.equals("c")){
            miplan_check_agua.setChecked(true);
        }
        if (checkagua.equals("u")){
            miplan_check_agua.setChecked(false);
        }
        String checkluz = settings.getString("checkLuz", "");
        if (checkluz.equals("c")){
            miplan_check_luz.setChecked(true);
        }
        if (checkluz.equals("u")){
            miplan_check_luz.setChecked(false);
        }
        String checkgas = settings.getString("checkGas", "");
        if (checkgas.equals("c")){
            miplan_check_gas.setChecked(true);
        }
        if (checkgas.equals("u")){
            miplan_check_gas.setChecked(false);
        }

//-----------------------------------------------Check Box-----------------------------------
        miplan_check_agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                if (miplan_check_agua.isChecked()) {
                    String ingresonombre= settings.getString("ingresoNombre", "");
                    miplan_campo_agua.setText(ingresonombre);
                    String checkagua="c";
                    SharedPreferences.Editor edit = settings.edit();
                    edit.putString("ingresoAgua", ingresonombre);
                    edit.putString("checkAgua", checkagua);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se te asigno esta tarea",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    String checkagua="u";
                    SharedPreferences.Editor edit = settings.edit();
                    String ingresonombre= "";
                    miplan_campo_agua.setText(ingresonombre);
                    edit.putString("ingresoAgua", ingresonombre);
                    edit.putString("checkAgua", checkagua);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se te quitó esta tarea",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
        miplan_check_luz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                if (miplan_check_luz.isChecked()) {
                    String ingresonombre = settings.getString("ingresoNombre", "");
                    miplan_campo_luz.setText(ingresonombre);
                    String checkluz = "c";
                    SharedPreferences.Editor edit = settings.edit();
                    edit.putString("ingresoLuz", ingresonombre);
                    edit.putString("checkLuz", checkluz);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se te asigno esta tarea",
                            Toast.LENGTH_SHORT).show();

                } else {
                    String checkluz = "u";
                    SharedPreferences.Editor edit = settings.edit();
                    String ingresonombre = "";
                    miplan_campo_luz.setText(ingresonombre);
                    edit.putString("ingresoLuz", ingresonombre);
                    edit.putString("checkLuz", checkluz);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se te quitó esta tarea",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
        miplan_check_gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                if (miplan_check_gas.isChecked()) {
                    String ingresonombre= settings.getString("ingresoNombre", "");
                    miplan_campo_gas.setText(ingresonombre);
                    String checkgas="c";
                    SharedPreferences.Editor edit = settings.edit();
                    edit.putString("ingresoGas", ingresonombre);
                    edit.putString("checkGas", checkgas);
                    edit.apply();

                    Toast.makeText(view.getContext(), "Se te asigno esta tarea",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    String checkgas="u";
                    SharedPreferences.Editor edit = settings.edit();
                    String ingresonombre= "";
                    miplan_campo_gas.setText(ingresonombre);
                    edit.putString("ingresoGas", ingresonombre);
                    edit.putString("checkGas", checkgas);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se te quitó esta tarea",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });


//_------------------------------------------Ingreso Gas------------------------------------------------
        String ingresogas = settings.getString("ingresoGas", "");
        miplan_campo_gas.setText(ingresogas);

        Button miplan_btn_guardargas = (Button) rootView.findViewById(R.id.miplan_button_guardargas);
        miplan_btn_guardargas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String ingresonombre = settings.getString("ingresoNombre", "");
                String ingresogas = miplan_campo_gas.getText().toString();
                edit.putString("ingresoGas", ingresogas);
                edit.apply();
                InputMethodManager aux = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                aux.hideSoftInputFromWindow(miplan_campo_gas.getWindowToken(), 0);

                if (ingresogas.equals(ingresonombre)){
                    miplan_check_gas.setChecked(true);
                    String checkgas="c";
                    edit.putString("checkGas", checkgas);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se te asignó esta tarea",
                            Toast.LENGTH_SHORT).show();}
                else {
                    miplan_check_gas.setChecked(false);
                    String checkgas="u";
                    miplan_campo_gas.setText(ingresogas);
                    edit.putString("checkGas", checkgas);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se asignó la tarea (Cortar gas)",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

//---------------------------------------------Ingreso Agua------------------------------------------------
        String ingresoagua = settings.getString("ingresoAgua", "");
        miplan_campo_agua.setText(ingresoagua);

        Button miplan_btn_guardaragua = (Button) rootView.findViewById(R.id.miplan_button_guardaragua);
        miplan_btn_guardaragua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String ingresonombre = settings.getString("ingresoNombre", "");
                String ingresoagua = miplan_campo_agua.getText().toString();
                edit.putString("ingresoAgua", ingresoagua);
                edit.apply();
                InputMethodManager aux = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                aux.hideSoftInputFromWindow(miplan_campo_agua.getWindowToken(), 0);

                if (ingresoagua.equals(ingresonombre)){
                    miplan_check_agua.setChecked(true);
                    String checkagua="c";
                    edit.putString("checkAgua", checkagua);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se te asignó esta tarea",
                            Toast.LENGTH_SHORT).show();}
                else {
                    miplan_check_agua.setChecked(false);
                    String checkagua="u";
                    //String ingresonombrealt= ingresonombre;
                    miplan_campo_agua.setText(ingresoagua);
                    //edit.putString("ingresoAgua", ingresonombrealt);
                    edit.putString("checkAgua", checkagua);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se asignó la tarea (Cortar agua)",
                            Toast.LENGTH_SHORT).show();
                }



            }
        });


//----------------------------------------------Ingreso Luz---------------------------------------------------------
        String ingresoluz = settings.getString("ingresoLuz", "");
        miplan_campo_luz.setText(ingresoluz);

        Button miplan_btn_guardarluz = (Button) rootView.findViewById(R.id.miplan_button_guardarluz);
        miplan_btn_guardarluz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String ingresonombre = settings.getString("ingresoNombre", "");
                String ingresoluz = miplan_campo_luz.getText().toString();
                edit.putString("ingresoLuz", ingresoluz);
                edit.apply();
                InputMethodManager aux = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                aux.hideSoftInputFromWindow(miplan_campo_luz.getWindowToken(), 0);

                if (ingresoluz.equals(ingresonombre)){
                    miplan_check_luz.setChecked(true);
                    String checkluz="c";
                    edit.putString("checkLuz", checkluz);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se te asignó esta tarea",
                            Toast.LENGTH_SHORT).show();}
                else {
                    miplan_check_luz.setChecked(false);
                    String checkluz="u";
                    miplan_campo_luz.setText(ingresoluz);
                    edit.putString("checkLuz", checkluz);
                    edit.apply();
                    Toast.makeText(view.getContext(), "Se asignó la tarea (Cortar luz)",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }
}