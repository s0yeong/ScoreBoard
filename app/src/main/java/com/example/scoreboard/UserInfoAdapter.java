package com.example.scoreboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {
    Context context;
    ArrayList<UserInfoItem> items = new ArrayList<UserInfoItem>();

    public UserInfoAdapter(Context applicationContext) {
        this.context=applicationContext;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.user_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserInfoItem item = items.get(position);
        holder.setItem(item);
    }

    public void addItem(UserInfoItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<UserInfoItem> items) {
        this.items = items;
    }

    public UserInfoItem getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        int userPos;
        TextView userId;
        TextView userAge;
        TextView userSex;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            int userPos = getAbsoluteAdapterPosition();
            userId = (TextView) itemView.findViewById(R.id.user_id);
            userAge = (TextView) itemView.findViewById(R.id.user_age);
            userSex = (TextView) itemView.findViewById(R.id.user_sex);
        }

        public void setItem(UserInfoItem item) {
            userId.setText(item.getName());
            userAge.setText(String.valueOf(item.getAge())); //setText: int형일 때는 무조건 string으로
            userSex.setText(item.getSex());

        }
    }
}
