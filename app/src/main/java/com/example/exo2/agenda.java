package com.example.exo2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class agenda extends Activity {
    private HashMap<String, List<String>> events;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private int Year;
    private int Month;
    private int Day;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda);
        CalendarView cv = findViewById(R.id.calendar);
        ListView lv = findViewById(R.id.listEvent);
        events = new HashMap<>();
        addEvent(String.valueOf(LocalDate.now()), getString(R.string.Exo9_event1));
        addEvent(String.valueOf(LocalDate.now()), getString(R.string.Exo9_event2));
        addEvent(String.valueOf(LocalDate.now()), getString(R.string.Exo9_event3));
        items = new ArrayList<>();
        List<String> eventsToday = events.get(String.valueOf(LocalDate.now()));
        if(eventsToday != null){
            items.addAll(eventsToday);
            adapter = new ArrayAdapter<>(agenda.this, R.layout.list_item,R.id.listItem, items);
            lv.setAdapter(adapter);
        } else{
            lv.setAdapter(null);
        }
        cv.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Year = year;
            Month = month+1;
            Day = dayOfMonth;
            String date = FormatDate(year,month+1,dayOfMonth);
            Log.d("TEST", date);
            items.clear();
            List<String> eventsToday1 = events.get(date);
            if(eventsToday1 != null){
                items.addAll(eventsToday1);
                adapter = new ArrayAdapter<>(agenda.this, R.layout.list_item,R.id.listItem, items);
                lv.setAdapter(adapter);
            } else{
                lv.setAdapter(null);
            }
        });
        Button bouton = findViewById(R.id.AddEvent);
        bouton.setOnClickListener(v -> showDialog());

    }

    private void showDialog() {
        EditText et = new EditText(this);
        String date = FormatDate(Year,Month,Day);
        et.setHint(R.string.Exo9_titre_dialog);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(date);
        builder.setView(et);
        builder.setPositiveButton("OK", (dialog, which) -> {
            String userInput = et.getText().toString();
            addEvent(date, userInput);
            items.add(userInput);
            adapter.notifyDataSetChanged();
        });
        builder.setNegativeButton(R.string.Exo5_valid_not_button, (dialog, which) -> dialog.cancel());
        builder.show();
    }

    public void addEvent(String date, String event){
        if (!events.containsKey(date)){
            events.put(date, new ArrayList<>());
        }
        Objects.requireNonNull(events.get(date)).add(event);
    }

    public String FormatDate(int year, int month, int day) {
        String days = String.valueOf(day);
        String months = String.valueOf(month);
        if (month < 10) {
            months = "0" + months;
        }
        if (day <10) {
            days = "0" + days;

        }
        return year + "-" + months + "-" + days;
    }
}
