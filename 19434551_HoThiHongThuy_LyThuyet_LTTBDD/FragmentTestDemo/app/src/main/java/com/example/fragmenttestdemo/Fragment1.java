package com.example.fragmenttestdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ArrayList<Product> productArrayList;
    Frament1Adapter frament1Adapter;
    TruyenProduct truyenProduct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        truyenProduct = (TruyenProduct) getActivity();
        productArrayList = new ArrayList<>();
        AddArrayProduct();
        frament1Adapter = new Frament1Adapter(getActivity(),R.layout.row_product,productArrayList);
        GridView gridView = view.findViewById(R.id.gridviewlist);
        gridView.setAdapter(frament1Adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fragment2 fragment2 = new Fragment2();
//                Configuration configuration = getResources().getConfiguration();
//                if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,fragment2,"findThisFragment").addToBackStack(null).commit();
//                    truyenProduct.DataProduct(productArrayList.get(position));
//                }else{
//                    truyenProduct.DataProduct(productArrayList.get(position));
//                }

                truyenProduct.DataProduct(productArrayList.get(position));
            }
        });
        return view;
    }

    private void AddArrayProduct(){
        productArrayList.add(new Product("TH true milk",24000,R.drawable.hinh1));
        productArrayList.add(new Product("Sting",10000,R.drawable.hinh2));
        productArrayList.add(new Product("Pepsi",10000,R.drawable.hinh3));
        productArrayList.add(new Product("Coca",10000,R.drawable.hinh4));
        productArrayList.add(new Product("Nước suối",5000,R.drawable.hinh5));
        productArrayList.add(new Product("Bia tiger lon",23000,R.drawable.hinh6));
        productArrayList.add(new Product("Cafe lon",17000,R.drawable.hinh7));
    }
}