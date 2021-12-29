package com.example.asistensi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreateMakanan extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Eharga;
    private String Snama, Sharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_createmakanan);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")) {
                    Enama.requestFocus();
                    Toast.makeText(MainCreateMakanan.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreateMakanan.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreateMakanan.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMakanan(new Makanan(null, Snama, Sharga));
                    Intent a = new Intent(MainCreateMakanan.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
