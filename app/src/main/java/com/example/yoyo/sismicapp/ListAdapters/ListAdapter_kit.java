package com.example.yoyo.sismicapp.ListAdapters;



import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yoyo.sismicapp.Activity_miplan;
import com.example.yoyo.sismicapp.R;

import java.util.List;

public class ListAdapter_kit extends BaseAdapter {
    private final List<String> items;
    public LayoutInflater inflater;
    public final List<String> descriptions;
    public Activity activity;
    public final List<String> vr;

    public ListAdapter_kit(Activity activity, List<String> items, List<String> descriptions, List<String> vr){
        this.items= items;
        this.vr =vr;
        this.descriptions=descriptions;
        this.activity=activity;
        inflater = activity.getLayoutInflater();
    }
    ImageView icon;
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_prepararkit, null);
        }
        TextView desc = (TextView) convertView.findViewById(R.id.textView6);
        TextView title = (TextView) convertView.findViewById(R.id.textView8);
        icon = (ImageView) convertView.findViewById(R.id.typeicon);
        LinearLayout linear= (LinearLayout) convertView.findViewById(R.id.w4);
        if (items.get(position).equals("Linterna")) {
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_linterna);
            }
            else {icon.setBackgroundResource(R.drawable.kit_linterna_r);
            }
        }
        else if (items.get(position).equals("Bolsas de basura")) {
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_bolsas);
            }
            else {icon.setBackgroundResource(R.drawable.kit_bolsas_r);
            }
        }
        else if (items.get(position).equals("Comida tipo Snack")){
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_snack);
            }
            else {icon.setBackgroundResource(R.drawable.kit_snack_r);
            }
        }
        else if (items.get(position).equals("Agua embotellada")){
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_embotellada);
            }
            else {icon.setBackgroundResource(R.drawable.kit_embotellada_r);
            }
        }
        else if (items.get(position).equals("Ropa")) {
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_ropa);
            }
            else {icon.setBackgroundResource(R.drawable.kit_ropa_r);
            }
        }
        else if (items.get(position).equals("Artículos de aseo")){
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_aseo);
            }
            else {icon.setBackgroundResource(R.drawable.kit_aseo_r);
            }
        }
        else if (items.get(position).equals("Pilas")){
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_pilas);
            }
            else {icon.setBackgroundResource(R.drawable.kit_pilas_r);
            }
        }
        else if (items.get(position).equals("Botiquín de primeros auxilios")){
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_primerosaux);
            }
            else {icon.setBackgroundResource(R.drawable.kit_primerosaux_r);
            }
        }
        else if (items.get(position).equals("Radio portatíl")){
            if (vr.get(position).equals("v")) {
                icon.setBackgroundResource(R.drawable.kit_radio);
            }
            else {
                icon.setBackgroundResource(R.drawable.kit_radio_r);
            }
        }
        title.setText(items.get(position));
        desc.setText(descriptions.get(position));

        linear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(activity);
                SharedPreferences.Editor edit = settings.edit();
                if (items.get(position).equals("Linterna")) {
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_linterna_r);
                        vr.set(position,"r");
                        edit.putString("auxLinterna", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_linterna);
                        vr.set(position,"v");
                        edit.putString("auxLinterna", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Bolsas de basura")) {
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_bolsas_r);
                        vr.set(position,"r");
                        edit.putString("auxBolsas", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_bolsas);
                        vr.set(position,"v");
                        edit.putString("auxBolsas", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Comida tipo Snack")){
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_snack_r);
                        vr.set(position,"r");
                        edit.putString("auxSnack", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_snack);
                        vr.set(position,"v");
                        edit.putString("auxSnack", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Agua embotellada")){
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_embotellada_r);
                        vr.set(position,"r");
                        edit.putString("auxEmbotellada", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_embotellada);
                        vr.set(position,"v");
                        edit.putString("auxEmbotellada", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Ropa")) {
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_ropa_r);
                        vr.set(position,"r");
                        edit.putString("auxRopa", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_ropa);
                        vr.set(position,"v");
                        edit.putString("auxRopa", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Artículos de aseo")){
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_aseo_r);
                        vr.set(position,"r");
                        edit.putString("auxAseo", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_aseo);
                        vr.set(position,"v");
                        edit.putString("auxAseo", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Pilas")){
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_pilas_r);
                        vr.set(position,"r");
                        edit.putString("auxPilas", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_pilas);
                        vr.set(position,"v");
                        edit.putString("auxPilas", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Botiquín de primeros auxilios")){
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_primerosaux_r);
                        vr.set(position,"r");
                        edit.putString("auxAux", "r");
                        edit.apply();
                    }
                    else {icon.setBackgroundResource(R.drawable.kit_primerosaux);
                        vr.set(position,"v");
                        edit.putString("auxAux", "v");
                        edit.apply();
                    }
                }
                else if (items.get(position).equals("Radio portatíl")){
                    if (vr.get(position).equals("v")) {
                        icon.setBackgroundResource(R.drawable.kit_radio_r);
                        vr.set(position,"r");
                        edit.putString("auxRadio", "r");
                        edit.apply();
                    }
                    else {
                        icon.setBackgroundResource(R.drawable.kit_radio);
                        vr.set(position,"v");
                        edit.putString("auxRadio", "v");
                        edit.apply();
                    }
                }
                notifyDataSetChanged();
            }
        });
        return convertView;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}