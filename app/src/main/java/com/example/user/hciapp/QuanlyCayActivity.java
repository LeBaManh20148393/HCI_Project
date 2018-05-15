package com.example.user.hciapp;

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
    ArrayList<DanhSachCay> mangCay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly_cay);
        addView();
        final CayAdapter adapter = new CayAdapter(
                QuanlyCayActivity.this,R.layout.cay,mangCay
        );
        Lvcay.setAdapter(adapter);
        Lvcay.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                mangCay.remove(i);
                adapter.notifyDataSetChanged();
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

    private void clean() {
        IDcay.setText("");
        TenCayql.setText("");


    }

    private void addView() {
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
