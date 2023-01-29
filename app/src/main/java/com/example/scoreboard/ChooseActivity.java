package com.example.scoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);

        Button btnToGame = (Button) findViewById(R.id.btn_game_page);
        btnToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainGameActivity.class);
                startActivity(intent);
            }
        });

        Button btnToUserList = (Button) findViewById(R.id.btn_user_list_page);
        btnToUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
                startActivity(intent);
            }
        });

        Button btnToRank = (Button) findViewById(R.id.btn_rank_page);
        btnToRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowRankActivity.class);
                startActivity(intent);
            }
        });

    }
}
