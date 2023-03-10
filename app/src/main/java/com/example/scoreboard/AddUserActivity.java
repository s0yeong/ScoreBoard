package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button userAddButton = (Button) findViewById(R.id.btn_addUser);
        Button backButton = (Button) findViewById(R.id.btn_back);
        Button homeButton = (Button) findViewById(R.id.btn_home);

        EditText editName = (EditText) findViewById(R.id.edit_name);
        EditText editAge = (EditText) findViewById(R.id.edit_age);
        CheckBox checkBoxM = (CheckBox) findViewById(R.id.checkbox_man);
        CheckBox checkBoxW = (CheckBox) findViewById(R.id.checkbox_woman);


        userAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userListIntent = new Intent(getApplicationContext(), UserListActivity.class);

                int pos = (int) view.getTag();

                String name = editName.getText().toString();
                int age = 0;
                try {
                    age = Integer.parseInt(editAge.getText().toString().trim());
                } catch (NumberFormatException e) {

                } catch (Exception e) {

                }
                int finalAge = age;

                String sex = "";
                if (checkBoxW.isChecked()) {
                    sex = "woman";
                } else if (checkBoxM.isChecked()) {
                    sex = "man";
                }


                userListIntent.putExtra("userName", name);
                userListIntent.putExtra("userAge", finalAge);
                userListIntent.putExtra("userSex", sex);

                Toast.makeText(getApplicationContext(), "?????????: "+ name +" ?????????.", Toast.LENGTH_LONG).show();
                setResult(RESULT_OK, userListIntent);

                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
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