package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/**Funcionalidad del botón volver, manejo de la musica**/

public class ManualActivity extends AppCompatActivity {
    boolean activo;
    int puntos;
    private MediaPlayer musicaManual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        musicaManual = MediaPlayer.create(this, R.raw.menumusic);

        Intent intent = getIntent();

         puntos = intent.getIntExtra("puntos",0);
         activo = intent.getBooleanExtra("musica",true);

        if(!activo){
            if(musicaManual.isPlaying())musicaManual.pause();
        }else{
            if(!musicaManual.isPlaying())musicaManual.start();
        }
        musicaManual.setLooping(true);

    }

    public void volver(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, MainActivity.class);

        if(musicaManual.isPlaying()){
            musicaManual.pause();
        }


        startActivity(intent,options.toBundle());

        intent.putExtra("puntos", puntos);
        intent.putExtra("musica",activo);


    }
}