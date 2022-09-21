package com.example.c3_alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Thông báo");
        final  CharSequence[] items ={"Do","Cam","Vang"};
        final boolean[] checked={false, false,false};

        mydialog.setMultiChoiceItems(items, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i, boolean b) {
                checked[1] =b;
            }
        });
        mydialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
               String st="";
               for (int j = 0; items.length > j; j++ ) {
                   if (!checked[j]) {
                       st += items[j].toString() +", ";
                   }
                   Toast.makeText(MainActivity.this, st, Toast.LENGTH_SHORT).show();
               }
            }
        });
        //Hien thi
        AlertDialog dialog =mydialog.create();
        dialog.show();

    }
}