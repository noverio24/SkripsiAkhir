package com.codetalenta.eclass.activity.dosen;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.codetalenta.eclass.MainActivity;
import com.codetalenta.eclass.R;
import com.codetalenta.eclass.fragments.fragment_home_page_dosen;
import com.codetalenta.eclass.fragments.ChatFragment;
import com.codetalenta.eclass.fragments.HomeFragment;
import com.codetalenta.eclass.fragments.RapotFragment;
import com.codetalenta.eclass.fragments.TaskFragment;
import com.codetalenta.eclass.helper.Session;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class HomePageActivityDosen extends AppCompatActivity {
    BottomNavigationView navigationView;

    private Button logout;
    private ImageView photo_CIV;
    private TextView name_user_TV;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_dosen);
        getFragmentPage(new fragment_home_page_dosen());
        bottomNavigation();

        //HELPER INIT
        session = new Session(getApplicationContext());

        //IMAGEVIEW INIT
        photo_CIV = findViewById(R.id.photo_CIV);

        //TEXTVIEW INIT
        name_user_TV = findViewById(R.id.name_user_TV);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivityDosen.this, MainActivity.class);
            startActivity(intent);
        });

        name_user_TV.setText(session.getString("name"));

        if (session.getString("photo").isEmpty()) {
//            iview.setImageResource(R.drawable.placeholder);
        } else{
            Picasso.get().load(session.getString("photo")).into(photo_CIV);
        }

    }

    /*
     * function menampilkan kelas fragment
     * */
    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.page_container, fragment).commit();
            return true;
        }
        return false;
    }

    /*
     * function bottom navigation
     * */
    private void bottomNavigation() {
        navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.task:
                        fragment = new TaskFragment();
                        break;
                    case R.id.chat:
                        fragment = new ChatFragment();
                        break;
                    case R.id.rapot:
                        fragment = new RapotFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }


}