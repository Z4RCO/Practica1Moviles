package com.example.practica1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Pregunta1 extends Fragment {

    /**
     * Referencia al RadioGroup del Fragment
     */
    private RadioGroup grupo;

    /**
     * Referencia a la View del Fragment
     */
    private View view;

    public Pregunta1() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta1, container, false);

        grupo = view.findViewById(R.id.radioGroup5);
        this.view = view;
        setRespuestas();


        return view;
    }

    /**
     * Método que comprueba si la respuesta elegida es correcta.
     * Muestra un popup en función del resultado
     */
    public void comprobarRespuesta(){
        RadioButton selectedRadioButton = view.findViewById(grupo.getCheckedRadioButtonId());
        if(selectedRadioButton == null){
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            if(a != null)a.incorrecto();
            return;
        }
        String respuestaSeleccionada = selectedRadioButton.getText().toString();
        String respuestaCorrecta = "Koala";

        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            Toast.makeText(getActivity(),"¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            if(a != null)a.correcto();
        } else {
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            if(a != null)a.incorrecto();
        }

    }

    private void setRespuestas(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this.view.getContext(), "Aplicacion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();



        ContentValues r1 = new ContentValues();
        r1.put("pregunta", "¿Qué ave es conocida por su canto melodioso?");
        r1.put("respuesta1", "Cuervo");
        r1.put("respuesta2", "Gorrión");
        r1.put("respuesta3", "Tucán");
        r1.put("respuesta4", "Ruiseñor");
        r1.put("correcto", 4);
        db.insert("preguntas", null, r1);


        ContentValues r2 = new ContentValues();
        r2.put("pregunta", "¿Cuál de estos animales es venenoso?");
        r2.put("respuesta1", "Sapo");
        r2.put("respuesta2", "Rana");
        r2.put("respuesta3", "Salamandra");
        r2.put("respuesta4", "Tortuga");
        r2.put("correcto", 1);
        db.insert("preguntas", null, r2);

        ContentValues r3 = new ContentValues();
        r3.put("pregunta", "¿Cuál es el animal más rápido del mundo?");
        r3.put("respuesta1", "Guepardo");
        r3.put("respuesta2", "Águila");
        r3.put("respuesta3", "Caballo");
        r3.put("respuesta4", "Liebre");
        r3.put("correcto", 1);
        db.insert("preguntas", null, r3);
//        Cursor preguntas = db.rawQuery("select * from preguntas", null);
//
//
//        Random r = new Random();
//
//        preguntas.moveToPosition(r.nextInt(preguntas.getCount()));
//
//        TextView t = view.findViewById(R.id.p1);
//        t.setText(preguntas.getString(0));
//
//
//        RadioButton respuesta = view.findViewById(R.id.r11);
//        respuesta.setText(preguntas.getString(1));
//        respuesta = view.findViewById(R.id.r12);
//        respuesta.setText(preguntas.getString(2));
//        respuesta = view.findViewById(R.id.r13);
//        respuesta.setText(preguntas.getString(3));
//        respuesta = view.findViewById(R.id.r14);
//        respuesta.setText(preguntas.getString(4));
//
//        preguntas.close();
    }
}