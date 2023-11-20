package com.example.practica1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;


public class PreguntasActivity extends AppCompatActivity {

    /**
     * Contador de puntos obtenidos
     */
    private int puntos;

    /**
     * Reproductor de musica
     */
    private MediaPlayer musicaQuest;

    /*
     * Referencias a las preguntas
     */
    private Pregunta1 p1;
    private Pregunta2 p2;
    private Pregunta3 p3;
    private Pregunta4 p4;
    private Pregunta5 p5;


    /**
     * Contador de preguntas respondidas
     */
    private int respuestas;


    /**
     * Booleano para controlar la música
     */
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

    /**
     * Método que cambia el Fragment mostrado por el de la siguiente pregunta.
     * si estás en la última pregunta, vuelve al menú
     * @param view referencia a la view que llama a método
     */
    public void next(View view){
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        respuestas++;
        switch(respuestas){
            case 1:
                p1.comprobarRespuesta();
                t.replace(R.id.fragmentContainerView,p2).commit();
                break;
            case 2:
                p2.comprobarRespuesta();
                t.replace(R.id.fragmentContainerView,p3).commit();
                break;
            case 3:
                p3.comprobarRespuesta();
                t.replace(R.id.fragmentContainerView,p4).commit();
                break;
            case 4:
                p4.comprobarRespuesta();
                t.replace(R.id.fragmentContainerView,p5).commit();
                break;
            default:
                p5.comprobarRespuesta();
                volver(null);
        }


    }


    /**
     * Método que vuelve a la Main Activity
     * Añade al intent información de puntos obtenidos, y reproducción de música
     * @param view referencia a la view que llama al métoo
     */
    public void volver(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("puntos", puntos);
        intent.putExtra("musica",activo);
       if(musicaQuest.isPlaying()){
           musicaQuest.pause();
       }
        startActivity(intent,options.toBundle());
    }

    /**
     * Método que suma 3 puntos a los actuales
     * Llamar cuando se acierta acierta una pregunta
     */
    public void correcto(){
        puntos += 3;
        MediaPlayer mp = MediaPlayer.create(this,R.raw.correcto);
        mp.start();
    }

    /**
     * Método que resta 2 puntos a los actuales
     * Llamar cuando se acierta acierta una pregunta
     */
    public void incorrecto(){
        puntos -= 2;
        MediaPlayer mp = MediaPlayer.create(this,R.raw.incorrecto);
        mp.start();


    }





}