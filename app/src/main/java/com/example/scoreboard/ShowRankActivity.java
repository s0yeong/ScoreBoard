package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowRankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rank);

        Button buttonBack = (Button) findViewById(R.id.btn_back);
        Button buttonHome = (Button) findViewById(R.id.btn_home);
        Button btnToTotal = (Button) findViewById(R.id.rank_total);
        Button btnToGame = (Button) findViewById(R.id.rank_game);
        Button btnToUser = (Button) findViewById(R.id.rank_user);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), InGameActivity.class);
                startActivity(backIntent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(homeIntent);
            }
        });

        btnToTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent totalIntent = new Intent(getApplicationContext(), TotalRankActivity.class);
                startActivity(totalIntent);
            }
        });

        btnToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameIntent = new Intent(getApplicationContext(), GameRankActivity.class);
                startActivity(gameIntent);
            }
        });


        btnToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(getApplicationContext(), UserRankActivity.class);
                startActivity(userIntent);
            }
        });


    }
}