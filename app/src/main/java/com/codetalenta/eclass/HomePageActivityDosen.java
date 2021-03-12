package com.codetalenta.eclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.codetalenta.eclass.fragments.ChatFragment;
import com.codetalenta.eclass.fragments.HomeFragment;
import com.codetalenta.eclass.fragments.RapotFragment;
import com.codetalenta.eclass.fragments.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivityDosen extends AppCompatActivity {
    BottomNavigationView navigationView;

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_dosen);
        getFragmentPage(new fragment_home_page_dosen());
        bottomNavigation();
        logout = findViewById (R.id.logout);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivityDosen.this, MainActivity.class);
            startActivity(intent);
        });

    }

    /*
     * function menampilkan kelas fragment
     * */
    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.page_container, fragment).commit();
            return true;
        }
        return false;
    }

    /*
    * function bottom navigation
    * */
    private void bottomNavigation(){
        navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
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