package com.example.onlineshoppingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.onlineshoppingapp.Common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CardFragment extends Fragment {
    TextView textView;
    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        textView = (TextView) rootView.findViewById(R.id.totalAmount);


        final ArrayList<ProductCardItem> cardproducts = new ArrayList<>();

        dbRef.child("Orders").child(Common.currentUser.phone).child("products").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("Count ", "" + dataSnapshot.getChildrenCount());
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    ProductCardItem prod = postSnapshot.getValue(ProductCardItem.class);
                    cardproducts.add(prod);
                }
                int totlasum = 0;
                ProductCardItem pci = new ProductCardItem();
                for (int i = 0; i < cardproducts.size(); i++) {
                    String price = cardproducts.get(i).getPrice();
                    int cost = Integer.parseInt(price.split("E")[0].replaceAll("\\s+",""));
                    totlasum += cost;

                }

                Toast.makeText(getActivity(), String.valueOf(totlasum), Toast.LENGTH_SHORT).show();
                textView.setText(String.valueOf(totlasum));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return rootView;

    }


}