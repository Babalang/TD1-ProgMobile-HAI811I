package com.example.exo2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class intent_implicite extends Activity {
    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_implicite);
        TextView text = findViewById(R.id.text);
        text.setText(getIntent().getStringExtra("NUMTEL"));
        Button button1 = findViewById(R.id.Button_validate);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + getIntent().getStringExtra("NUMTEL")));
            startActivity(intent);
        });
        Button button = findViewById(R.id.Button_cancel);
        button.setOnClickListener(v -> finish());
    }
}
