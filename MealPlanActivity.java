package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MealPlanActivity extends AppCompatActivity {

    private TextView tvMealTitle;
    private TextView tvMealDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealplans);

        tvMealTitle = findViewById(R.id.tvMealTitle);
        tvMealDescription = findViewById(R.id.tvMealDescription);

        String content = getIntent().getStringExtra("content");


        if(content.equals("Gluten-Free")){


            tvMealTitle.setText(content);
            tvMealDescription.setText(R.string.glutenD);

    } else if (content.equals("High Protein")) {

            tvMealTitle.setText(content);
            tvMealDescription.setText(R.string.highproteinD);


        } else if (content.equals("Lactose-Free")) {

            tvMealTitle.setText(content);
            tvMealDescription.setText(R.string.lactoseD);

        }

        else{
            tvMealTitle.setText(content);
            tvMealDescription.setText(R.string.ketoD);
        }
    }}

