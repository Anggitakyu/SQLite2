package com.example.sqlite2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.sqlite2.R;
import com.example.sqlite2.model.Data;

import java.util.Date;
import java.util.List;

public class Adapter implements ListAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private list<Data>items;

    public Adapter (Activity activity, List<Data> items){
        this.activity = activity;
        this.items = items;
    }
    @Override
    public int getCount(){
        return items.size();
    }
    @Override
    public Object getItem(int location){
        return items.get(location);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater == null)
            convertView = inflater.inflate(R.layout.list_row, null);
        TextView id = (TextView) convertView.findViewById(R.id.txt_id);
        TextView name = (TextView) convertView.findViewById(R.id.nama);
        TextView address = (TextView) convertView.findViewById(R.id.alamat);
        Data data = items.get(position);
        id.setText(data.getId());
        name.setText(data.getName());
        address.setText(data.getAddress());
        return convertView;
    }
}

