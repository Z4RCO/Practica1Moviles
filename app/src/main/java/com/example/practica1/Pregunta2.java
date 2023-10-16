package com.example.practica1;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class Pregunta2 extends Fragment {

    /**
     * Referencia al RadioGroup del Fragment
     */
    private RadioGroup grupo;

    /**
     * Referencia a la View del Fragment
     */
    private View view;

    public Pregunta2() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta2, container, false);
        this.view = view;

        ImageView i = view.findViewById(R.id.r21);
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);  // Color de fondo blanco
        border.setStroke(5, Color.BLACK); // Ancho del borde y color del borde negro
        i.setBackground(border);
        i.setPadding(10, 10, 10, 10);
        return view;
    }

    /**
     * Método que comprueba si la respuesta elegida es correcta.
     * Muestra un popup en función del resultado
     */
    public void comprobarRespuesta(){
        RadioButton selectedRadioButton = view.findViewById(grupo.getCheckedRadioButtonId());
        String respuestaSeleccionada = selectedRadioButton.getText().toString();
        String respuestaCorrecta = "Koala";

        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            Toast.makeText(getActivity(),"¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            a.sumar();
        } else {
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            a.restar();
        }

    }
}