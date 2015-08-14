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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Fragment_miplan_home extends Fragment {
    View rootView;
    ImageView deboJuntarme;
    TextView titlejuntarme;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.miplan_home, container, false);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String lugardeencuentro = settings.getString("lugarDeEncuentro", "");
        deboJuntarme = (ImageView) rootView.findViewById(R.id.debojuntarme);
        titlejuntarme = (TextView) rootView.findViewById(R.id.textView2);
        String gastext= settings.getString("gasYo", "");
        String luztext= settings.getString("luzYo", "");
        String aguatext= settings.getString("aguaYo", "");
        LinearLayout gas = (LinearLayout) rootView.findViewById(R.id.linearLayout3);
        LinearLayout luz = (LinearLayout) rootView.findViewById(R.id.linearLayout4);
        LinearLayout agua = (LinearLayout) rootView.findViewById(R.id.linearLayout5);
        TextView nada = (TextView) rootView.findViewById(R.id.textView14);

        if (gastext.equals("yo")||aguatext.equals("yo")||luztext.equals("yo")){
            nada.setVisibility(View.GONE);
        }
        if (gastext.equals("yo")){
            gas.setVisibility(View.VISIBLE);
        }
        if (aguatext.equals("yo")){
            agua.setVisibility(View.VISIBLE);
        }
        if (luztext.equals("yo")){
            luz.setVisibility(View.VISIBLE);
        }
        if (lugardeencuentro.equals("casa")){deboJuntarme.setBackgroundResource(R.drawable.nnew_casa);
            titlejuntarme.setText("Casa");
        }
        else if (lugardeencuentro.equals("oficina")){deboJuntarme.setBackgroundResource(R.drawable.nnew_oficina);
            titlejuntarme.setText("Oficina");
        }
        else if (lugardeencuentro.equals("parque")){deboJuntarme.setBackgroundResource(R.drawable.nnew_parque);
            titlejuntarme.setText("Parque");}
        else if (lugardeencuentro.equals("colegio")){deboJuntarme.setBackgroundResource(R.drawable.nnew_colegio);
            titlejuntarme.setText("Colegio");}
        else {deboJuntarme.setVisibility(View.INVISIBLE);
            titlejuntarme.setText("No se ha establecido lugar de encuentro");
        }
        List<String> total = Arrays.asList(settings.getString("auxLinterna", ""), settings.getString("auxBolsas", ""),
                settings.getString("auxSnack", ""),settings.getString("auxEmbotellada", ""), settings.getString("auxRopa", ""),
                settings.getString("auxAseo", ""), settings.getString("auxPilas", ""), settings.getString("auxAux", ""),
                settings.getString("auxRadio", ""));
        int auxtotal=0;
        for(String str: total) {
            if (str.equals("v")){auxtotal=auxtotal+1;}
        }
        final TextView falta = (TextView) rootView.findViewById(R.id.falta);
        falta.setText(Html.fromHtml("Aún te falta(n) <b>" + (String.valueOf(9 - auxtotal)) + "</b> item(s) por agregar a tu Kit."));

        return rootView;
    }
}