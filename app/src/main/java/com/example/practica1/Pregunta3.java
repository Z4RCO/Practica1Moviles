package com.example.practica1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pregunta3 extends Fragment {

    /**
     * Referencia al Spinner del Fragment
     */
    private Spinner spinner;

    List<String> respuestas = new ArrayList<>();





    public Pregunta3() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta3, container, false);
        this.spinner = view.findViewById(R.id.spinner);

        setRespuestas(view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.requireContext(), android.R.layout.simple_spinner_item, respuestas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        return view;
    }

    /**
     * Método que comprueba si la respuesta elegida es correcta.
     * Muestra un popup en función del resultado
     */
    public void comprobarRespuesta(){
        String respuestaSeleccionada = (String)spinner.getSelectedItem();
        if(respuestaSeleccionada == null){
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            if(a != null)a.incorrecto();
            return;
        }

        String respuestaCorrecta = "Ruiseñor";

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

    private void setRespuestas(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "Aplicacion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor preguntas = db.rawQuery("select * from preguntas", null);

        Random r = new Random();
        preguntas.moveToPosition(r.nextInt(preguntas.getCount()));

        TextView t = view.findViewById(R.id.p3);
        t.setText(preguntas.getString(0));

        respuestas.add(preguntas.getString(1));
        respuestas.add(preguntas.getString(2));
        respuestas.add(preguntas.getString(3));
        respuestas.add(preguntas.getString(4));

        preguntas.close();
    }
}