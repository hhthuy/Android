package com.example.module21_bai2_chuyendoinhietdo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_F = (Button) findViewById(R.id.button_toF);
        Button btn_C = (Button) findViewById(R.id.button_toC);
        Button btn_Clear = (Button) findViewById(R.id.button_Clear);

        EditText et_F = (EditText) findViewById(R.id.editText_doF);
        EditText et_C = (EditText) findViewById(R.id.editText_doC);

        //Chuyển độ C sang độ F
        btn_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_C = findViewById(R.id.editText_doC);

                int c = Integer.parseInt(et_C.getText().toString());
                int F = c * 9/5 + 32;
                et_F.setText("" + F);

            }
        });
        //Chuyển độ F sang độ C
        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_F = findViewById(R.id.editText_doF);

                int f = Integer.parseInt(et_F.getText().toString());
                int C = (f - 32) * 5/9;
                et_C.setText("" + C);

            }
        });
        //Clear dữ liệu
        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_C = findViewById(R.id.editText_doC);
                EditText et_F = findViewById(R.id.editText_doF);
                et_F.setText("");
                et_C.setText("");
                et_F.requestFocus();

            }
        });

    }
}

