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

        Button buttonHome = (Button) findViewById(R.id.btn_home);

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(homeIntent);
            }
        });

        Button btnToTotal = (Button) findViewById(R.id.rank_total);
        btnToTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent totalIntent = new Intent(getApplicationContext(), TotalRankActivity.class);
                startActivity(totalIntent);
            }
        });

        Button btnToGame = (Button) findViewById(R.id.rank_game);
        btnToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameIntent = new Intent(getApplicationContext(), GameRankActivity.class);
                startActivity(gameIntent);
            }
        });

        Button btnToUser = (Button) findViewById(R.id.rank_user);
        btnToUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(getApplicationContext(), UserRankActivity.class);
                startActivity(userIntent);
            }
        });


    }
}