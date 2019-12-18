package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class Super_Market extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super__market);


        ArrayList<ProductCardItem> cards = new ArrayList<>();
        cards.add(new ProductCardItem("لوز بقشرة من ابو عوف, 200 جرام", R.drawable.market1, "102.5 EG"));
        cards.add(new ProductCardItem("تمر بالشكولاتة واللوز صحاري ديلايتس من ابو عوف - 300 جم", R.drawable.market2, "77 EG"));
        cards.add(new ProductCardItem("كرتونة فانتا برتقال 6 عبوات بلاستيك - 1.97 لتر", R.drawable.market3, "80 EG"));
        cards.add(new ProductCardItem("ليمون زنجبيل اعشاب من رويال، 12 كيس", R.drawable.market4, "8 EG"));
        cards.add(new ProductCardItem("مكرونة تويست من ريجينا - 400 جم", R.drawable.market5, "9.8 EG"));



        recyclerView = (RecyclerView) findViewById(R.id.super_market_product_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        adapter = new ProductAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
