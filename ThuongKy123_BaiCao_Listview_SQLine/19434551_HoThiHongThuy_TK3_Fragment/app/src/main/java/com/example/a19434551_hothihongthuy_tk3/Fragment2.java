package com.example.a19434551_hothihongthuy_tk3;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment2 extends Fragment implements OnBackClickListener {
    private View v;
    OnBackClickListener listener;

    public static Fragment2 getInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_2, container, false);

        ImageView imageView = v.findViewById(R.id.imageViewCakeMain2);
        TextView tvMoTa = v.findViewById(R.id.tvMoTa);
        TextView tvTenSP = v.findViewById(R.id.tvNameSPMain2);
        TextView tvGiaSP = v.findViewById(R.id.tvPriceMain2);
        Button btnAdd = v.findViewById(R.id.buttonAddtoCart);
        Bundle bundle = this.getArguments();
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                onBackClick();
                Log.d("àddg1","sfsfdgdg1");
            }
        });
        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("image"));
            tvGiaSP.setText(bundle.getDouble("giaSp") + "đ");
            tvTenSP.setText(bundle.getString("tenSp"));
            tvMoTa.setText(bundle.getString("motaSp"));


        } else {
            Log.d("bulde>>>>", "null");
        }
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackClickListener ){
            listener = (OnBackClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onViewSelected");
        }
    }
    @Override
    public void onBackClick() {

        listener.onBackClick();

    }
}