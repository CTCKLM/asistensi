package com.example.asistensi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdelMakanan extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sharga;
    private EditText Enama, Eharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updelmakanan);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sharga = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama.setText(Snama);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(MainUpdelMakanan.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdelMakanan.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMakanan(new Makanan(Sid, Snama, Sharga));
                    Toast.makeText(MainUpdelMakanan.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMakanan(new Makanan(Sid, Snama, Sharga));
                Toast.makeText(MainUpdelMakanan.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}


