package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.onlineshoppingapp.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Toys extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProductAdapter adapter;

    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toys);

        final ArrayList<ProductCardItem> cards = new ArrayList<>();
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

        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ProductCardItem p = cards.get(position);
                if(Common.FirstOrder) {
                    dbRef.child("Orders").setValue(Common.currentUser.phone);
                    Common.FirstOrder = false;
                }

                dbRef.child("Orders").child(Common.currentUser.phone).child("products").push().setValue(p);
                Toast.makeText(Toys.this, "Added", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
