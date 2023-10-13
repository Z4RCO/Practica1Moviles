package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class PreguntasActivity extends AppCompatActivity {
    private int puntos;
    private MediaPlayer musicaQuest;

    private Pregunta1 p1;
    private Pregunta2 p2;
    private Pregunta3 p3;
    private Pregunta4 p4;
    private Pregunta5 p5;
    private int respuestas;


    private  boolean activo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        musicaQuest = MediaPlayer.create(this, R.raw.wind);


        Intent intent = getIntent();

        activo = intent.getBooleanExtra("musica",true);


        if(!activo){
            if(musicaQuest.isPlaying())musicaQuest.pause();
        }else{
            if(!musicaQuest.isPlaying())musicaQuest.start();
        }
        musicaQuest.setLooping(true);

        puntos = 0;

       p1 = new Pregunta1();
       p2 = new Pregunta2();
       p3 = new Pregunta3();
       p4 = new Pregunta4();
       p5 = new Pregunta5();
       getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,p1).commit();
    }

    public void next(View view){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        Button b = findViewById(R.id.nextButton);
        respuestas++;
        switch(respuestas){
            case 1:
                p1.comprobarRespuesta();
                t.replace(R.id.fragmentContainerView,p2).commit();
                break;
            case 2:
                t.replace(R.id.fragmentContainerView,p3).commit();
                break;
            case 3:
                t.replace(R.id.fragmentContainerView,p4).commit();
                break;
            case 4:
                p4.comprobarRespuesta();
                t.replace(R.id.fragmentContainerView,p5).commit();
                break;
        }


    }


    public void volver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("puntos", puntos);
        intent.putExtra("musica",activo);
       if(musicaQuest.isPlaying())musicaQuest.pause();
       intent.putExtra("puntos",puntos);

        startActivity(intent);
    }

    public void sumar(){
        puntos += 3;
    }

    public void restar(){
        puntos -= 2;
    }

}