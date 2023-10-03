package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer musica;
    private boolean activo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        musica = MediaPlayer.create(this, R.raw.gunshot);
        musica.setLooping(true);
        musica.start();
        activo = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void jugar(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.correcto);
        mp.start();

        Intent intent = new Intent(this, PreguntasActivity.class);
        startActivity(intent);
    }

    public void cambiarMusica(View view){
        ImageButton boton = (ImageButton) view;
        if(activo){
            musica.pause();
            activo = false;
            boton.setImageResource(R.drawable.silencio);


        }
        else{
            musica.start();
            activo = true;
            boton.setImageResource(R.drawable.sonido);

        }
    }

    //TODO Parar música cuando cambie la Activity

}