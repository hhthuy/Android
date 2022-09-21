package com.example.fragmenttestdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class Frament1Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Product> productList;

    public Frament1Adapter(Context context, int layout, List<Product> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        if(productList.size() > 0 && i >= 0){
            final Product sp = productList.get(i);
            final ImageView img = (ImageView) view.findViewById(R.id.img_sanpham);
            final TextView tv_tensp = (TextView) view.findViewById(R.id.tv_tensp);
            final TextView tv_dongia = (TextView) view.findViewById(R.id.tv_dongia);
            img.setImageResource(sp.getImg());
            tv_tensp.setText(sp.getName());
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            tv_dongia.setText(formatter.format(sp.getPrice())+" VND");
        }
        return  view;
    }
}