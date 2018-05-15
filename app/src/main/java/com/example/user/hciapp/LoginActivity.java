package com.example.user.hciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Ten,MatKhau;
    Button DangNhap;
    String id = "admin";
    String password = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addView();
        DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulidangnhap();
            }
        });
    }

    private void xulidangnhap() {
        if(Ten.getText().toString().equals(id) && MatKhau.getText().toString().equals(password)){
            Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else if(Ten.getText().toString().equals(id)){
            Toast.makeText(LoginActivity.this,"Sai mật khẩu",Toast.LENGTH_SHORT).show();
            MatKhau.setText("");
        }else if(MatKhau.getText().toString().equals(password)){
            Toast.makeText(this,"Tên đăng nhập sai",Toast.LENGTH_SHORT).show();
            Ten.setText("");
        }
    }

    private void addView() {
        Ten = (EditText)findViewById(R.id.ed_ten);
        MatKhau = (EditText)findViewById(R.id.ed_mk);
        DangNhap = (Button)findViewById(R.id.btnLogin);
    }
}
