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

    private static final long SPLASH_DELAY = 3000;
    private MediaPlayer mediaPlayer;
    private Handler handler;
    private Runnable navigateRunnable;
    private boolean isNavigated = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TextView tvAppName = findViewById(R.id.tvAppName);


        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.pop);
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        handler = new Handler();
        navigateRunnable = new Runnable() {
            @Override
            public void run() {
                goToNext();
            }
        };
        handler.postDelayed(navigateRunnable, SPLASH_DELAY);
    }

    private void goToNext() {
        if (isNavigated) return;
        isNavigated = true;

        Intent intent = new Intent(Splash.this, mainActivity.class);
        startActivity(intent);

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (handler != null && navigateRunnable != null) {
            handler.removeCallbacks(navigateRunnable);
        }

        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
