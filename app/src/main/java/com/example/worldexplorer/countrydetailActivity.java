package com.example.worldexplorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class countrydetailActivity extends AppCompatActivity {
    Button btnBackcountrydetail, btnNextcountrydetail;
    ImageView imageView;
    TextView textName, textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrydetail);

        imageView = findViewById(R.id.imageview);
        textName = findViewById(R.id.textName);
        textInfo = findViewById(R.id.textInfo);
        btnBackcountrydetail = findViewById(R.id.btnBackcountrydetail);
        btnNextcountrydetail = findViewById(R.id.btnNextcountrydetail);


        int image = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");
        String info = getIntent().getStringExtra("info");

        imageView.setImageResource(image);
        textName.setText(name);
        textInfo.setText(info);


        btnBackcountrydetail.setOnClickListener(v -> {
            Intent i = new Intent(countrydetailActivity.this, mainActivity.class);
            startActivity(i);
        });

        btnNextcountrydetail.setOnClickListener(v -> {
            Intent i = new Intent(countrydetailActivity.this, Flags.class);
            startActivity(i);
        });








}
}