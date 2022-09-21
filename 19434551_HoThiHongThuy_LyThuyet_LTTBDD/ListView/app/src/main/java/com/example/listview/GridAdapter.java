package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.drm.DrmStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class GridAdapter extends BaseAdapter {

    private Context context;
    private String[] tenlogo;
    private int[] hinhlogo;

    public GridAdapter(Context context, String[] tenlogo, int[] hinhlogo) {
        this.context = context;
        this.tenlogo = tenlogo;
        this.hinhlogo = hinhlogo;
    }

    @Override
    public int getCount() {
        return tenlogo.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.custom_layout, null);

        TextView tv_tensp = (TextView)convertView.findViewById(R.id.textView_Display);
        ImageView iv_sp = (ImageView)convertView.findViewById(R.id.imageDisplay);

        tv_tensp.setText(tenlogo[position]);
        iv_sp.setImageResource(hinhlogo[position]);
        return convertView;
    }

}