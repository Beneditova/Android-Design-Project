package com.example.simplestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerviewItemAdapter recyclerviewItemAdapter;
    private List<Items> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycleView);

        recyclerviewItemAdapter = new RecyclerviewItemAdapter(itemsList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewItemAdapter);

        prepareItems();
    }

    private void prepareItems(){
        for(int i = 0; i < 50; i++) {
            Items items = new Items("Item"+i,20+i);
            itemsList.add(items);
        }
        recyclerviewItemAdapter.notifyDataSetChanged();
    }
}