package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineshoppingapp.Common.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Sports extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProductAdapter adapter;
    private boolean FIRSTTIME = true;

    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);


        final ArrayList<ProductCardItem> cards = new ArrayList<>();
        cards.add(new ProductCardItem("توب سكاي لاند سجادة يوغا، ازرق، سمك 10 ملم", R.drawable.sport1, "150.5 EG"));
        cards.add(new ProductCardItem("مشاية كهربائية بشاشة ال سي دي ديلوكس من بودي سكالبتشر - اسود", R.drawable.sport2, "5800 EG"));
        cards.add(new ProductCardItem("سجادة لتمارين اليوجا من بودي سكالبتشر - ازرق", R.drawable.sport3, "300 EG"));
        cards.add(new ProductCardItem("مقعد مائل للاعلى من بودي سكالبتشر Bsb-625", R.drawable.sport4, "1700 EG"));
        cards.add(new ProductCardItem("L size Anti fog Detachable dry snorkeling full face mask set scuba diving mask-black", R.drawable.sport5, "220 EG"));



        recyclerView = (RecyclerView) findViewById(R.id.sports_product_recycler_view);

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
                Toast.makeText(Sports.this, "Added", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
