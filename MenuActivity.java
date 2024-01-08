package com.example.project1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;


public class MenuActivity extends AppCompatActivity {

    TextView tvLine1;
    TextView tvLine2;
    TextView tvLine3;
    TextView tvLine4;


    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvLine1 = findViewById(R.id.tvLine1);
        tvLine2 = findViewById(R.id.tvLine2);
        tvLine3 = findViewById(R.id.tvLine3);
        tvLine4 = findViewById(R.id.tvLine4);

        category = getIntent().getStringExtra("category");
        setTitle(category);

        String[] content;


        if (category.equals("Workout Recommendations")) {
            content = new String[]{"Leg Workouts", "Chest Workouts", "Glutes Workouts", "Full Body Workouts"};

            tvLine1.setText(content[0]);
            tvLine2.setText(content[1]);
            tvLine3.setText(content[2]);
            tvLine4.setText(content[3]);


            tvLine1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("Leg Workouts");

                }
            });

            tvLine2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("Chest Workouts");
                }
            });

            tvLine3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("Glutes Workouts");
                }
            });

            tvLine4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    handleMovieClick("Full Body Workouts");
                }
            });


        } else if (category.equals("Meal Plans")) {
            content = new String[]{"Gluten-Free", "High Protein", "Lactose-Free", "Ketogenic"};

            tvLine1.setText(content[0]);
            tvLine2.setText(content[1]);
            tvLine3.setText(content[2]);
            tvLine4.setText(content[3]);


            tvLine1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("Gluten-Free");
                }
            });

            tvLine2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("High Protein");
                }
            });

            tvLine3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("Lactose-Free");
                }
            });

            tvLine4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    handleMovieClick("Ketogenic");
                }
            });


        }

    }


    private void handleMovieClick(String content) {


        if (category.equals("Workout Recommendations")) {
            Intent intent = new Intent(MenuActivity.this, WorkoutsActivity.class);
            intent.putExtra("content",content);  // Pass the type
            startActivity(intent);
        } else if (category.equals("Meal Plans")) {
            Intent intent = new Intent(MenuActivity.this, MealPlanActivity.class);
            intent.putExtra("content",content);  // Pass the type
            startActivity(intent);
        }

    }




}