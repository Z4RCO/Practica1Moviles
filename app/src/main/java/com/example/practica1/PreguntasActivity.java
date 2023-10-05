package com.example.practica1;

import static com.example.practica1.R.id.next;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class PreguntasActivity extends AppCompatActivity {
    private int puntos;
    private MediaPlayer musicaQuest;

    Pregunta1 p1;
    Pregunta2 p2;


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

       p1 = new Pregunta1();
       p2 = new Pregunta2();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,p1).commit();
    }

    public void next(View view){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        int id = view.getId();
        if(id == R.id.next){
            t.replace(R.id.fragmentContainerView,p2).commit();
        }
    }

    public void salir(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("puntos", puntos);
        intent.putExtra("musica",activo);
        musicaQuest.pause();

        startActivity(intent);
    }

}