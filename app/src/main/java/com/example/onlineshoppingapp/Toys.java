package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Toys extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toys);

        ArrayList<ProductCardItem> cards = new ArrayList<>();
        cards.add(new ProductCardItem("بيتش باجي كبير للأطفال", R.drawable.toys5, "475 EG"));
        cards.add(new ProductCardItem("للجنسين - سكوتر بن تن -اخضر", R.drawable.toys1, "200 EG"));
        cards.add(new ProductCardItem("مشاية أطفال فارو نور وموسيقى", R.drawable.toys2, "500 EG"));
        cards.add(new ProductCardItem("لعبة مجسم سبايدرمان S-54، متعددة الالوان", R.drawable.toys3, "47 EG"));
        cards.add(new ProductCardItem("لعبة مجسم بات مان S-54، اسود", R.drawable.toys4, "47 EG"));



        recyclerView = (RecyclerView) findViewById(R.id.toys_product_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        adapter = new ProductAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
