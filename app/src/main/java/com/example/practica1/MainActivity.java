package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer musica;
    private boolean activo = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        musica = MediaPlayer.create(this, R.raw.wildquest);

        musica.setLooping(true);

        Intent intent = getIntent();

        activo = intent.getBooleanExtra("musica",true);


        if(activo){
            musica.start();
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void jugar(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.correcto);
        mp.start();

        Intent intent = new Intent(this, PreguntasActivity.class);
        intent.putExtra("musica",activo);
        musica.pause();
        startActivity(intent);
    }

    public void salir(View view){
        musica.stop();
        finishAffinity();
    }

    public void sonidoTucan(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.cuervo);
        mp.start();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    //TODO Hacer que el boton coincida con el sonido al volver al main

}