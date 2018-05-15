package com.example.user.hciapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QLNhanvienActivity extends AppCompatActivity {
    ListView LvNhanVien;
    ArrayList<Nhanvien> mangNV;
    NVAdapter adapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlnhanvien);
        addView();
        adapter = new NVAdapter(QLNhanvienActivity.this,R.layout.dongnhanvien,mangNV);
        LvNhanVien.setAdapter(adapter);
        LvNhanVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                xuligoidien();
                return false;
            }
        });
    }

    private void xuligoidien() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Gọi nhân viên");
        builder.setMessage("Bạn có muốn gọi "+mangNV.get(position).getHoTen());
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phoneNo = String.valueOf(mangNV.get(position).getSDT());
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(QLNhanvienActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void addView() {
        LvNhanVien = (ListView)findViewById(R.id.lvNhanvien);
        mangNV = new ArrayList<>();
        mangNV.add(new Nhanvien("Le van A",1234));
        mangNV.add(new Nhanvien("Le van B",4567));
        mangNV.add(new Nhanvien("Le van C",6688));
        mangNV.add(new Nhanvien("Le van D",6789));
        mangNV.add(new Nhanvien("Le van E",1102));
        mangNV.add(new Nhanvien("Le van F",9999));
    }
}
