package com.example.exo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class hub extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hub);
        Button exo2_button = findViewById(R.id.exo2_button);
        exo2_button.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, HelloAndroid.class);
            startActivity(intent);
        });
        Button exo3_button_1 = findViewById(R.id.exo3_button_1);
        exo3_button_1.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, interface_simple_xml.class);
            startActivity(intent);
        });
        Button exo3_button_2 = findViewById(R.id.exo3_button_2);
        exo3_button_2.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, interface_simple_java.class);
            startActivity(intent);
        });
        Button exo6_button = findViewById(R.id.exo6_button);
        exo6_button.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, intent_explicite.class);
            startActivity(intent);
        });
        Button exo7_button = findViewById(R.id.exo7_button);
        exo7_button.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, intent_implicite.class);
            startActivity(intent);
        });
        Button exo8_button = findViewById(R.id.exo8_button);
        exo8_button.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, applitrain.class);
            startActivity(intent);
        });
        Button exo9_button = findViewById(R.id.exo9_button);
        exo9_button.setOnClickListener(v -> {
            Intent intent = new Intent(hub.this, applitrain.class);
            startActivity(intent);
        });

    }
}
