
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

    // Declare buttons for language selection and screen navigation
    Button btnArabic, btnEnglish, btnJapanese, btnFrench,
            btnBackGreetings, btnNextGreetings;

    MediaPlayer mp;

    // Initialize the activity and set its layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);

        // Connect navigation buttons to their XML views
        btnBackGreetings = findViewById(R.id.btnBackGreetings);
        btnNextGreetings = findViewById(R.id.btnNextGreetings);

        // Connect language selection buttons to their XML views
        btnArabic = findViewById(R.id.btnArabic);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnJapanese = findViewById(R.id.btnJapanese);
        btnFrench = findViewById(R.id.btnFrench);

        // Display an Arabic greeting when the Arabic button is clicked
        btnArabic.setOnClickListener(v -> {
            Toast.makeText(this, "مرحباً", Toast.LENGTH_SHORT).show();
        });

        // Display an English greeting when the English button is clicked
        btnEnglish.setOnClickListener(v -> {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        });

        // Display a Japanese greeting when the Japanese button is clicked
        btnJapanese.setOnClickListener(v -> {
            Toast.makeText(this, "こんにちは", Toast.LENGTH_SHORT).show();
        });

        // Display a French greeting when the French button is clicked
        btnFrench.setOnClickListener(v -> {
            Toast.makeText(this, "Bonjour", Toast.LENGTH_SHORT).show();
        });

        // Navigate back to the map screen
        btnBackGreetings.setOnClickListener(v -> {
            Intent i = new Intent(Greetings.this, map.class);
            startActivity(i);
        });

        // Navigate to the quiz screen
        btnNextGreetings.setOnClickListener(v -> {
            Intent i = new Intent(Greetings.this, Quiz.class);
            startActivity(i);
        });

    }

}
