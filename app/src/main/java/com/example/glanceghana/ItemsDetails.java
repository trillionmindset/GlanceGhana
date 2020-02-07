package com.example.glanceghana;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.glanceghana.R.layout.activity_items_details;

public class ItemsDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_items_details);



        ImageView imageDetails = findViewById(R.id.imageDetails);
        TextView textDetailsShort = findViewById(R.id.textDetailsShort);
        TextView textDetailsLong = findViewById(R.id.textDetailsLong);

         Intent intent = getIntent();
        imageDetails.setImageResource(intent.getIntExtra("imageDescription", R.drawable.cover));
        textDetailsShort.setText(intent.getStringExtra("shortDescription"));
        textDetailsLong.setText(intent.getStringExtra("longDescription"));

    }
}
