package com.example.onlineshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.onlineshoppingapp.Common.Common;
import com.example.onlineshoppingapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fashion extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProductAdapter adapter;
    private User currentUser;
    private boolean FIRSTTIME = true;

    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);


        currentUser = Common.currentUser;

        final ArrayList<ProductCardItem> cards = new ArrayList<>();
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
        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ProductCardItem p = cards.get(position);
                if(Common.FirstOrder) {
                    dbRef.child("Orders").setValue(Common.currentUser.phone);
                    Common.FirstOrder = false;
                }

                dbRef.child("Orders").child(Common.currentUser.phone).child("products").push().setValue(p);
                Toast.makeText(Fashion.this, "Added", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
