package com.example.a19434551_hothihongthuy_tk3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    public SanPhamAdapter(@NonNull Context context, @NonNull List<SanPham> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_item_gridview, parent, false);
        }
        SanPham sanPham = getItem(position);
        TextView tvTenSanPham = listitemView.findViewById(R.id.tvTenSanPham);
        TextView tvGiaSanPham = listitemView.findViewById(R.id.tvGiaSanPham);
        ImageView imageViewSP = listitemView.findViewById(R.id.imageSanPham);
        tvTenSanPham.setText(sanPham.getNameCake());
        tvGiaSanPham.setText(String.valueOf(sanPham.getPriceCake())+"đ");
        imageViewSP.setImageResource(sanPham.getImageCake());
        return listitemView;
    }
}
