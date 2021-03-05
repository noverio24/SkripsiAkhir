package com.codetalenta.eclass.activity.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.codetalenta.eclass.R;

public class RegisterMahasiswaActivity extends AppCompatActivity {
    private EditText etUsername, etEmail, etPassword;
    private Button btnNext;
    public String username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mahasiswa);
        etUsername = findViewById(R.id.editUsername);
        etEmail = findViewById(R.id.editEmail);
        etPassword = findViewById(R.id.editPassword);
        btnNext = findViewById(R.id.btnNext);
        dataTranfer();
    }

    private void dataTranfer() {
        btnNext.setOnClickListener(v -> {
            username = etUsername.getText().toString().trim();
            email = etEmail.getText().toString().trim();
            password = etPassword.getText().toString().trim();
            Intent intent = new Intent(RegisterMahasiswaActivity.this, RegisterMahasiswaActivity2.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            intent.putExtra("password", password);
            startActivity(intent);
        });

    }
}