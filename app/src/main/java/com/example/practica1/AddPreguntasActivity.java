package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPreguntasActivity extends AppCompatActivity {
    private EditText pregunta;
    private EditText r1;
    private EditText r2;
    private EditText r3;
    private EditText r4;
    private EditText r5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_preguntas);

        pregunta = findViewById(R.id.etPregunta);
        r1 = findViewById(R.id.etRespuesta1);
        r2 = findViewById(R.id.etRespuesta2);
        r3 = findViewById(R.id.etRespuesta3);
        r4 = findViewById(R.id.etRespuesta4);
        r5 = findViewById(R.id.etRespuesta5);
    }

    public void volver(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent,options.toBundle());
    }

    public void registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Aplicacion", null, 1);
        SQLiteDatabase BdD = admin.getWritableDatabase();

        String textPregunta = pregunta.getText().toString();
        String textR1 = r1.getText().toString();
        String textR2 = r2.getText().toString();
        String textR3 = r3.getText().toString();
        String textR4 = r4.getText().toString();
        String textR5 = r5.getText().toString();


        if(!textPregunta.isEmpty() && !textR1.isEmpty() && !textR2.isEmpty() && !textR3.isEmpty() && !textR4.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("pregunta", textPregunta);
            registro.put("respuesta1", textR1);
            registro.put("respuesta2", textR2);
            registro.put("respuesta3", textR3);
            registro.put("respuesta4", textR4);
            registro.put("correcto", textR5);

            BdD.insert("preguntas", null, registro);

            BdD.close();
            pregunta.setText("");
            r1.setText("");
            r2.setText("");
            r3.setText("");
            r4.setText("");
            r5.setText("");

            Toast.makeText(this,"Pregunta registrada", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
        }
    }
}