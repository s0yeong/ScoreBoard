package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainGameActivity extends AppCompatActivity {
    FrameLayout frame;
    ArrayList arrayList = new ArrayList();
    SwipeRefreshLayout mSwipeRefreshLayout;
    TextView mTextView;
    Button addTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        mTextView = (TextView) findViewById(R.id.gameName);

        addTextView = findViewById(R.id.btn_add);
        addTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextView();
            }
        });
    }

    private void addTextView() {
        TextView textViewNm = new TextView(getApplicationContext());
        textViewNm.setText("텍스트 생성");
        textViewNm.setTextSize(40);
        textViewNm.setTypeface(null, Typeface.BOLD);
        textViewNm.setId(0);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
        , LinearLayout.LayoutParams.WRAP_CONTENT);
        param.leftMargin=30;
    }


}