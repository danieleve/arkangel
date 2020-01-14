package com.arkangel.arkangel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class login extends AppCompatActivity  {

    private Button iniciar;
    private EditText correo;
    public static TextView correo2;
    private EditText contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        iniciar = findViewById(R.id.iniciar);
        correo = findViewById(R.id.correo);
        correo2 = findViewById(R.id.correo2);
        contrasena = findViewById(R.id.contrasena);


        iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                login();

            }
        });

    }

    public void login() {
        if (correo.getText().toString().equals("admin") && contrasena.getText().toString().equals("admin")) {

            Intent intent = new Intent(getBaseContext(), sentimientos.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Correo o contraseña incorrecta ", Toast.LENGTH_SHORT).show();
        }
    }

    public class fetchData extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            try {

                HttpClient httpClient = new DefaultHttpClient();

                HttpPost httpPst = new HttpPost(

                        "http://arkangelapp.herokuapp.com/users/login");

                ArrayList<NameValuePair> parameters = new ArrayList<NameValuePair>(

                        2);

                parameters.add(new BasicNameValuePair("email", "nikyobandov@gmail.com"));

                parameters.add(new BasicNameValuePair("password", "nmov"));

                httpPst.setEntity(new UrlEncodedFormEntity(parameters));

                HttpResponse httpRes = httpClient.execute(httpPst);

                String str = convertStreamToString(
                        httpRes.getEntity().getContent()).toString();

                Log.i("mlog", "outfromurl" + str);

            } catch (UnsupportedEncodingException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            } catch (ClientProtocolException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            } catch (IOException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

            return null;

        }

        public String convertStreamToString(InputStream is) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringBuilder sb = new StringBuilder();

            String line = null;

            try {

                while ((line = reader.readLine()) != null) {

                    sb.append(line + "\n");

                }

            } catch (Exception e) {

                e.printStackTrace();

            } finally {

                try {

                    is.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            return sb.toString();

        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if(result.equals("working")){
                Toast.makeText(getApplicationContext(), "working...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Invalid POST request...", Toast.LENGTH_LONG).show();
            }

        }
    }

}
