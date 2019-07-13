package com.example.expandable_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Products> productsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        productsList = new ArrayList<>();

        productsList.add(new Products("Apple Watch", "Watch", 4.5f));
        productsList.add(new Products("Airpods", "Wireless Earphones", 5.0f));
        productsList.add(new Products("Samsung Gear", "Watch", 3.9f));
        productsList.add(new Products("Samsung S9 Plus", "Mobile", 3.5f));
        productsList.add(new Products("Iphone X", "Mobile", 4.7f));
        productsList.add(new Products("Iphone XR", "Mobile", 5.0f));
        productsList.add(new Products("Samsung S10 Pro", "Mobile", 3.8f));
        productsList.add(new Products("Beats Solo 3", "Wireless Headphones", 4.9f));
        productsList.add(new Products("JBL Pulse", "Speakers", 4.5f));
        productsList.add(new Products("XBOX 2", "Play Station", 4.7f));

        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(productsList);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
