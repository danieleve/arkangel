package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class felizformulario extends AppCompatActivity {

    public Button btnenviar, btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felizformulario);

        btnenviar = findViewById(R.id.btnenviar);
        btnguardar = findViewById(R.id.btnguardar);

        btnenviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), sentimientos.class);
                startActivity(intent);

            }
        });

        btnenviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), sentimientos.class);
                startActivity(intent);

            }
        });

    }
}
