package com.example.scoreboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
    Context context;
    ArrayList<GameItem> items = new ArrayList<GameItem>(); //item 데이터


    public GameAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.game_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameItem item = items.get(position);
        holder.setItem(item);

    }

    public void addItem(GameItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<GameItem> items) {
        this.items = items;
    }

    public GameItem getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_game;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_game =  (TextView) itemView.findViewById(R.id.textView_game);

        }

        public void setItem(GameItem item) {
            textView_game.setText(item.getGameName());
        }
    }

}
