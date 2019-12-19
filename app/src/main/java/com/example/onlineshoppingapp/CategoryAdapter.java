package com.example.onlineshoppingapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.onlineshoppingapp.Model.CardItem;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<CardItem> myCardsItem ;

    private OnItemClickListener mListnerer;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListnerer= listener;
    }

    public  static class CategoryViewHolder  extends  RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mImageView;

        public CategoryViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_link);
            mTextView = itemView.findViewById(R.id.category_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!= null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }

    public  CategoryAdapter(ArrayList<CardItem> cardItems) {
        myCardsItem = cardItems;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        CategoryViewHolder categoryViewHolder  = new CategoryViewHolder(v, mListnerer);
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
