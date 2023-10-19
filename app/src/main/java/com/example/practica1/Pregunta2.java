package com.example.practica1;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Pregunta2 extends Fragment {

    /**
     * Referencia a la imagen pulsada
     */
    private ImageView imagen;

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
        View view =  inflater.inflate(R.layout.fragment_pregunta2, container, false);
        this.view = view;

        setOnClick(view.findViewById(R.id.r21));
        setOnClick(view.findViewById(R.id.r22));
        setOnClick(view.findViewById(R.id.r23));
        setOnClick(view.findViewById(R.id.r24));


        return view;
    }

    /**
     * Método que comprueba si la respuesta elegida es correcta.
     * Muestra un popup en función del resultado
     */
    public void comprobarRespuesta() {
        ImageView imagenCorrecta = view.findViewById(R.id.r21);
        if(imagen == null){
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity) getActivity();
            if (a != null) a.incorrecto();
            return;
        }
        if (imagen.equals(imagenCorrecta)) {
            Toast.makeText(getActivity(), "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity) getActivity();
            if (a != null) a.correcto();
        } else {
            Toast.makeText(getActivity(), "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
            PreguntasActivity a = (PreguntasActivity) getActivity();
            if (a != null) a.incorrecto();
        }

    }

    private void setOnClick(ImageView i){
        i.setOnClickListener(view -> pulsarImagen(i));
    }
    public void pulsarImagen(View view) {
        if(imagen != null)imagen.setBackground(null);
        imagen = (ImageView)view;
        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF);  // Color de fondo blanco
        border.setStroke(5, Color.BLACK); // Ancho del borde y color del borde negro
        view.setBackground(border);
        view.setPadding(10, 10, 10, 10);
    }
}