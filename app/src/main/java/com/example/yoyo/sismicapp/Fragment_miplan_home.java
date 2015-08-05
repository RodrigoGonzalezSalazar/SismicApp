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

public class Fragment_miplan_home extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_home, container, false);

        final TextView deboHacer = (TextView) rootView.findViewById(R.id.debohacer);
        final TextView deboJuntarme = (TextView) rootView.findViewById(R.id.debojuntarme);
        final TextView falta = (TextView) rootView.findViewById(R.id.falta);
        final TextView deboEquipar = (TextView) rootView.findViewById(R.id.deboequipar);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String lugardeencuentro = settings.getString("lugarDeEncuentro", "");

        String checkagua = settings.getString("checkAgua", "");
        String checkluz = settings.getString("checkLuz", "");
        String checkgas = settings.getString("checkGas", "");
        String tareastuyas="";
        if (checkgas.equals("c")){tareastuyas=tareastuyas+"Cortar el gas, ";}
        if (checkluz.equals("c")){tareastuyas=tareastuyas+"Cortar la luz, ";}
        if (checkagua.equals("c")){tareastuyas=tareastuyas+"Cortar el agua";}



        String auxlinterna = settings.getString("auxLinterna", "");
        String auxbolsas= settings.getString("auxBolsas", "");
        String auxaseo = settings.getString("auxAseo", "");
        String auxembotellada = settings.getString("auxEmbotellada", "");
        String auxropa = settings.getString("auxRopa", "");
        String auxpapel = settings.getString("auxPapel", "");
        String auxpilas = settings.getString("auxPilas", "");
        String auxaux = settings.getString("auxAux", "");
        String auxradio = settings.getString("auxRadio", "");

        String todo = "";
        if(auxlinterna.equals("r")) {todo =todo+ "Linterna, ";}
        if(auxbolsas.equals("r")) {todo =todo+ "Bolsas, ";}
        if(auxaseo.equals("r")) {todo =todo+ "Comida, ";}
        if(auxembotellada.equals("r")) {todo =todo+ "Agua, ";}
        if(auxropa.equals("r")) {todo =todo+ "Ropa, ";}
        if(auxpapel.equals("r")) {todo =todo+ "Papel higiénico, ";}
        if(auxpilas.equals("r")) {todo =todo+ "Pilas, ";}
        if(auxaux.equals("r")) {todo =todo+ "Art. de Primeros Auxilios, ";}
        if(auxradio.equals("r")) {todo =todo+ "Radio";}


        deboHacer.setText(tareastuyas);
        deboJuntarme.setText(lugardeencuentro);
        falta.setText("Te falta agregar al kit:");
        deboEquipar.setText(todo);

        //------------------------------------Ingreso Nombre-----------------------------
        final EditText miplan_campo_nombre = (EditText) rootView.findViewById(R.id.minombre);
        String ingresonombre = settings.getString("ingresoNombre", "");
        miplan_campo_nombre.setText(ingresonombre);

        Button miplan_btn_minombre = (Button) rootView.findViewById(R.id.miplan_button_minombre);
        miplan_btn_minombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor edit = settings.edit();
                String ingresonombre = miplan_campo_nombre.getText().toString();
                edit.putString ("ingresoNombre", ingresonombre );
                edit.apply();
                InputMethodManager aux = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                aux.hideSoftInputFromWindow(miplan_campo_nombre.getWindowToken(), 0);


                Toast.makeText(view.getContext(), "Se guardo su nombre",
                        Toast.LENGTH_SHORT).show();

            }

        });
        return rootView;
    }
}