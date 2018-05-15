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
import android.widget.Toast;

import java.util.ArrayList;

public class TreeMapsActivity extends AppCompatActivity implements View.OnClickListener{
    TextView Cay1,Cay2,Cay3,Cay4,TenCay,Trangthai,LuongNuoc,Luongnuocconlai;
    int idcay =0;
    int binhnuoc = 3000;
    Button TuoiCay;
    ArrayList<DanhSachCay> arrayDsCay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_maps);
        addView();
        taomang();

    }

    private void taomang() {
        arrayDsCay = new ArrayList<>();
        arrayDsCay.add(new DanhSachCay(1,"Cây số 1","Thiếu nước",1000));
        arrayDsCay.add(new DanhSachCay(2,"Cây số 2","Thiếu nước",1500));
        arrayDsCay.add(new DanhSachCay(3,"Cây số 3","Thiếu nước",1200));
        arrayDsCay.add(new DanhSachCay(4,"Cây số 4","Thiếu nước",2000));
    }

    private void addView() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fa-solid-900.ttf");
        Cay1 = (TextView) findViewById(R.id.tv_cay1);
        Cay2 = (TextView) findViewById(R.id.tv_cay2);
        Cay3 = (TextView) findViewById(R.id.tv_cay3);
        Cay4 = (TextView) findViewById(R.id.tv_cay4);
        TenCay = (TextView)findViewById(R.id.tv_tencay);
        Trangthai = (TextView)findViewById(R.id.tvTrangthai);
        LuongNuoc = (TextView)findViewById(R.id.tvLuongnuoc);
        Luongnuocconlai = (TextView)findViewById(R.id.tv_lươngnuocconlai);
        TuoiCay = (Button)findViewById(R.id.btnTuoi);
        Cay1.setTypeface(font);
        Cay2.setTypeface(font);
        Cay3.setTypeface(font);
        Cay4.setTypeface(font);
        Cay1.setText("\uf1bb");
        Cay2.setText("\uf1bb");
        Cay3.setText("\uf1bb");
        Cay4.setText("\uf1bb");
        Cay1.setOnClickListener(this);
        Cay2.setOnClickListener(this);
        Cay3.setOnClickListener(this);
        Cay4.setOnClickListener(this);
        TuoiCay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.tv_cay1){

            TenCay.setText(arrayDsCay.get(0).getTencay());
            Trangthai.setText(arrayDsCay.get(0).getTinhtrang());
            LuongNuoc.setText("Lượng nước cần: "+arrayDsCay.get(0).getLuongnuoc());
            idcay =1;
        }else if(id == R.id.tv_cay2){
            idcay = 2;
            TenCay.setText(arrayDsCay.get(1).getTencay());
            Trangthai.setText(arrayDsCay.get(1).getTinhtrang());
            LuongNuoc.setText("Lượng nước cần: "+arrayDsCay.get(1).getLuongnuoc());
        }else if(id == R.id.tv_cay3){
            idcay = 3;
            TenCay.setText(arrayDsCay.get(2).getTencay());
            Trangthai.setText(arrayDsCay.get(2).getTinhtrang());
            LuongNuoc.setText("Lượng nước cần: "+arrayDsCay.get(2).getLuongnuoc());
        }else if (id == R.id.tv_cay4){
            idcay =4;
            TenCay.setText(arrayDsCay.get(3).getTencay());
            Trangthai.setText(arrayDsCay.get(3).getTinhtrang());
            LuongNuoc.setText("Lượng nước cần: "+arrayDsCay.get(3).getLuongnuoc());
        }else if(id == R.id.btnTuoi){
            if (binhnuoc >1500){
                xulituoicay();
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Cảnh báo");
                builder.setMessage("Bình đã hết nước, bạn có muốn lấy thêm nước không ?");
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(TreeMapsActivity.this,WaterMapsActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        }
    }

    private void xulituoicay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tưới Cây");
        builder.setMessage("Bạn có muốn tưới cây này không ?");
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(idcay == 1 ){
                    binhnuoc = binhnuoc - arrayDsCay.get(0).getLuongnuoc();
                    Luongnuocconlai.setText("Lượng nước còn lại trong bình: "+binhnuoc);
                    arrayDsCay.remove(0);
                    arrayDsCay.add(new DanhSachCay(1,"Cây số 1","Đủ nước",3000));
                    TenCay.setText(arrayDsCay.get(3).getTencay());
                    Trangthai.setText(arrayDsCay.get(3).getTinhtrang());
                    LuongNuoc.setText("Lượng nước: "+arrayDsCay.get(3).getLuongnuoc());

                }else if (idcay == 2 ){
                    binhnuoc = binhnuoc - arrayDsCay.get(0).getLuongnuoc();
                    Luongnuocconlai.setText("Lượng nước còn lại trong bình: "+binhnuoc);
                    arrayDsCay.remove(0);
                    arrayDsCay.add(new DanhSachCay(1,"Cây số 2","Đủ nước",3000));
                    TenCay.setText(arrayDsCay.get(3).getTencay());
                    Trangthai.setText(arrayDsCay.get(3).getTinhtrang());
                    LuongNuoc.setText("Lượng nước: "+arrayDsCay.get(3).getLuongnuoc());
                } else if (idcay == 3){
                    binhnuoc = binhnuoc - arrayDsCay.get(0).getLuongnuoc();
                    Luongnuocconlai.setText("Lượng nước còn lại trong bình: "+binhnuoc);
                    arrayDsCay.remove(0);
                    arrayDsCay.add(new DanhSachCay(1,"Cây số 3","Đủ nước",3000));
                    TenCay.setText(arrayDsCay.get(3).getTencay());
                    Trangthai.setText(arrayDsCay.get(3).getTinhtrang());
                    LuongNuoc.setText("Lượng nước: "+arrayDsCay.get(3).getLuongnuoc());
                }else if (idcay==4){
                    binhnuoc = binhnuoc - arrayDsCay.get(0).getLuongnuoc();
                    Luongnuocconlai.setText("Lượng nước còn lại trong bình: "+binhnuoc);
                    arrayDsCay.remove(0);
                    arrayDsCay.add(new DanhSachCay(1,"Cây số 4","Đủ nước",3000));
                    TenCay.setText(arrayDsCay.get(3).getTencay());
                    Trangthai.setText(arrayDsCay.get(3).getTinhtrang());
                    LuongNuoc.setText("Lượng nước: "+arrayDsCay.get(3).getLuongnuoc());
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
