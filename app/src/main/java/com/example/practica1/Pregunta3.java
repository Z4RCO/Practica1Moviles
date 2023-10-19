package com.example.practica1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Pregunta3 extends Fragment {

    /**
     * Referencia al Spinner del Fragment
     */
    private Spinner spinner;



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


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.requireContext(), R.array.tus_elementos, android.R.layout.simple_spinner_item);
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
}