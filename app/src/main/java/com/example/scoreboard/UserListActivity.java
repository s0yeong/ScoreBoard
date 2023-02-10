package com.example.scoreboard;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class UserListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserInfoAdapter userInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        Button btnToAddUserPage = (Button) findViewById(R.id.add_user_page);
        btnToAddUserPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser = new Intent(getApplicationContext(), AddUserActivity.class);
                startActivityResult.launch(intentAddUser);
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.user_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        userInfoAdapter =  new UserInfoAdapter(getApplicationContext());

        // 기본 데이터 추가
        userInfoAdapter.addItem(new UserInfoItem("echo", 24, "woman"));
        recyclerView.setAdapter(userInfoAdapter);

    }

    //User 정보 받기
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK) {
                        //다른 액티비티를 다녀와서 실행할 작업 작성
                        if(result != null) {
                            Intent intentBefore = result.getData();
                            String name = (String) intentBefore.getStringExtra("userName");
                            int age = (int) intentBefore.getIntExtra("userAge", 0);
                            String sex = (String) intentBefore.getStringExtra("userSex");

                            userInfoAdapter.addItem(new UserInfoItem(name, age, sex));
                            recyclerView.setAdapter(userInfoAdapter);
                            userInfoAdapter.notifyDataSetChanged();
                        }
                    }
                }
    });
}