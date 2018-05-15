package com.example.user.hciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Mapcay, Mapnuoc, QLCay, QLNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
    }

    private void addView() {
        Mapcay = (Button)findViewById(R.id.btn_caymaps);
        Mapnuoc = (Button)findViewById(R.id.btn_nuocmaps);
        QLCay = (Button)findViewById(R.id.btnQuanlyCay);
        QLNhanVien = (Button)findViewById(R.id.btnNV);
        QLNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QLNhanvienActivity.class);
                startActivity(intent);
            }
        });
        Mapcay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TreeMapsActivity.class);
                startActivity(intent);
            }
        });
        Mapnuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WaterMapsActivity.class);
                startActivity(intent);
            }
        });
        QLCay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QuanlyCayActivity.class);
                startActivity(intent);
            }
        });
    }
}
