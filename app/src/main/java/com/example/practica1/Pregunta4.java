package com.example.practica1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Pregunta4 extends Fragment {

    /**
     * Referencia al RadioGroup del Fragment
     */
    private RadioGroup grupo;

    /**
     * Referencia a la View del Fragment
     */
    private View view;

    /**
     * Referencia a la Activity
     */
    private PreguntasActivity activity;

    public Pregunta4() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pregunta4, container, false);

        grupo = view.findViewById(R.id.radioGroup5);
        this.view = view;
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
        String respuestaCorrecta = "Ballena azul";


        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            Toast.makeText(getActivity(),"¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            a.correcto();
        } else {
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity)getActivity();
            a.incorrecto();
        }

    }
}