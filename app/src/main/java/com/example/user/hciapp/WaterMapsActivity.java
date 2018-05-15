package com.example.user.hciapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class WaterMapsActivity extends AppCompatActivity implements View.OnClickListener{
    TextView Nuoc1,Nuoc2, TenNuoc,LuongBeNuoc,ThongTinBinh;
    Button LayNuoc,QuayLai;
    int idbenuoc;
    int luongnuocllay1=0;
    int luongnuocllay2 =0;
    ArrayList<DsBeNuoc> arrayBeNuoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_maps);
        addView();
        taomang();
    }

    private void taomang() {
        arrayBeNuoc = new ArrayList<>();
        arrayBeNuoc.add(new DsBeNuoc("Bể nước hồ Tiền",10000,0));
        arrayBeNuoc.add(new DsBeNuoc("Bể nước C2",10000,1));
    }

    private void addView() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fa-solid-900.ttf");
        Nuoc1 = (TextView)findViewById(R.id.tvnuoc1);
        Nuoc2 = (TextView)findViewById(R.id.tvnuoc2);
        TenNuoc = (TextView)findViewById(R.id.tv_tennuoc);
        LuongBeNuoc = (TextView)findViewById(R.id.tvLuongbenuoc);
        ThongTinBinh = (TextView)findViewById(R.id.tvthongtinbinhnuoc);
        LayNuoc = (Button)findViewById(R.id.btnLaynuoc);
        QuayLai = (Button)findViewById(R.id.btnquaylai);
        QuayLai.setEnabled(false);
        Nuoc1.setTypeface(font);
        Nuoc2.setTypeface(font);
        Nuoc1.setText("\uf06d");
        Nuoc2.setText("\uf06d");
        Nuoc1.setOnClickListener(this);
        Nuoc2.setOnClickListener(this);
        LayNuoc.setOnClickListener(this);
        QuayLai.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tvnuoc1){
            TenNuoc.setText(arrayBeNuoc.get(0).getTenBeNuoc());
            LuongBeNuoc.setText("Lượng nước trong bể: "+String.valueOf(arrayBeNuoc.get(0).getLuongNuocTrongBe()-luongnuocllay1));
            idbenuoc = arrayBeNuoc.get(0).getID();
        }else if(id == R.id.tvnuoc2){
            TenNuoc.setText(arrayBeNuoc.get(1).getTenBeNuoc());
            LuongBeNuoc.setText("Lượng nước trong bể: "+String.valueOf(arrayBeNuoc.get(1).getLuongNuocTrongBe()-luongnuocllay2));
            idbenuoc = arrayBeNuoc.get(1).getID();
        }else if (id == R.id.btnLaynuoc){
            xulilaynuoc();
        }else if (id ==R.id.btnquaylai){
            backTreeMap();
        }
    }

    private void xulilaynuoc() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lấy nước");
        builder.setMessage("Bạn có muốn lấy nước không ?");
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(idbenuoc == 0){
                    TenNuoc.setText(arrayBeNuoc.get(0).getTenBeNuoc());
                    int kq = arrayBeNuoc.get(0).getLuongNuocTrongBe()-3000;
                    LuongBeNuoc.setText("Lượng nước trong bể: "+String.valueOf(kq));
                    luongnuocllay1 = 3000;
                    ThongTinBinh.setText("Lượng nước trong bình: "+String.valueOf(luongnuocllay1));
                    QuayLai.setEnabled(true);
                }else {
                    TenNuoc.setText(arrayBeNuoc.get(1).getTenBeNuoc());
                    int kq = arrayBeNuoc.get(1).getLuongNuocTrongBe()-3000;
                    LuongBeNuoc.setText("Lượng nước trong bể: "+String.valueOf(kq));
                    luongnuocllay2 = 3000;
                    ThongTinBinh.setText("Lượng nước trong bình: "+String.valueOf(luongnuocllay2));
                    QuayLai.setEnabled(true);
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void backTreeMap() {
        Intent intent = new Intent(WaterMapsActivity.this,TreeMapsActivity.class);
        startActivity(intent);
    }
}
