package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arkangel.arkangel.R;

public class causas extends AppCompatActivity {

    public Button btnFamilia, btnAmigos, btnPareja, btnEscuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causas);

        btnAmigos = findViewById(R.id.btnAmigos);
        btnFamilia = findViewById(R.id.btnFamilia);
        btnPareja = findViewById(R.id.btnPareja);
        btnEscuela = findViewById(R.id.btnEscuela);

        btnAmigos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), contar.class);
                startActivity(intent);
            }
        });

        btnFamilia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), contar.class);
                startActivity(intent);
            }
        });

        btnPareja.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), contar.class);
                startActivity(intent);
            }
        });

        btnEscuela.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), contar.class);
                startActivity(intent);
            }
        });
    }
}
