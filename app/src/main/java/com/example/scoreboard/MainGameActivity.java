package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainGameActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        Button buttonBack = (Button) findViewById(R.id.btn_back);

        recyclerView = (RecyclerView) findViewById(R.id.game_pager);
        PagerSnapHelper snapHelper = new PagerSnapHelper();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        GameAdapter adapter = new GameAdapter(getApplicationContext());

        //pager indicator
        recyclerView.addItemDecoration(new CircleIndicator());
        //add page behavior
        snapHelper.attachToRecyclerView(recyclerView);


        adapter.addItem(new GameItem("탁구"));
        adapter.addItem(new GameItem("축구"));
        adapter.addItem(new GameItem("배드민턴"));
        adapter.addItem(new GameItem("가위바위보"));
        adapter.addItem(new GameItem("농구"));


        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new GameAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(GameAdapter.ViewHolder holder, View view, int position) {
                GameItem item = adapter.getItem(position);
                String name = item.getGameName().toString();

                Intent intent = new Intent(getApplicationContext(), InGameActivity.class);
                intent.putExtra("gameName", name);
                startActivity(intent);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), ChooseActivity.class);
                startActivity(backIntent);
            }
        });
    }

}