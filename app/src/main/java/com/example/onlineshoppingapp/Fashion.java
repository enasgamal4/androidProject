package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Fashion extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        ArrayList<ProductCardItem> cards = new ArrayList<>();
        cards.add(new ProductCardItem("حذاء شبكي سهل الارتداء للرجال من ريميني 2480/03 – كحلي ", R.drawable.fashion1, "150.5 EG"));
        cards.add(new ProductCardItem("هودي كم طويل للنساء من اندورا - اسود", R.drawable.fashion2, "250 EG"));
        cards.add(new ProductCardItem("كارديجان ملون للنساء من بيلا دونا - متعدد الالوان", R.drawable.fashion3, "600 EG"));
        cards.add(new ProductCardItem("هودي بسحاب للنساء من كوتنبول - رمادي", R.drawable.fashion4, "429 EG"));
        cards.add(new ProductCardItem("هوديز وسويت شيرت قبة دائرية للنساء من كوتون بول،اسود", R.drawable.fashion5, "389 EG"));
        cards.add(new ProductCardItem("هوديز وسويت شيرت قبة دائرية للنساء من كوتون بول،اصفر فاتح", R.drawable.fashion6, "400 EG"));


        recyclerView = (RecyclerView) findViewById(R.id.fashion_product_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        adapter = new ProductAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
