package com.example.user.hciapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CayAdapter extends BaseAdapter {
    Context mycontext;
    int myLayout;
    List<DanhSachCay> arrayDanhsachCay;

    public CayAdapter(Context context, int layout, List<DanhSachCay> Danhsachcaylist) {
        mycontext = context;
        myLayout = layout;
        arrayDanhsachCay = Danhsachcaylist;
    }

    @Override
    public int getCount() {
        return arrayDanhsachCay.size();
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
        LayoutInflater inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(myLayout,null);
        TextView tvcTenCay  = (TextView)view.findViewById(R.id.tvcTencay);
        TextView tvcTrangthai = (TextView)view.findViewById(R.id.tvcTrangthai);
        TextView tvcLuongnuoc = (TextView)view.findViewById(R.id.tvcLuongnuoc);
        tvcTenCay.setText(arrayDanhsachCay.get(i).getTencay());
        tvcTrangthai.setText(arrayDanhsachCay.get(i).getTinhtrang());
        tvcLuongnuoc.setText(String.valueOf(arrayDanhsachCay.get(i).getLuongnuoc()));
        return view;
    }
}
