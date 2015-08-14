package com.example.yoyo.sismicapp.ListAdapters;

import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yoyo.sismicapp.R;

import java.util.List;

/**
 * Created by rodrigo on 14-08-2015.
 */
public class ListAdapter_spinner extends BaseAdapter {
    private final List<String> list;
    public LayoutInflater inflater;
    public final List<String> type;
    public Fragment activity;

    public ListAdapter_spinner(Activity act, List<String> list, List<String> type){
        this.list= list;
        this.type=type;
        inflater = act.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_spinner, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.textView6);
        ImageView icon = (ImageView) convertView.findViewById(R.id.typeicon);
        if (type.get(position).equals("papa")){icon.setBackgroundResource(R.drawable.new_papa);}
        else if (type.get(position).equals("mama")) {icon.setBackgroundResource(R.drawable.new_mama);}
        else if (type.get(position).equals("hijo")){icon.setBackgroundResource(R.drawable.new_hijo);}
        else if (type.get(position).equals("hija")){icon.setBackgroundResource(R.drawable.new_hija);}
        text.setText(list.get(position));

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