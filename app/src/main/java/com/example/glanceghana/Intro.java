package com.example.glanceghana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Intro extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tourGhana();

            }

        });
    }

    private void tourGhana() {
    }


    public void tourGhana(View view) {
        Intent intent;
        intent = new Intent(Intro.this, MainActivity.class);
        startActivity(intent);
    }
}

