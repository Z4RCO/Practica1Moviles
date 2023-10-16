package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer musica;
    private MediaPlayer tucan;
    private boolean activo = true;
    private int silencio = R.drawable.silencio;
    private ImageButton boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Create Main");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        tucan = MediaPlayer.create(this,R.raw.cuervo);
        musica = MediaPlayer.create(this, R.raw.wildquest);
        musica.setLooping(true);

        System.out.println("Start Main");

        Intent intent = getIntent();

        boton = findViewById(R.id.Silenciar);
        if(boton == null) System.out.println("BOTON ES NULL");
        activo = intent.getBooleanExtra("musica", true);
        if(activo){
            musica.start();
        }
        else{
            boton.setImageResource(R.drawable.silencio);
        }

        TextView tv = findViewById(R.id.puntos);
        tv.setText(Integer.toString(intent.getIntExtra("puntos",0)));
    }

    /**
     * Método que comienza la activity de las preguntas
     * Añade al intent la información sobre la reproducción de la música
     * @param view
     */
    public void jugar(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.correcto);
        mp.start();

        Intent intent = new Intent(this, PreguntasActivity.class);
        intent.putExtra("musica",activo);
        if(musica.isPlaying())musica.pause();
        startActivity(intent);

    }

    /**
     * Cierra la Aplicación
     * @param view Referencia a la View que llama al método
     */
    public void salir(View view){
        musica.stop();
        finishAffinity();
    }

    /**
     * Método que reproduce el sonido del tucán
     * @param view Referencia a la view que llama al método
     */
    public void sonidoTucan(View view){
        tucan.start();
    }


    /**
     * Método para alternar la reproducción de la música
     * @param view Referencia a la view que llama al método
     */
    public void cambiarMusica(View view){
        ImageButton boton = (ImageButton) view;
        if(activo){
            if(musica.isPlaying())musica.pause();
            activo = false;
            boton.setImageResource(R.drawable.silencio);
        }
        else{
            if(!musica.isPlaying())musica.start();
            activo = true;
            boton.setImageResource(R.drawable.sonido);
        }
    }

    /**
     * Si pulsas el botón de atrás en el menú se cierra la App
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }






    //TODO Hacer que el boton coincida con el sonido al volver al main

}