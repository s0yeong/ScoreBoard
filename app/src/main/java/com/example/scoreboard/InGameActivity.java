package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        TextView textView = (TextView) findViewById(R.id.game_selected);

        Intent intentBefore = getIntent();
        Bundle bundle = intentBefore.getExtras();
        String name = bundle.getString("gameName");
        textView.setText(name);

        Button buttonAddUser = (Button) findViewById(R.id.btn_addUser);
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addUserIntent = new Intent(getApplicationContext(), AddUserActivity.class);
                startActivity(addUserIntent);
            }
        });


        Button buttonHome = (Button) findViewById(R.id.btn_home);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(homeIntent);
            }
        });


    }



}