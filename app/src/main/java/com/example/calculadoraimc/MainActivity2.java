package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Recupera la categoría, el IMC y la altura desde el Intent
        String categoria = getIntent().getStringExtra("CATEGORIA");
        double imc = getIntent().getDoubleExtra("IMC", 0);
        // Encuentra los TextView y ImageView donde deseas mostrar el resultado y la imagen
        TextView textResultado = findViewById(R.id.text_resultado);
        ImageView imageCategoria = findViewById(R.id.image_categoria);
        TextView textConsejo = findViewById(R.id.text_consejo);

        // Formatea el IMC para mostrarlo con un máximo de 2 decimales
        String resultadoFormateado = String.format("%.2f", imc);

        // Asigna el IMC formateado al TextView
        textResultado.setText("Tu IMC es: " + resultadoFormateado);

        // Asigna la categoría al TextView de categoría
        textConsejo.setText(obtenerConsejoSegunCategoria(categoria));

        // Determina la imagen según la categoría y asígnala a la ImageView
        int idImagen = obtenerIdImagenSegunCategoria(categoria);
        if (idImagen != 0) {
            imageCategoria.setImageResource(idImagen);
        }
    }

    private String obtenerConsejoSegunCategoria(String categoria) {
        switch (categoria) {
            case "Bajo peso":
                return "Puedes consultar a un profesional de la salud para evaluar tu situación.\n" +
                        "Come con más frecuencia. \n" +
                        "Empieza poco a poco a hacer de 5 a 6 comidas más pequeñas durante el día.\n" +
                        "Elige alimentos con muchos nutrientes.\n" +
                        "Haz ejercicio.";

            case "Peso normal":
                return "Mantén un estilo de vida saludable con una dieta equilibrada y ejercicio regular.\n " +
                        "Bebe suficiente agua durante el día para mantenerte bien hidratado.\n " +
                        "Presta atención a las porciones de alimentos que consumes.\n" +
                        "Si tienes un peso normal, el objetivo principal es mantenerlo estable a lo largo del tiempo. Evita las dietas extremadamente restrictivas o los cambios drásticos en tu estilo de vida.";

            case "Sobrepeso":
                return "Considera una dieta equilibrada y aumenta la actividad física para perder peso.\n" +
                        "Antes de comenzar cualquier programa de pérdida de peso, es importante hablar con un médico.\n " +
                        "Elabora un plan de comidas equilibrado que incluya porciones adecuadas de alimentos saludables.\n" +
                        "Aumenta tu consumo de frutas y verduras frescas.\n" +
                        "Reduce la ingesta de alimentos procesados, azúcares refinados y grasas saturadas.";

            case "Obesidad grado I":
                return "Es importante buscar la ayuda de un profesional de la salud para controlar tu peso.\n" +
                        "Define metas de pérdida de peso que sean alcanzables y sostenibles a largo plazo.\n" +
                        "Elabora un plan de comidas equilibrado que incluya porciones adecuadas de alimentos saludables.\n " +
                        "Reduce la ingesta de alimentos procesados, azúcares refinados y grasas saturadas. ";

            case "Obesidad grado II":
                return "Consulta a un profesional de la salud para recibir orientación y apoyo.\n" +
                        "Realiza un seguimiento regular de tu pérdida de peso y ajusta tu plan según sea necesario.\n" +
                        "El sueño adecuado es fundamental para el control del peso.\n" +
                        "Busca el apoyo de amigos, familiares o un grupo de apoyo para mantener la motivación y recibir orientación.";

            case "Obesidad grado III":
                return "Es fundamental buscar asesoramiento médico y tomar medidas para mejorar tu salud.\n" +
                        "Elabora un plan de comidas saludables y equilibradas que incluya porciones adecuadas de alimentos nutritivos.\n" +
                        "Trabaja con un profesional del ejercicio para diseñar un programa de ejercicios adaptado a tus necesidades y capacidad física.\n " +
                        "Lleva un registro detallado de tus comidas, actividades y emociones relacionadas con la comida.";

            default:
                return "No se encontraron consejos para esta categoría.";
        }
    }

    private int obtenerIdImagenSegunCategoria(String categoria) {
        switch (categoria) {
            case "Bajo peso":
                return R.drawable.hombre_delgado;

            case "Peso normal":
                return R.drawable.hombre_sano;

            case "Sobrepeso":
                return R.drawable.hombre_obeso;

            case "Obesidad grado I":
                return R.drawable.hombre_obeso;

            case "Obesidad grado II":
                return R.drawable.hombre_obeso;

            case "Obesidad grado III":
                return R.drawable.hombre_obeso;

            default:
                return 0;
        }
    }
}