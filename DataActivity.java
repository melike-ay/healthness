package com.example.project1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    private DBManager dbHelper;
    private EditText editTextUsername, editTextPassword;
    private Button saveButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_db);

        dbHelper = new DBManager(this);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        saveButton = findViewById(R.id.saveButton);
        loginButton=findViewById(R.id.loginButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClick();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClick();
            }
        });
    }

    public void saveClick() {
        Log.d("DataActivity", "save e girdi");
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (isUsernameExists(username)) {
            Toast.makeText(getApplicationContext(), "Username already exists", Toast.LENGTH_LONG).show();
        } else {
            ContentValues values = new ContentValues();
            values.put(DBManager.ColUsername, username);
            values.put(DBManager.ColPassword, password);

            long id = dbHelper.Insert(values);

            if (id > 0)
                Toast.makeText(getApplicationContext(), "Data is added and user id:" + id, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Cannot insert", Toast.LENGTH_LONG).show();
        }
    }

    public void loginClick() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

       
        if (isUserAuthenticated(username, password)) {
            startActivity(new Intent(DataActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Invalid username or password. Try again or sign up", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isUsernameExists(String username) {
       
        Cursor cursor = dbHelper.query(
                new String[]{DBManager.ColUsername},
                DBManager.ColUsername + "=?",
                new String[]{username},
                null
        );

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    private boolean isUserAuthenticated(String username, String password) {
      
        Cursor cursor = dbHelper.query(
                new String[]{DBManager.ColUsername, DBManager.ColPassword},
                DBManager.ColUsername + "=? AND " + DBManager.ColPassword + "=?",
                new String[]{username, password},
                null
        );

        boolean authenticated = cursor.getCount() > 0;
        cursor.close();
        return authenticated;
    }
}
