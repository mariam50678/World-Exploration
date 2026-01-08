package com.example.worldexplorer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {

    TextView txtQuestion;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3;
    Button btnCheck, btnBackQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        txtQuestion = findViewById(R.id.txtQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        btnCheck = findViewById(R.id.btnCheck);
        btnBackQuiz = findViewById(R.id.btnBackQuiz);

        txtQuestion.setText("What is the capital of Italy ?");

        btnCheck.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(Quiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
            } else if (selectedId == option2.getId()) {
                Toast.makeText(Quiz.this, "Correct answer!🎉", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Quiz.this, "Wrong answer ❌", Toast.LENGTH_SHORT).show();
            }
        });

        btnBackQuiz.setOnClickListener(v -> {
            Intent i = new Intent(Quiz.this, Greetings.class);
            startActivity(i);
        });



    }
}
