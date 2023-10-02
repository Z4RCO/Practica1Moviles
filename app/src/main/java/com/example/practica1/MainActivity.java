package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

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
        if(activo){
            musica.pause();
            activo = false;
        }
        else{
            musica.start();
            activo = true;
        }
    }

    //TODO Parar música cuando cambie la Activity

}