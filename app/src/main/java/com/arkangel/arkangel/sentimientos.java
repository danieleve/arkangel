package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arkangel.arkangel.R;

public class sentimientos extends AppCompatActivity implements View.OnTouchListener {
    private ImageView ruleta;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;

    private TextView txtSentimiento;

    private static final float HALF_SECTOR = 360f / 6f / 2f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentimientos);

        ruleta=(ImageView)findViewById(R.id.ruletaTextoImg);
        ruleta.setOnTouchListener(this);



    }

    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        final float xc = ruleta.getWidth() / 2;
        final float yc = ruleta.getHeight() / 2;

        final float x = event.getX();
        final float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                ruleta.clearAnimation();
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                txtSentimiento=(TextView) findViewById(R.id.txtSentimiento);
                mPrevAngle = mCurrAngle;
                mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                animate(mPrevAngle, mCurrAngle, 0);
                //System.out.println(mCurrAngle);
                if(mCurrAngle <=43 && mCurrAngle>=-14){
                    txtSentimiento.setText("Triste");
                }else if(mCurrAngle <=109 && mCurrAngle>=44){
                    txtSentimiento.setText("Feliz");
                }else if(mCurrAngle <=173 && mCurrAngle>=110){
                    txtSentimiento.setText("Enojado");
                }else if(mCurrAngle <=-126 && mCurrAngle>=-179){
                    txtSentimiento.setText("Aburrido");
                }else if(mCurrAngle <=-70 && mCurrAngle>=-124){
                    txtSentimiento.setText("Emergencia");
                }else if(mCurrAngle <=-16 && mCurrAngle>=-69){
                    txtSentimiento.setText("Nervioso");
                }
                break;
            }
            case MotionEvent.ACTION_UP : {
                //mPrevAngle = mCurrAngle = 0;
                if(mCurrAngle <=43 && mCurrAngle>=-14){
                    Intent intent = new Intent(getBaseContext(), causas.class);
                    startActivity(intent);
                }else if(mCurrAngle <=109 && mCurrAngle>=44){
                    Intent intent = new Intent(getBaseContext(), feliz.class);
                    startActivity(intent);
                }else if(mCurrAngle <=173 && mCurrAngle>=110){
                    Intent intent = new Intent(getBaseContext(), enojado.class);
                    startActivity(intent);
                }else if(mCurrAngle <=-126 && mCurrAngle>=-179){
                    Intent intent = new Intent(getBaseContext(), aburrido.class);
                    startActivity(intent);
                }else if(mCurrAngle <=-70 && mCurrAngle>=-124){
                    Intent intent = new Intent(getBaseContext(), emergencia.class);
                    startActivity(intent);
                }else if(mCurrAngle <=-16 && mCurrAngle>=-69){
                    Intent intent = new Intent(getBaseContext(), nervioso.class);
                    startActivity(intent);
                }
                break;
            }
        }
        return true;
    }

    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        ruleta.startAnimation(rotate);
        //System.out.println(mCurrAngle);
    }
}
