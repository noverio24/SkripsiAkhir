package com.codetalenta.eclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.codetalenta.eclass.activity.dosen.LoginDosenActivity;
import com.codetalenta.eclass.activity.mahasiswa.LoginMahasiswaActivity;

public class MainActivity extends AppCompatActivity {
    Button btnMhs, btnDsn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMhs = findViewById(R.id.btnMahasiswa);
        btnMhs.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginMahasiswaActivity.class);
            startActivity(intent);
        });

        btnDsn = findViewById(R.id.btnDosen);
        btnDsn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginDosenActivity.class);
            startActivity(intent);
        });
    }
}