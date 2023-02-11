package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class InGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        TextView textView = (TextView) findViewById(R.id.game_selected);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_user1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_user2);

        Intent intentBefore = getIntent();
        Bundle bundle = intentBefore.getExtras();
        String name = bundle.getString("gameName");
        textView.setText(name);

        Button buttonAddUser = (Button) findViewById(R.id.btn_addUser);
        Button buttonBack = (Button) findViewById(R.id.btn_back);
        Button buttonHome = (Button) findViewById(R.id.btn_home);
        Button buttonRank = (Button) findViewById(R.id.rank_page);
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userListIntent = new Intent(getApplicationContext(), UserListActivity.class);
                startActivity(userListIntent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), MainGameActivity.class);
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

        buttonRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rankIntent = new Intent(getApplicationContext(), ShowRankActivity.class);
                startActivity(rankIntent);
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.username_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        String user1Name = spinner1.getSelectedItem().toString();
        String user2Name = spinner2.getSelectedItem().toString();



//        Intent intentSpinner1 = new Intent(this.) // 게임 기록하는 액티비티로 인텐트



//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                textView.setText((String) adapterView.getItemAtPosition(i));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                textView.setText("선택");
//            }
//        });



    }



}