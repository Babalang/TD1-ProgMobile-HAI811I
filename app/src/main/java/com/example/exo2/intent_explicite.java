package com.example.exo2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class intent_explicite extends Activity {
    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_explicite);
        TextView name = findViewById(R.id.NameTextView);
        name.setText(getString(R.string.Exo3_Name_input)+" : "+ getIntent().getStringExtra("NAME"));
        TextView surname = findViewById(R.id.SurnameTextView);
        surname.setText(getString(R.string.Exo3_Surname_input)+" : "+getIntent().getStringExtra("SURNAME"));
        TextView age = findViewById(R.id.AgeTextView);
        age.setText(getString(R.string.Exo3_Age_input)+" : "+getIntent().getStringExtra("AGE"));
        TextView competence = findViewById(R.id.CompetenceTextView);
        competence.setText(getString(R.string.Exo3_Competences_input)+" : "+getIntent().getStringExtra("COMPETENCE"));
        TextView telnum = findViewById(R.id.NumTelTextView);
        telnum.setText(getString(R.string.Exo3_NumTel_input)+" : "+getIntent().getStringExtra("NUMTEL"));
        Button button = findViewById(R.id.cancel_button);
        button.setOnClickListener(v -> finish());
        Button button1 = findViewById(R.id.validate_button);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(intent_explicite.this, intent_implicite.class);
            intent.putExtra("NUMTEL",getIntent().getStringExtra("NUMTEL"));
            startActivity(intent);
        });
    }
}

