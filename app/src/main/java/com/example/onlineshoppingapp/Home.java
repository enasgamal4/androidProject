package com.example.onlineshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CategoriesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_category);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_category:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CategoriesFragment()).commit();
                break;
            case R.id.nav_Orders:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OrdersFragment()).commit();
                break;
            case R.id.nav_Cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CardFragment()).commit();
                break;
            case R.id.nav_products:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProductsFragment()).commit();
                break;

            case R.id.nav_Seach:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SerachFragment()).commit();
                break;
            case R.id.nav_find_location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LocationsFragment()).commit();
                break;
            case R.id.nav_logOut:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
