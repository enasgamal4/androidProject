package com.example.onlineshoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.onlineshoppingapp.Model.CardItem;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final ArrayList<CardItem> cards = new ArrayList<>();
        cards.add(new CardItem("Electric devices", R.drawable.electric));
        cards.add(new CardItem("Toys", R.drawable.toys));
        cards.add(new CardItem("Fashion", R.drawable.fashion));
        cards.add(new CardItem("Super Market", R.drawable.supermartket));
        cards.add(new CardItem("Sports", R.drawable.sports));


        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());

        adapter = new CategoryAdapter(cards);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                CardItem ci = cards.get(position);
                Intent inty;
                if (ci.getTitle() == "Toys") {
                    inty = new Intent(getActivity(), Toys.class);
                    startActivity(inty);
                } else if (ci.getTitle() == "Electric devices") {
                    inty = new Intent(getActivity(), Electric_devices.class);
                    startActivity(inty);
                } else if(ci.getTitle() == "Fashion") {
                    inty = new Intent(getActivity(), Fashion.class);
                    startActivity(inty);
                } else if(ci.getTitle() == "Super Market") {
                    inty = new Intent(getActivity(), Super_Market.class);
                    startActivity(inty);
                } else if(ci.getTitle() == "Sports") {
                    inty = new Intent(getActivity(), Sports.class);
                    startActivity(inty);
                }
            }
        });
        return rootView;

    }
}
