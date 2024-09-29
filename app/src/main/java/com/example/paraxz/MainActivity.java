package com.example.paraxz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<State>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        StateAdapter adapter = new StateAdapter(this, states);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                State state = states.get(position);
                Intent intent = new Intent(MainActivity.this, openPage.class);
                startActivity(intent);
            }
        });
    }

    private void setInitialData() {
        states.add(new State("Культ барашки", "Прикольная игра +вайб", R.drawable.img));
        states.add(new State("Унитаз 1", "База унитаз", R.drawable.unitaz1));
        states.add(new State("Унитаз 2", "Хочу такой +вайб", R.drawable.unitaz2));
        states.add(new State("Тумба", "Без комметариев", R.drawable.tnmba));
    }
}