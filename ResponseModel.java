package com.example.project1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("items")
    private List<NutritionItem> items;

    public List<NutritionItem> getItems() {
        return items;
    }
}



    class NutritionItem {
        private String name;
        private double calories;

        // Constructor, getters, setters, etc.

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCalories() {
            return calories;
        }

        public void setCalories(double calories) {
            this.calories = calories;
        }
    }



