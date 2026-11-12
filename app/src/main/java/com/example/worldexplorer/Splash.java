
package com.example.worldexplorer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    // Set the splash screen display duration to 3 seconds
    private static final long SPLASH_DELAY = 3000;

    // Declare variables for audio playback and delayed navigation
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private Runnable navigateRunnable;
    private boolean isNavigated = false;

    // Initialize the splash screen
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Connect the application name TextView
        TextView tvAppName = findViewById(R.id.tvAppName);

        // Play the splash screen sound
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.pop);
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a Handler to manage delayed navigation
        handler = new Handler();

        // Define the action to perform after the delay
        navigateRunnable = new Runnable() {
            @Override
            public void run() {
                goToNext();
            }
        };

        // Schedule navigation after 3 seconds
        handler.postDelayed(navigateRunnable, SPLASH_DELAY);
    }

    // Navigate to the main activity
    private void goToNext() {

        // Prevent navigation from happening more than once
        if (isNavigated) return;
        isNavigated = true;

        Intent intent = new Intent(Splash.this, mainActivity.class);
        startActivity(intent);

        // Close the splash screen
        finish();
    }

    // Release resources when the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Cancel any pending navigation callbacks
        if (handler != null && navigateRunnable != null) {
            handler.removeCallbacks(navigateRunnable);
        }

        // Stop and release the audio player
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
