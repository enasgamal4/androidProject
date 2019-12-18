package com.example.onlineshoppingapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshoppingapp.Model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<CardItem> myCardsItem ;

    public  static class CategoryViewHolder  extends  RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mImageView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_link);
            mTextView = itemView.findViewById(R.id.category_title);

        }
    }

    public  CategoryAdapter(ArrayList<CardItem> cardItems) {
        myCardsItem = cardItems;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        CategoryViewHolder categoryViewHolder  = new CategoryViewHolder(v);
        return  categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CardItem currentitem = myCardsItem.get(position);

        holder.mImageView.setImageResource(currentitem.getImage());
        holder.mTextView.setText(currentitem.getTitle());
    }

    @Override
    public int getItemCount() {
        return myCardsItem.size();
    }
}
