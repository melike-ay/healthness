package com.example.project1;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutsActivity extends AppCompatActivity {

TextView tvEasy,tvMedium,tvHard;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_workoutlevels);

        tvEasy=findViewById(R.id.tvEasy);
        tvMedium=findViewById(R.id.tvMedium);
        tvHard=findViewById(R.id.tvHard);


        String content = getIntent().getStringExtra("content");

        if(content.equals("Leg Workouts")){
         tvEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvEasy.setText(R.string.legeasyD);

            }
         });

            tvMedium.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    tvMedium.setText(R.string.legmediumD);

                }
            });

            tvHard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    tvHard.setText(R.string.leghardD);
                }
            });

        }



        if(content.equals("Chest Workouts")){
            tvEasy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tvEasy.setText(R.string.chesteasyD);

                }
            });

            tvMedium.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    tvMedium.setText(R.string.chestmediumD);

                }
            });

            tvHard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    tvHard.setText(R.string.chesthardD);
                }
            });
        }




        if(content.equals("Glutes Workouts")){
            tvEasy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tvEasy.setText(R.string.gluteseasyD);

                }
            });

            tvMedium.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    tvMedium.setText(R.string.glutesmediumD);

                }
            });

            tvHard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    tvHard.setText(R.string.gluteshardD);
                }
            });

        }





        if(content.equals("Full Body Workouts")){
            tvEasy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tvEasy.setText(R.string.fulleasyD);


                }
            });


            tvMedium.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvMedium.setText(R.string.fullmediumD);
                }
            });

            tvHard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvHard.setText(R.string.fullhardD);
                }
            });



        }



}}
