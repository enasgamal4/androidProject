package com.example.onlineshoppingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList<ProductCardItem> cards = new ArrayList<>();
        cards.add(new ProductCardItem("Iphone 7 plus", R.drawable.iphone7plus, "8999"));
        cards.add(new ProductCardItem("Iphone xs max", R.drawable.xsmax, "14500"));
        cards.add(new ProductCardItem("Samsung Galaxy Fold", R.drawable.fold, "38000"));
        cards.add(new ProductCardItem("Lenovo Legnend", R.drawable.lenvovo, "17800"));
        cards.add(new ProductCardItem("Samsung tv", R.drawable.tv, "4500"));
        cards.add(new ProductCardItem("Samsung s10 plus", R.drawable.samsungs10plus,"18900"));
        cards.add(new ProductCardItem("Note book ", R.drawable.notebook, "15600"));

        View rootView = inflater.inflate(R.layout.fragment_products, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.product_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());

        adapter = new ProductAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return rootView;
        
    }
}
