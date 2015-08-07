package com.example.yoyo.sismicapp;



import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter_kit extends BaseAdapter {
    private final List<String> items;
    public LayoutInflater inflater;
    public final List<String> descriptions;
    public Fragment activity;
    public final List<String> vr;

    public ListAdapter_kit(Activity act, List<String> items, List<String> descriptions, List<String> vr){
        this.items= items;
        this.vr =vr;
        this.descriptions=descriptions;
        inflater = act.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_prepararkit, null);
        }
        TextView desc = (TextView) convertView.findViewById(R.id.textView6);
        TextView title = (TextView) convertView.findViewById(R.id.textView8);
        ImageView icon = (ImageView) convertView.findViewById(R.id.typeicon);
        if (items.get(position).equals("Linterna")) {
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_linterna_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_linterna);
            }
        }
        else if (items.get(position).equals("Bolsas de basura")) {
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_bolsas_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_bolsas);
            }
        }
        else if (items.get(position).equals("Comida tipo Snack")){
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_snack_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_snack);
            }
        }
        else if (items.get(position).equals("Agua embotellada")){
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_embotellada_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_embotellada);
            }
        }
        else if (items.get(position).equals("Ropa")) {
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_ropa_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_ropa);
            }
        }
        else if (items.get(position).equals("Artículos de aseo")){
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_aseo_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_aseo);
            }
        }
        else if (items.get(position).equals("Pilas")){
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_pilas_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_pilas);
            }
        }
        else if (items.get(position).equals("Botiquín de primeros auxilios")){
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_primerosaux_r);
            }
            else {icon.setBackgroundResource(R.drawable.kit_primerosaux);
            }
        }
        else if (items.get(position).equals("Radio portatíl")){
            if (vr.get(position).equals("r")) {
                icon.setBackgroundResource(R.drawable.kit_radio_r);
            }
            else {
                icon.setBackgroundResource(R.drawable.kit_radio);
            }
        }
        title.setText(items.get(position));
        desc.setText(descriptions.get(position));
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