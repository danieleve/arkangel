package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class feliz extends AppCompatActivity {

    public Button feliz1, feliz2, feliz3, feliz4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feliz);

        feliz1 = findViewById(R.id.feliz1);
        feliz2 = findViewById(R.id.feliz2);
        feliz3 = findViewById(R.id.feliz3);
        feliz4 = findViewById(R.id.feliz4);

        feliz1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), felizformulario.class);
                startActivity(intent);
            }
        });

        feliz2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), felizformulario.class);
                startActivity(intent);
            }
        });

        feliz3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), felizformulario.class);
                startActivity(intent);
            }
        });

        feliz4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), felizformulario.class);
                startActivity(intent);
            }
        });
    }
}
