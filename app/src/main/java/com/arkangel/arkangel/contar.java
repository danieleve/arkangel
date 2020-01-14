package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arkangel.arkangel.R;

public class contar extends AppCompatActivity {

    public Button btnSi, btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contar);


        btnSi = findViewById(R.id.btnSi);
        btnSi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), sicontarform.class);
                startActivity(intent);
            }
        });

        btnNo = findViewById(R.id.btnNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), nocontar.class);
                startActivity(intent);
            }
        });

    }
}
