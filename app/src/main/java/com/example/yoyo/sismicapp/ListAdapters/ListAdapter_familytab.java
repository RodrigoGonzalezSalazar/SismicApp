package com.example.yoyo.sismicapp.ListAdapters;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yoyo.sismicapp.Activity_miplan;
import com.example.yoyo.sismicapp.R;
import com.example.yoyo.sismicapp.SuperQuizActivity;

import java.util.List;

public class ListAdapter_familytab extends BaseAdapter {
    private final List<String> list;
    public LayoutInflater inflater;
    public final List<String> type;
    public Activity activity;
    public Context context;
    public ListAdapter_familytab(Activity activity, List<String> list, List<String> type){
        this.list= list;
        this.type=type;
        this.activity=activity;
        inflater = activity.getLayoutInflater();
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_familytab, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.textView6);
        ImageView icon = (ImageView) convertView.findViewById(R.id.typeicon);
        ImageButton delete = (ImageButton) convertView.findViewById(R.id.delete);
        if (type.get(position).equals("papa")){icon.setBackgroundResource(R.drawable.new_papa);}
        else if (type.get(position).equals("mama")) {icon.setBackgroundResource(R.drawable.new_mama);}
        else if (type.get(position).equals("hijo")){icon.setBackgroundResource(R.drawable.new_hijo);}
        else if (type.get(position).equals("hija")){icon.setBackgroundResource(R.drawable.new_hija);}
        text.setText(list.get(position));
        if (position==0){ delete.setVisibility(View.GONE);
            delete.setClickable(false);
            }
        ImageButton deleteButton = (ImageButton) convertView.findViewById(R.id.delete);
        deleteButton.setTag(position);

        deleteButton.setOnClickListener(
                new Button.OnClickListener() {
                    String aux=list.get(0)+";"+type.get(0);
                    @Override
                    public void onClick(View v) {
                        Integer index = (Integer) v.getTag();
                        list.remove(index.intValue());
                        type.remove(index.intValue());
                        notifyDataSetChanged();
                        for (int i = 1; i < list.size(); i++) {
                            aux=aux+";"+list.get(i)+";"+type.get(i);
                        }
                        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(activity);
                        SharedPreferences.Editor edit = settings.edit();
                        edit.putString("familia", aux);
                        edit.apply();
                        activity.finish();
                        Intent q = new Intent(activity, Activity_miplan.class);
                        activity.startActivity(q);
                    }
                });

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}