package com.example.exo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class interface_simple_java extends Activity {
    //Généralisation des paramètres pour les utiliser dans les fonctions
    private LinearLayout layout;
    private EditText name;
    private EditText surname;
    private EditText age;
    private EditText competence;
    private EditText telnum;

    // Fonction à la création de l'activité
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.leftMargin = 20; layoutParams.rightMargin = 20;
        layout.setLayoutParams(layoutParams);

        layout.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(this);
        title.setText(R.string.Exo3_Title);
        layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = 75;layoutParams.bottomMargin = 100;
        layout.setGravity(Gravity.TOP | Gravity.CENTER);
        title.setLayoutParams(layoutParams);
        title.setTextSize(30);
        layout.addView(title);

        LinearLayout tmp = new LinearLayout(this);
        tmp.setOrientation(LinearLayout.HORIZONTAL);
        tmp.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView namelabel = new TextView(this);
        namelabel.setTextSize(20);
        namelabel.setText(R.string.Exo3_Name_input);
        tmp.addView(namelabel);
        name = new EditText(this);
        name.setHint(R.string.Exo3_Name_input);
        name.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tmp.addView(name);
        layout.addView(tmp);

        LinearLayout tmp2 = new LinearLayout(this);
        tmp2.setOrientation(LinearLayout.HORIZONTAL);
        tmp2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView surnamelabel = new TextView(this);
        surnamelabel.setTextSize(20);
        surnamelabel.setText(R.string.Exo3_Surname_input);
        tmp2.addView(surnamelabel);
        surname = new EditText(this);
        surname.setHint((R.string.Exo3_Surname_input));
        surname.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tmp2.addView(surname);
        layout.addView(tmp2);

        LinearLayout tmp3 = new LinearLayout(this);
        tmp3.setOrientation(LinearLayout.HORIZONTAL);
        tmp3.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView agelabel = new TextView(this);
        agelabel.setTextSize(20);
        agelabel.setText(R.string.Exo3_Age_input);
        tmp3.addView(agelabel);
        age = new EditText(this);
        age.setHint((R.string.Exo3_Age_input));
        age.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        age.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        tmp3.addView(age);
        layout.addView(tmp3);

        LinearLayout tmp4 = new LinearLayout(this);
        tmp4.setOrientation(LinearLayout.HORIZONTAL);
        tmp4.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView Competencelabel = new TextView(this);
        Competencelabel.setTextSize(20);
        Competencelabel.setText(R.string.Exo3_Competences_input);
        tmp4.addView(Competencelabel);
        competence = new EditText(this);
        competence.setHint((R.string.Exo3_Competences_input));
        competence.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tmp4.addView(competence);
        layout.addView(tmp4);

        LinearLayout tmp5 = new LinearLayout(this);
        tmp5.setOrientation(LinearLayout.HORIZONTAL);
        tmp5.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView telnumlabel = new TextView(this);
        telnumlabel.setTextSize(20);
        telnumlabel.setText(R.string.Exo3_NumTel_input);
        tmp5.addView(telnumlabel);
        telnum = new EditText(this);
        telnum.setHint((R.string.Exo3_NumTel_input));
        telnum.setInputType(InputType.TYPE_CLASS_PHONE);
        telnum.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tmp5.addView(telnum);
        layout.addView(tmp5);

        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText(R.string.Exo3_validate_input);
        button.setOnClickListener(v -> showDialog());
        layout.addView(button);
        setContentView(layout);

    }
    //Exercice n°5 : changeBackground + showDialog
    private void changeBackground(int color,int color2){
        layout.setBackgroundColor(color);
        name.setBackgroundColor(color2);surname.setBackgroundColor(color2);
        age.setBackgroundColor(color2); competence.setBackgroundColor(color2);
        telnum.setBackgroundColor(color2);
    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.Exo5_valid_button)
            .setMessage(R.string.Exo5_dialog_txt)
            .setPositiveButton(R.string.Exo5_valid_button, (dialog, which) ->{
                changeBackground(Color.TRANSPARENT,Color.LTGRAY);
                Intent intent = new Intent(interface_simple_java.this, intent_explicite.class);
                intent.putExtra("NAME",getName().getText().toString());
                intent.putExtra("SURNAME",getSurname().getText().toString());
                intent.putExtra("AGE",getAge().getText().toString());
                intent.putExtra("COMPETENCE",getCompetence().getText().toString());
                intent.putExtra("NUMTEL",getTelnum().getText().toString());
                startActivity(intent);})
            .setNegativeButton(R.string.Exo5_valid_not_button, (dialog, which) -> changeBackground(Color.WHITE,Color.WHITE))
            .show();
    }

    // Getteurs pour récupérer les différents éléments de l'activité.
    public EditText getName() {return name;}
    public EditText getSurname() {return surname;}
    public EditText getAge() {return age;}

    public EditText getCompetence() {return competence;}

    public EditText getTelnum() {return telnum;}
}
