package com.example.worldexplorer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class map extends AppCompatActivity {

    Button btnAsia, btnEurope, btnAfrica, btnBackmap, btnNextmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("World Explorer");


        btnAsia = findViewById(R.id.btnAsia);
        btnEurope = findViewById(R.id.btnEurope);
        btnAfrica = findViewById(R.id.btnAfrica);
        btnBackmap = findViewById(R.id.btnBackmap);
        btnNextmap = findViewById(R.id.btnNextmap);


        btnAsia.setOnClickListener(v -> {
            openBrowser("https://en.wikipedia.org/wiki/Asia");

        });

        btnEurope.setOnClickListener(v -> {
            openBrowser("https://en.wikipedia.org/wiki/Europe");

        });

        btnAfrica.setOnClickListener(v -> {
            openBrowser("https://en.wikipedia.org/wiki/Africa");

        });


        btnBackmap.setOnClickListener(v -> {
            Intent i = new Intent(map.this, Flags.class);
            startActivity(i);
        });

        btnNextmap.setOnClickListener(v -> {
            Intent i = new Intent(map.this, Greetings.class);
            startActivity(i);
        });
    }


    private void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
