package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button userAddButton = (Button) findViewById(R.id.btn_addUser);
        Button homeButton = (Button) findViewById(R.id.btn_home);

        userAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userAddedIntent = new Intent(getApplicationContext(), InGameActivity.class);

                EditText editName = (EditText) findViewById(R.id.edit_name);
                EditText editAge = (EditText) findViewById(R.id.edit_age);
                CheckBox checkBoxM = (CheckBox) findViewById(R.id.checkbox_man);
                CheckBox checkBoxW = (CheckBox) findViewById(R.id.checkbox_woman);

                assert userAddedIntent != null;
                String name = editName.getText().toString();
                userAddedIntent.putExtra("userName", name);
                int age = Integer.parseInt(editAge.getText().toString().trim());
                userAddedIntent.putExtra("userAge", age);

                String sex = null;
                if (checkBoxM.isChecked()) {
                    if (checkBoxW.isChecked()) {
                        checkBoxW.setChecked(false);
                    }
                    sex = "man";
                } else if (checkBoxW.isChecked()) {
                    if (checkBoxM.isChecked()) {
                        checkBoxM.setChecked(false);
                    }
                    sex = "woman";
                }
                userAddedIntent.putExtra("sex", sex);

                startActivity(userAddedIntent);
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