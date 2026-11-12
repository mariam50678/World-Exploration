
package com.example.worldexplorer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Flags extends AppCompatActivity {

    // Declare UI components and audio player
    GridView gridView;
    Button btnNext, btnBack;
    MediaPlayer mediaPlayer;
    Button btnOff;

    // Store the flag image resources
    int[] flagImages = {
            R.drawable.brazil, R.drawable.saudi, R.drawable.italy,
            R.drawable.sudan, R.drawable.japan, R.drawable.france
    };

    // Store the corresponding country names
    String[] countryNames = {
            "Brazil", "Saudi Arabia", "Italy",
            "Sudan", "Japan", "France"
    };

    // Store the national anthem audio resources
    int[] anthemSounds = {
            R.raw.brazil, R.raw.saudi, R.raw.italy,
            R.raw.sudan, R.raw.japan, R.raw.france
    };

    // Initialize the activity and its interface
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

        // Set the application title in the action bar
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("World Explorer");

        // Connect UI components to their XML views
        gridView = findViewById(R.id.gridViewFlags);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnOff = findViewById(R.id.btnOff);

        // Create the adapter and display the flags in the GridView
        FlagAdapter adapter = new FlagAdapter(this, flagImages, countryNames);
        gridView.setAdapter(adapter);

        // Handle flag selection and play the corresponding national anthem
        gridView.setOnItemClickListener((adapterView, view, position, id) -> {
            if (mediaPlayer != null) mediaPlayer.release();

            mediaPlayer = MediaPlayer.create(this, anthemSounds[position]);
            mediaPlayer.start();

            // Display the selected country name
            Toast.makeText(this, countryNames[position], Toast.LENGTH_SHORT).show();
        });

        // Navigate to the map screen
        btnNext.setOnClickListener(v -> {
            Intent i = new Intent(Flags.this, map.class);
            startActivity(i);
        });

        // Stop the currently playing national anthem
        btnOff.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(this, "Sound stopped", Toast.LENGTH_SHORT).show();
            }
        });

        // Return to the previous screen
        btnBack.setOnClickListener(v -> finish());
    }
}
