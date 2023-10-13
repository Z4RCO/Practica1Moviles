package com.example.practica1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class Pregunta1 extends Fragment {

    private RadioGroup grupo;

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

        grupo = view.findViewById(R.id.radioGroup4);
        this.view = view;
        return view;
    }

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