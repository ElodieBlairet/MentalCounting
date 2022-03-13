package com.example.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.mentalcounting.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gameButton = findViewById(R.id.game_button);
        Button previousButton = findViewById(R.id.main_result_button);

        gameButton.setOnClickListener(view -> opengameActivity());
        previousButton.setOnClickListener(view -> openResultActivity());
    }
    //ouvre la page game
    private void opengameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    //ouvre la page result
    private void openResultActivity(){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}