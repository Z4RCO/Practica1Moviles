package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class PreguntasActivity extends AppCompatActivity {
    private int puntos;
    private MediaPlayer musicaQuest;

    private  boolean activo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        musicaQuest = MediaPlayer.create(this, R.raw.wind);
        musicaQuest.setLooping(true);

        Intent intent = getIntent();

        activo = intent.getBooleanExtra("musica",true);


        if(!activo){
            musicaQuest.pause();
        }else{
            musicaQuest.start();
        }

        puntos = 0;
    }

    public void salir(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("puntos", puntos);
        intent.putExtra("musica",activo);
        musicaQuest.pause();

        startActivity(intent);
    }

}