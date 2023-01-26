package com.example.scoreboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {
    Button buttonView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false); //ViewGroup 객체 리턴
        buttonView = (Button) rootView.findViewById(R.id.fragment_view);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @SuppressLint("ResourceType")
    public void setImage(int index) {
        if(index==0) {
            buttonView.setText(R.id.badminton);
        } else if(index==1) {
            buttonView.setText(R.id.baseball);
        } else if(index==2) {
            buttonView.setText(R.id.table_tennis);
        }
    }
}
