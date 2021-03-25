package com.codetalenta.eclass.activity.dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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


public class LoginDosenActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button btnLogin, btnRegister;
    private AuthService authService = UrlApi.getAuthService();
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dosen);
        session = new Session(this);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            login();
        });

        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(LoginDosenActivity.this, RegisterDosenActivity.class));
        });
        loginSession();
    }

    private void loginSession() {
        if (session.getBoolean("succes")) {
            startActivity(new Intent(LoginDosenActivity.this, HomePageActivityDosen.class));
            finish();
        }
    }


    private void login() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        authService.login(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String data = response.body().string();
                        JSONObject result = new JSONObject(data);
                        System.out.println(result.getBoolean("success"));
                        if (result.getBoolean("success")) {
                            String token = result.getString("access_token");
                            session.add("token", "Bearer " + token);
                            session.add("login", true);
                            session.add("success", true);
                            checkData();
                        }
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(LoginDosenActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(LoginDosenActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }


    void checkData() {
        authService.checkData(session.getString("token")).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String data = response.body().string();
                        JSONObject result = new JSONObject(data);
                        System.out.println(result.getBoolean("success"));
                        if (result.getBoolean("success")) {
                            JSONObject dataDosen = result.getJSONObject("data").getJSONObject("data");
                            JSONObject dataUser = result.getJSONObject("data").getJSONObject("user");
                            session.add("name", dataDosen.getString("name"));
                            session.add("photo", dataDosen.getString("url_photo"));
                            session.add("dosen_id", dataDosen.getString("id"));
                            session.add("user_id", dataDosen.getString("id"));

                            startActivity(new Intent(LoginDosenActivity.this, HomePageActivityDosen.class));
                            finish();
                        }
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(LoginDosenActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(LoginDosenActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}