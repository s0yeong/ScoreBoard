package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
        Button buttonRestart = (Button) findViewById(R.id.btn_restart_game);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.username_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setSelection(0);
        spinner2.setSelection(0);

        String user1Name = spinner1.getSelectedItem().toString();
        String user2Name = spinner2.getSelectedItem().toString();

        EditText editTextofUser2Score = (EditText) findViewById(R.id.user2_score);


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

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner2.setSelection(0);
                editTextofUser2Score.setText(null);
            }
        });




    }



}