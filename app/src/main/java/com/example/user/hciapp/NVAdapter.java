package com.example.user.hciapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NVAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<Nhanvien> arrayNhanvien;
    public NVAdapter(Context context, int layout , List<Nhanvien> NhanvienList){
        myContext = context;
        myLayout = layout;
        arrayNhanvien = NhanvienList;
    }
    @Override
    public int getCount() {
        return arrayNhanvien.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(myLayout,null);
        TextView Hoten = (TextView)view.findViewById(R.id.tvHoTen);
        TextView sdt = (TextView)view.findViewById(R.id.tvsdt);
        Hoten.setText(arrayNhanvien.get(i).getHoTen());
        sdt.setText(String.valueOf(arrayNhanvien.get(i).getSDT()));
        return view;
    }
}
