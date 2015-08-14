package com.example.yoyo.sismicapp.ListAdapters;



import android.app.Activity;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yoyo.sismicapp.R;

import java.util.List;

///hacer simplemente un list view con 2 text uno que llame al string de la info y otro con "...", en primera instancia se muestra el
//text 1 con restriccion de X caracteres + el text "..." visible, al hacer click, se quita la restriccion de caracteres y se pone
//gone el text "..."
public class ListAdapter_InfoAndPrev extends BaseAdapter {
    private final List<String> completes;
    private final List<String> summaries;
    private final String type;
    public LayoutInflater inflater;
    public Fragment activity;

    public ListAdapter_InfoAndPrev(Activity act, String type, List<String> completes, List<String> summaries){
        this.completes = completes;
        this.summaries= summaries;
        this.type = type;
        inflater = act.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listrow_infoandprev, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.textView6);
        ImageView icon = (ImageView) convertView.findViewById(R.id.typeicon);
        text.setText(summaries.get(position));
        if (position==0){icon.setBackgroundResource(R.drawable.nnew_information);;}
        else if (position==1){
            if (type.equals("info")){icon.setBackgroundResource(R.drawable.nnew_summary);}
            else if (type.equals("prev")){icon.setBackgroundResource(R.drawable.nnew_whattodo);}
        }
        else if (position==2){icon.setBackgroundResource(R.drawable.nnew_fact);}

        return convertView;
    }

    @Override
    public int getCount() {
        return completes.size();
    }

    @Override
    public Object getItem(int position) {
        return completes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
