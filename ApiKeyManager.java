package com.example.project1;

import android.util.Log;

public class ApiKeyManager {

    private static ApiKeyManager instance;
    private static String apiKey = "kPXSG+u3LAVNImaE/0LiFg==yvdat5Fg2Xr9adRj";  // Initialize with your actual API key

    private ApiKeyManager() {
        // private constructor to enforce singleton pattern
    }

    public static synchronized ApiKeyManager getInstance() {
        if (instance == null) {
            Log.d("MainActivity","entered");
            instance = new ApiKeyManager();
        }
        return instance;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
        Log.d("ApiKeyManager",this.apiKey);

    }

    public String getApiKey() {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("API key is not set. Please set the API key using setApiKey method.");
        }
        return apiKey;
    }

    //public void clearApiKey() {
     //   apiKey = null;
    //
}
