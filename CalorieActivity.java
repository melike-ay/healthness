package com.example.project1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class CalorieActivity extends AppCompatActivity {

    TextView resultCal;
    Button resultButton;
    EditText etMeal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriepage);

        resultCal = findViewById(R.id.resultCal);
        resultButton = findViewById(R.id.resultButton);
        etMeal = findViewById(R.id.etMeal);

        resultButton.setOnClickListener(v -> {
            Log.d("CalorieActivity", "Before making API call");
            String meal = etMeal.getText().toString();

            makeApiRequest(meal);

        });
    }

    private void makeApiRequest(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Log.d("CalorieActivity", "Encoded Query: " + encodedQuery);  // Log encoded query

            Call<ResponseModel> call = apiInterface.getNutritionData(encodedQuery);
            call.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(@NonNull Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {
                    Log.d("CalorieActivity", "Inside onResponse");
                    Log.d("CalorieActivity", query);

                    if (response.isSuccessful()) {
                        ResponseModel nutritionResponse = response.body();
                        if (nutritionResponse != null && nutritionResponse.getItems() != null) {
                            Log.d("CalorieActivity", "API Response Successful");
                            displayApiResults(nutritionResponse.getItems());
                        } else {
                            Log.d("CalorieActivity", "No data in API response");
                        }
                    } else {
                        Log.d("CalorieActivity", "API Response unsuccessful");
                        Log.d("CalorieActivity", "Error code: " + response.code());
                        Log.d("CalorieActivity", "Error message: " + response.message());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
                  
                    Log.e("CalorieActivity", "API Call Failure", t);
                    if (t instanceof HttpException) {
                        Response<?> response = ((HttpException) t).response();
                        try {
                            Log.e("CalorieActivity", "Error body: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayApiResults(List<NutritionItem> items) {
        StringBuilder resultText = new StringBuilder();

     
        for (NutritionItem item : items) {
            resultText.append("Name: ").append(item.getName()).append("\n");
            resultText.append("Calories: ").append(item.getCalories()).append("\n\n");
        }

        resultCal.setText(resultText.toString());
    }
}
