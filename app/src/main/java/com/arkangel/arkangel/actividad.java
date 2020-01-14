package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actividad extends AppCompatActivity {

    private Button hecho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);

        hecho = findViewById(R.id.hecho);

        hecho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), sentimientos.class);
                startActivity(intent);

            }
        });

    }
}
