package com.example.project1;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        ApiKeyManager.getInstance().setApiKey("kPXSG+u3LAVNImaE/0LiFg==yvdat5Fg2Xr9adRj");


        String apiKey = ApiKeyManager.getInstance().getApiKey();

        Log.d("MainActivity", "Current API key: " + apiKey);


     //  ApiKeyManager.getInstance().clearApiKey();
        //Log.d("MainActivity", "API key cleared.");



    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handled navigation view item clicks here.
        int itemId = item.getItemId();

        if (itemId == R.id.menu_calorie) {

            showMessage("Calorie Checker is loading");


            startActivity(new Intent(MainActivity.this, CalorieActivity.class));

        } else if (itemId == R.id.menu_workout) {

            showMessage("Workouts are loading");

            // Start MenuCategoryActivity and pass the category name
            startActivity(new Intent(MainActivity.this, MenuActivity.class)
                    .putExtra("category", "Workout Recommendations"));
        } else if (itemId == R.id.menu_meal) {
            // Handle the Meal plans category click
            showMessage("Meal plans are loading");


            startActivity(new Intent(MainActivity.this, MenuActivity.class)
                    .putExtra("category", "Meal Plans"));
        }

        drawer.closeDrawers(); // Close the drawer after selecting an item
        return true;
    }



    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}