package com.codetalenta.eclass.activity.mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.codetalenta.eclass.HomePageActivity;
import com.codetalenta.eclass.R;
import com.codetalenta.eclass.helper.Session;
import com.codetalenta.eclass.helper.UrlApi;
import com.codetalenta.eclass.service.AuthService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginMahasiswaActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button btnLogin, btnRegister;
    private AuthService authService = UrlApi.getAuthService();
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mahasiswa);
        session = new Session(this);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            login();
        });

        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginMahasiswaActivity.this, RegisterMahasiswaActivity.class));
        });
        loginSession();
    }

    private void loginSession(){
        if (session.getBoolean("succes")){
            startActivity(new Intent(LoginMahasiswaActivity.this, HomePageActivity.class));
            finish();
        }
    }


    private void login() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        authService.login(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        String data = response.body().string();
                        JSONObject result = new JSONObject(data);
                        System.out.println(result.getBoolean("success"));
                        if (result.getBoolean("success")){
                            String token = result.getString("access_token");
                            session.add("token", "Bearer " + token);
                            session.add("login", true);
                            session.add("success", true);
                            startActivity(new Intent(LoginMahasiswaActivity.this, HomePageActivity.class));
                            finish();
                        }
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(LoginMahasiswaActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}