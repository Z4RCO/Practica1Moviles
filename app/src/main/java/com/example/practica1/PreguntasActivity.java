package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class PreguntasActivity extends AppCompatActivity {
    private int puntos;
    private MediaPlayer musicaQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        musicaQuest = MediaPlayer.create(this, R.raw.aquatic);

        musicaQuest.setLooping(true);
        musicaQuest.start();

        puntos = 0;
    }

    public void salir(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("puntos", puntos);
        musicaQuest.pause();

        startActivity(intent);
    }

}