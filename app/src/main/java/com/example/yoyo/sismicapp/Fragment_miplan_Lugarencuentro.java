package com.example.yoyo.sismicapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_miplan_Lugarencuentro extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_lugarencuentro, container, false);

        final TextView lugaractual = (TextView) rootView.findViewById(R.id.lugaractual);
        final EditText miplan_campo_lugarencuentro = (EditText) rootView.findViewById(R.id.miplan_ingresalugar_text);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String lugardeencuentro = settings.getString("lugarDeEncuentro", "");
        miplan_campo_lugarencuentro.setText(lugardeencuentro);
        lugaractual.setText(lugardeencuentro);

        Button miplan_btn_guardarlugar = (Button) rootView.findViewById(R.id.miplan_button_guardarlugar);
        miplan_btn_guardarlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String lugardeencuentro = miplan_campo_lugarencuentro.getText().toString();
                edit.putString ("lugarDeEncuentro", lugardeencuentro );
                edit.apply();
                lugaractual.setText(lugardeencuentro);
                InputMethodManager aux = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                aux.hideSoftInputFromWindow(miplan_campo_lugarencuentro.getWindowToken(), 0);


                Toast.makeText(view.getContext(), "Se guardo el lugar de encuentro",
                        Toast.LENGTH_SHORT).show();

            }
        });



        return rootView;
    }
}