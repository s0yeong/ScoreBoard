package com.example.scoreboard;

import static com.example.scoreboard.R.id.btn_back;
import static com.example.scoreboard.R.id.btn_home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameRankActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    private Spinner spinner;
    private CustomSpinnerAdapter adapter;
    private String selectedGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_rank);

        spinner = findViewById(R.id.spinner_game_select);
        Resources res = getResources();
        String[] games = res.getStringArray(R.array.game_array);
        list = Arrays.asList(games);

        // 스피너 어댑터 초기화
        adapter = new CustomSpinnerAdapter(this, list);
        spinner.setAdapter(adapter);

        // 스피너 클릭 리스너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedGame = adapter.getItem();
                Toast.makeText(GameRankActivity.this, "선택한 게임 : " + selectedGame, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });

        Button buttonBack = (Button) findViewById(btn_back);
        Button buttonHome = (Button) findViewById(btn_home);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowRankActivity.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(intent);
            }
        });



    }
}