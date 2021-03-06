package com.codetalenta.eclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.codetalenta.eclass.fragments.ChatFragment;
import com.codetalenta.eclass.fragments.HomeFragment;
import com.codetalenta.eclass.fragments.KelasFragment;
import com.codetalenta.eclass.fragments.RapotFragment;
import com.codetalenta.eclass.fragments.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getFragmentPage(new HomeFragment());
        bottomNavigation();
        logout = findViewById (R.id.logout);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    /*
     * function menampilkan kelas frament
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