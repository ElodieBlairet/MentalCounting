package com.example.mentalcounting.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.mentalcounting.R;

import java.util.Random;

public class gameActivity extends AppCompatActivity {
    EditText text;
    private int premier = 0;
    private String operateur = null;
    private int deuxieme = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

       text = findViewById(R.id.answer_text);
    }

    //Ajoute game_menu à la page gameActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Ouvre la page home et result
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.result_menu_button:
                Intent intentr = new Intent(this, ResultActivity.class);
                startActivity(intentr);
                break;
            case R.id.home_menu_button:
                Intent intenth = new Intent(this, MainActivity.class);
                startActivity(intenth);
                break;
            case R.id.submit_game_button:
                String answer = text.getText().toString();
                Double rep = Double.parseDouble(answer);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}