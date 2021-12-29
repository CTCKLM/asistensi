package com.example.asistensi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Makanan> Makanan;
    public CustomListAdapter(Activity activity, List<Makanan> Makanan) {
        this.activity = activity;
        this.Makanan = Makanan;
    }
    @Override
    public int getCount() {
        return Makanan.size();
    }
    @Override
    public Object getItem(int location) {
        return Makanan.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        Makanan m = Makanan.get(position);
        nama.setText("Nama : "+ m.get_nama());
        harga.setText("Harga : "+ m.get_harga());
        return convertView;
    }
}
