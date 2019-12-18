package com.example.onlineshoppingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<ProductCardItem> productCardItems;

    public static  class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView productTitle;
        public TextView productprice;
        public ImageView productImage;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image_link);
            productprice = itemView.findViewById(R.id.product_price);
            productTitle = itemView.findViewById(R.id.product_title);
        }
    }

    public ProductAdapter(ArrayList<ProductCardItem> productCardItems) {
        this.productCardItems = productCardItems;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_item, parent, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductCardItem currentItem = productCardItems.get(position);
        holder.productTitle.setText(currentItem.getTitle());
        holder.productImage.setImageResource(currentItem.getImage());
        holder.productprice.setText(currentItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return productCardItems.size();
    }
}
