package com.example.worldexplorer;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.ref.ReferenceQueue;

public class Greetings extends AppCompatActivity {

    Button btnArabic, btnEnglish, btnJapanese, btnFrench,  btnBackGreetings ,btnNextGreetings;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        btnBackGreetings = findViewById(R.id.btnBackGreetings);
        btnNextGreetings = findViewById(R.id.btnNextGreetings);

        btnArabic = findViewById(R.id.btnArabic);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnJapanese = findViewById(R.id.btnJapanese);
        btnFrench = findViewById(R.id.btnFrench);

        btnArabic.setOnClickListener(v -> {
            Toast.makeText(this, "مرحباً", Toast.LENGTH_SHORT).show();
        });

        btnEnglish.setOnClickListener(v -> {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        });

        btnJapanese.setOnClickListener(v -> {
            Toast.makeText(this, "こんにちは", Toast.LENGTH_SHORT).show();
        });

        btnFrench.setOnClickListener(v -> {
            Toast.makeText(this, "Bonjour", Toast.LENGTH_SHORT).show();
        });



        // زر الرجوع لشاشة map
        btnBackGreetings.setOnClickListener(v -> {
            Intent i = new Intent(Greetings.this, map.class);
            startActivity(i);
        });

        btnNextGreetings.setOnClickListener(v -> {
            Intent i = new Intent(Greetings.this, Quiz.class);
            startActivity(i);
        });

}

}
