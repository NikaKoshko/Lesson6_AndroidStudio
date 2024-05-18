package ru.mirea.lukanina.task6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText group, number, movie;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.group);
        number = findViewById(R.id.number);
        movie = findViewById(R.id.movie);

        sharedPref = getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);

        String groupSave = sharedPref.getString("GROUP ", "unknown");
        int numberSave = sharedPref.getInt("NUMBER ", 0);
        String movieSave = sharedPref.getString("MOVIE ", "unknown");

        if(!groupSave.equals("unknown"))
        {
            group.setText(groupSave);
        }

        if(numberSave != 0)
        {
            number.setText(String.valueOf(numberSave));
        }

        if(!movieSave.equals("unknown"))
        {
            movie.setText(movieSave);
        }
    }

    public void OnButtonClick(View view)
    {
        SharedPreferences.Editor editor	= sharedPref.edit();

        String groupString = group.getText().toString();
        editor.putString("GROUP", groupString);

        String numberString = number.getText().toString();
        try {
            int number = Integer.parseInt(numberString);
            editor.putInt("NUMBER", number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String movieString = movie.getText().toString();
        editor.putString("MOVIE", movieString);

        editor.apply();
    }
}