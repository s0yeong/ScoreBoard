package com.example.scoreboard;

import static com.example.scoreboard.R.id.btn_back;
import static com.example.scoreboard.R.id.btn_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRankActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<>();
    private Spinner spinner;
    private CustomSpinnerAdapter adapter;
    private String selectedUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rank);


        spinner = findViewById(R.id.spinner_user_select);
        Resources res = getResources();
        String[] names = res.getStringArray(R.array.username_array);
        list = Arrays.asList(names);

        // 스피너 어댑터 초기화
        adapter = new CustomSpinnerAdapter(this, list);
        spinner.setAdapter(adapter);

        // 스피너 클릭 리스너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedUser = adapter.getItem();
                Toast.makeText(UserRankActivity.this, "선택한 사용자 : " + selectedUser, Toast.LENGTH_SHORT).show();
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