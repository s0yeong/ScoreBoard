package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainGameActivity extends AppCompatActivity {
    ViewpagerAdapter pagerAdapter;
    ViewPager2 viewPager2;
    ArrayList<Fragment> fragList = new ArrayList<Fragment>();
    Button addGameBtn, modifyGameBtn, deleteGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        viewPager2 = findViewById(R.id.game_pager);

        // 기본 게임 3개 추가
        Fragment fragment1 = new Fragment();
        Fragment fragment2 = new Fragment();
        Fragment fragment3 = new Fragment();

        fragList.add(fragment1);
        fragList.add(fragment2);
        fragList.add(fragment3);

        pagerAdapter = new ViewpagerAdapter(setGameList());


        addGameBtn = findViewById(R.id.btn_add);
        modifyGameBtn = findViewById(R.id.btn_modify);
        deleteGameBtn = findViewById(R.id.btn_delete);

        addGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setGameList();
            }

        });


    }

    private ArrayList setGameList() {
        ArrayList<String> itemList = new ArrayList();

        addGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment();
                fragList.add(fragment);
            }

        });

        return itemList;
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

        textViewNm.setLayoutParams(param);
//        mTextView.addview(textViewNm);
    }


}