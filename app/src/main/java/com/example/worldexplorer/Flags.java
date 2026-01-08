package com.example.worldexplorer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Flags extends AppCompatActivity {

    GridView gridView;
    Button btnNext, btnBack;
    MediaPlayer mediaPlayer;
    Button btnOff;

    int[] flagImages = {
            R.drawable.brazil, R.drawable.saudi, R.drawable.italy,
            R.drawable.sudan, R.drawable.japan, R.drawable.france
    };

    String[] countryNames = {
            "Brazil", "Saudi Arabia", "Italy",
            "Sudan", "Japan", "France"
    };

    int[] anthemSounds = {
            R.raw.brazil, R.raw.saudi, R.raw.italy,
            R.raw.sudan, R.raw.japan, R.raw.france
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("World Explorer");

        gridView = findViewById(R.id.gridViewFlags);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        btnOff = findViewById(R.id.btnOff);

        FlagAdapter adapter = new FlagAdapter(this, flagImages, countryNames);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, position, id) -> {
            if (mediaPlayer != null) mediaPlayer.release();

            mediaPlayer = MediaPlayer.create(this, anthemSounds[position]);
            mediaPlayer.start();

            Toast.makeText(this, countryNames[position], Toast.LENGTH_SHORT).show();
        });

        btnNext.setOnClickListener(v -> {
            Intent i = new Intent(Flags.this, map.class);
            startActivity(i);
        });
        btnOff.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(this, "Sound stopped", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
