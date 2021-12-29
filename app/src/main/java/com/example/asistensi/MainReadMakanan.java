package com.example.asistensi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainReadMakanan  extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Makanan> ListMakanan = new ArrayList<Makanan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_readmakanan);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMakanan);
        mListView = (ListView) findViewById(R.id.list_makanan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMakanan.clear();
        List<Makanan> makanan = db.ReadMakanan();
        for (Makanan mkn : makanan) {
            Makanan daftar = new Makanan();
            daftar.set_id(mkn.get_id());
            daftar.set_nama(mkn.get_nama());
            daftar.set_harga(mkn.get_harga());
            ListMakanan.add(daftar);
            if ((ListMakanan.isEmpty()))
                Toast.makeText(MainReadMakanan.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Makanan detailMkn = (Makanan)o;
        String Sid = detailMkn.get_id();
        String Snama = detailMkn.get_nama();
        String Sharga = detailMkn.get_harga();
        Intent goUpdel = new Intent(MainReadMakanan.this, MainUpdelMakanan.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMakanan.clear();
        mListView.setAdapter(adapter_off);
        List<Makanan> makanan = db.ReadMakanan();
        for (Makanan mkn : makanan) {
            Makanan daftar = new Makanan();
            daftar.set_id(mkn.get_id());
            daftar.set_nama(mkn.get_nama());
            daftar.set_harga(mkn.get_harga());
            ListMakanan.add(daftar);
            if ((ListMakanan.isEmpty()))
                Toast.makeText(MainReadMakanan.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
