package com.example.exo2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class applitrain extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applitrain);
        Button Mybutton = findViewById(R.id.TrainButton);
        Mybutton.setOnClickListener(v -> {
            ListView lv = findViewById(R.id.listTrain);
            String depart = ((EditText) findViewById(R.id.Depart)).getText().toString();
            String arrivee = ((EditText) findViewById(R.id.Arrivee)).getText().toString();
            ArrayList<String> items = new ArrayList<>();
            Integer[] tab = new Integer[30];
            for (int i = 0; i < 30; i++){
                tab[i] = (int)(Math.random()*1000);
            }
            Arrays.sort(tab);
            for (int i = 0; i < 30; i++){

                items.add((depart + " -> " + arrivee + " : " + FormatHeure(tab[i])));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(applitrain.this, R.layout.list_item,R.id.listItem, items);
            lv.setAdapter(adapter);
        });

    }


    public String FormatHeure(int i){
        int heure = (i/60)%24;
        i = i-heure*60;
        int minute = i % 60;
        if (heure < 10){
            if (minute < 10){
                return "0" + heure + ":0" + minute;
            }
            return "0" + heure + ":" + minute;
        }
        if (minute < 10){
            return heure + ":0" + minute;
        }
        return heure + ":" + minute;
    }
}
