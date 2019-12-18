package com.example.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Electric_devices extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_devices);


        ArrayList<ProductCardItem> cards = new ArrayList<>();
        cards.add(new ProductCardItem("تلفزيون اتش دي ال اي دي 32 بوصة من جاك 32N، لوحة IPS - اسود", R.drawable.el1, "1500.5 EG"));
        cards.add(new ProductCardItem("لاب توب لينوفو ليجيون للالعاب Y530، شاشة فل اتش دي 15.6 بوصة اي بي اس بإضاءة خلفية، انتل كور i7-8750H، 16 جيجابايت رام، 1 تيرابايت و256 جيجابايت اس اس دي، معالج رسومات نفيديا جي فورسGTX 1060 6 جيجابايت GDDR5، دوس", R.drawable.el2, "19900 EG"));
        cards.add(new ProductCardItem("نوت بوك ديل Xps 15-9570، انتل كور I7-8750H، شاشة 15.6 بوصة يو اتش دي، 32 جيجابايت، 1 تيرابايت اس اس دي، جي تي اكس 4 جيجا، ويندوز 10 برو - أسود", R.drawable.el3, "44000 EG"));
        cards.add(new ProductCardItem("كاميرا كانون باور شوت G7 X Mark II - بدقة 20.1 ميجابكسل، كاميرا بوينت اند شوت، اسود", R.drawable.el4, "10900 EG"));
        cards.add(new ProductCardItem("سماعات بلوتوث متنقلة من جيه بي ال فليب 4 مضادة للماء - رمادي، JBLFLIP4GRYAM", R.drawable.el5, "2500 EG"));
        cards.add(new ProductCardItem("Promate HDMI TO VGA Converter Adapter Cable 1080P Male to Female for PC, DVD, HDTV and Laptop, Prolink-H2V Black", R.drawable.el6, "390 EG"));


        recyclerView = (RecyclerView) findViewById(R.id.electric_devices_product_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        adapter = new ProductAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
