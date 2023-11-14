package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer musica;
    private MediaPlayer tucan;
    private boolean activo = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Registrar(null);

    }

    @Override
    protected void onStart() {
        super.onStart();
        tucan = MediaPlayer.create(this,R.raw.cuervo);
        musica = MediaPlayer.create(this, R.raw.wildquest);
        musica.setLooping(true);

        Intent intent = getIntent();

        ImageButton boton = findViewById(R.id.Silenciar);
        activo = intent.getBooleanExtra("musica", true);
        if(activo){
            musica.start();
        }
        else{
            boton.setImageResource(R.drawable.silencio);
        }

        TextView tv = findViewById(R.id.puntos);
        int num = intent.getIntExtra("puntos",0);
        tv.setText(String.format(Integer.toString(num)));
    }

    /**
     * Método que comienza la activity de las preguntas
     * Añade al intent la información sobre la reproducción de la música
     * @param view referencia a la view que llama al método
     */
    public void jugar(View view){

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, PreguntasActivity.class);
        intent.putExtra("musica",activo);
        if(musica.isPlaying())musica.pause();
        startActivity(intent, options.toBundle());

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

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Aplicacion", null, 1);
        SQLiteDatabase BdD = admin.getWritableDatabase();

        String pregunta = "¿Qué mamífero pone huevos?";
        String respuesta1= "Lince";
        String respuesta2= "Nutria";
        String respuesta3= "Ornitorrinco";
        String respuesta4= "Panda rojo";

        ContentValues registro = new ContentValues();

        registro.put("pregunta", pregunta);
        registro.put("respuesta1", respuesta1);
        registro.put("respuesta2", respuesta2);
        registro.put("respuesta3", respuesta3);
        registro.put("respuesta4", respuesta4);


        BdD.insert("preguntas", null, registro);
        BdD.close();
    }



}