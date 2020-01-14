package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class aburrido extends AppCompatActivity {

    private ImageView blink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aburrido);

        blink = findViewById(R.id.tap);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(blink, "scaleX", 0.7f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(blink, "scaleY", 0.7f);
        scaleDownX.setDuration(1000);
        scaleDownY.setDuration(1000);

        AnimatorSet scaleDown = new AnimatorSet();
        AnimatorSet moveUp = new AnimatorSet();

        scaleDown.play(scaleDownX).with(scaleDownY);

        scaleDownX.setRepeatCount(Animation.INFINITE);
        scaleDownY.setRepeatCount(Animation.INFINITE);

        scaleDown.start();
        moveUp.start();

        blink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), actividad.class);
                startActivity(intent);

            }
        });

    }
}
