package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button userAddButton = (Button) findViewById(R.id.btn_addUser);
        Button goBackButton = (Button) findViewById(R.id.btn_back);
        Button homeButton = (Button) findViewById(R.id.btn_home);

        userAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userAddIntent = new Intent(getApplicationContext(), AddUserActivity.class);
                startActivity(userAddIntent);
            }
        });

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), InGameActivity.class);
                startActivity(backIntent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), MainGameActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}