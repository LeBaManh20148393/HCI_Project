package com.example.user.hciapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuanlyCayActivity extends AppCompatActivity {
    ListView Lvcay;
    EditText IDcay,TenCayql;
    TextView Tinhtrangql,Luongnuocql;
    Button Them;
    int position;
    ArrayList<DanhSachCay> mangCay;
    CayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_cay);
        addView();
         adapter = new CayAdapter(
                QuanlyCayActivity.this,R.layout.cay,mangCay
        );
        Lvcay.setAdapter(adapter);


        Lvcay.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
               xulixoacay();
                return false;

            }
        });
        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int arg1 = Integer.parseInt(IDcay.getText().toString());
                String arg2 = TenCayql.getText().toString();
                String arg3  = Tinhtrangql.getText().toString();
                int arg4 = Integer.parseInt(Luongnuocql.getText().toString());
                mangCay.add(new DanhSachCay(arg1,arg2,arg3,arg4));
                adapter.notifyDataSetChanged();
                Toast.makeText(QuanlyCayActivity.this,"Thêm Thành Công !",Toast.LENGTH_SHORT).show();
                clean();
            }

        });

    }

    private void xulixoacay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa cây");
        builder.setMessage("Bạn có chắc chắn xóa cây ?");
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mangCay.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void clean() {
        IDcay.setText("");
        TenCayql.setText("");


    }

    private void
    addView() {
        Lvcay = (ListView)findViewById(R.id.lvDanhsachCay);
        IDcay = (EditText)findViewById(R.id.edID);
        TenCayql = (EditText)findViewById(R.id.edtenCay);
        Them = (Button)findViewById(R.id.btnthemcay);
        Tinhtrangql = (TextView)findViewById(R.id.tvTinhtrangql);
        Luongnuocql = (TextView)findViewById(R.id.tvluongnuocql);
        mangCay = new ArrayList<>();
        mangCay.add(new DanhSachCay(1,"Cây số 1","Thiếu nước",1000));
        mangCay.add(new DanhSachCay(2,"Cây số 2","Đủ nước",0));
        mangCay.add(new DanhSachCay(3,"Cây số 3","Thiếu nước",1200));
        mangCay.add(new DanhSachCay(4,"Cây số 4","Đủ nước",0));
        mangCay.add(new DanhSachCay(5,"Cây số 5","Thiếu nước",700));
        mangCay.add(new DanhSachCay(6,"Cây số 6","Đủ nước",0));
        mangCay.add(new DanhSachCay(7,"Cây số 7","Thiếu nước",900));
        mangCay.add(new DanhSachCay(8,"Cây số 8","Thiếu nước",1500));
        mangCay.add(new DanhSachCay(9,"Cây số 9","Đủ nước",0));



    }
}
