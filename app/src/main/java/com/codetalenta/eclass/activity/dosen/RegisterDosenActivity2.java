package com.codetalenta.eclass.activity.dosen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;

import com.codetalenta.eclass.HomePageActivityDosen;
import com.codetalenta.eclass.R;
import com.codetalenta.eclass.helper.UrlApi;
import com.codetalenta.eclass.service.AuthService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterDosenActivity2 extends AppCompatActivity {
    private String username, email, password, name, university, acID, address, phone;
    private EditText etNameMhs, etUniversity, etAcID, etAddress, etPhone;
    private CircleImageView imageUser;
    private final int imageRequestCode = 999;
    private Uri file;
    private Bitmap bitmap;
    private Button btnRegister;
    private AuthService authService = UrlApi.getAuthService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mahasiswa2);
        etNameMhs = findViewById(R.id.etNameMhs);
        etUniversity = findViewById(R.id.etUniversity);
        etAcID = findViewById(R.id.etACID);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        imageUser = findViewById(R.id.imageUser);
        btnRegister = findViewById(R.id.btnRegister);
        imageUser.setOnClickListener(v -> {
            ActivityCompat.requestPermissions(RegisterDosenActivity2.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, imageRequestCode);
        });

        btnRegister.setOnClickListener(v -> {
            registerMahasiswa();
        });
    }

    private void registerMahasiswa() {
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        name = etNameMhs.getText().toString().trim();
        university = etUniversity.getText().toString().trim();
        acID = etAcID.getText().toString().trim();
        address = etAddress.getText().toString().trim();
        phone = etPhone.getText().toString().trim();

        File file = createTempFile(bitmap);

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("name", createPartFromString(name));
        map.put("email", createPartFromString(email));
        map.put("username", createPartFromString(username));
        map.put("password", createPartFromString(password));
        map.put("nid", createPartFromString(acID));
        map.put("address", createPartFromString(address));
        map.put("phone", createPartFromString(phone));
        map.put("bio", createPartFromString("abcd"));

        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("photo", file.getName(), reqFile);
        authService.registerDosen(body, map).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        String respon = response.body().string();
                        startActivity(new Intent(RegisterDosenActivity2.this, HomePageActivityDosen.class));
                        System.out.println(respon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == imageRequestCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(new Intent(Intent.ACTION_PICK));
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "select image"), imageRequestCode);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == imageRequestCode && resultCode == RESULT_OK && data != null) {
            file = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(file);
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageUser.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }

    private File createTempFile(Bitmap bitmap) {
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                , System.currentTimeMillis() + "_image.png");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
        byte[] bitmapdata = bos.toByteArray();
        //write the bytes in file

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}