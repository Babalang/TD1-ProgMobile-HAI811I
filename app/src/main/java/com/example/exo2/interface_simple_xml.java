package	com.example.exo2;
import	android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import	android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class interface_simple_xml extends Activity	{
    @Override
    public void onCreate(Bundle	savedInstanceState)	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface_simple_xml);
        Button button = findViewById(R.id.mainbutton);
        button.setOnClickListener(v -> showDialog());
    }
    //Exercice n°5 : changeBackground + showDialog
    private void changeBackground(int color,int color2){
        LinearLayout layout = findViewById(R.id.layout);
        EditText name = findViewById(R.id.edit_Name);
        EditText surname = findViewById(R.id.edit_Surname);
        EditText age = findViewById(R.id.edit_Age);
        EditText competence = findViewById(R.id.edit_Competence);
        EditText telnum = findViewById(R.id.edit_NumTel);
        layout.setBackgroundColor(color);
        name.setBackgroundColor(color2);surname.setBackgroundColor(color2);
        age.setBackgroundColor(color2); competence.setBackgroundColor(color2);
        telnum.setBackgroundColor(color2);
    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        EditText name = findViewById(R.id.edit_Name);
        EditText surname = findViewById(R.id.edit_Surname);
        EditText age = findViewById(R.id.edit_Age);
        EditText competence = findViewById(R.id.edit_Competence);
        EditText telnum = findViewById(R.id.edit_NumTel);
        builder.setTitle(R.string.Exo5_valid_button)
                .setMessage(R.string.Exo5_dialog_txt)
                .setPositiveButton(R.string.Exo5_valid_button, (dialog, which) ->{
                    changeBackground(Color.TRANSPARENT,Color.LTGRAY);
                    Intent intent = new Intent(interface_simple_xml.this, intent_explicite.class);
                    intent.putExtra("NAME",name.getText().toString());
                    intent.putExtra("SURNAME",surname.getText().toString());
                    intent.putExtra("AGE",age.getText().toString());
                    intent.putExtra("COMPETENCE",competence.getText().toString());
                    intent.putExtra("NUMTEL",telnum.getText().toString());
                    startActivity(intent);})
                .setNegativeButton(R.string.Exo5_valid_not_button, (dialog, which) -> changeBackground(Color.WHITE,Color.WHITE))
                .show();
    }
}