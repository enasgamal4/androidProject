package com.example.onlineshoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SerachFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
    EditText edtSearch ;
    ImageButton btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        edtSearch = (EditText) rootView.findViewById(R.id.edtSearch);
        btn = (ImageButton) rootView.findViewById(R.id.btnSerach);


        final ArrayList<ProductCardItem> products = new ArrayList<ProductCardItem>();
        final ArrayList<ProductCardItem> matchedItem = new ArrayList<ProductCardItem>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String va = edtSearch.getText().toString();
                dbRef.child("Products").addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                            ProductCardItem prod = postSnapshot.getValue(ProductCardItem.class);
                            products.add(prod);
                        }

                        String va = edtSearch.getText().toString();
                        ProductCardItem pci = new ProductCardItem();
                        for(int i = 0; i < products.size(); i++) {


                            if(products.get(i).getProductTitle().toLowerCase().contains(va.toLowerCase())) {
                                pci = products.get(i);
                                matchedItem.add(pci);
                                Toast.makeText(getActivity(), products.get(i).getProductTitle(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(getActivity(), products.get(i).getPrice(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


        return rootView;

    }
}
