package com.example.paraxz;

import android.content.Intent;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class openPage extends AppCompatActivity {
    ImageView img;
    TextView opis;
    TextView name;
    Button vihod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);
        img = findViewById(R.id.flagOpen);
        opis = findViewById(R.id.opisOpen);
        name = findViewById(R.id.textNazv);
        vihod = findViewById(R.id.vixodBTM);
        Intent intent = getIntent();
        int imgGet = intent.getIntExtra("flagOpen", 1);
        String opisGet = intent.getStringExtra("opisOpen");
        String nameGet = intent.getStringExtra("textNazv");
        opis.setText(opisGet);
        name.setText(nameGet);
        img.setImageResource(imgGet);
        vihod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(openPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}