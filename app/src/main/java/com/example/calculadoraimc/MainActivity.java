package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Text_peso;
    private EditText Text_altura;
    private Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text_peso = findViewById(R.id.Text_peso);
        Text_altura = findViewById(R.id.Text_altura);
        btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura los valores de peso y altura ingresados por el usuario
                double peso = Double.parseDouble(Text_peso.getText().toString());
                double altura = Double.parseDouble(Text_altura.getText().toString()) / 100.0; // Convierte a metros

                // Calcula el IMC
                double imc = peso / (altura * altura);

                // Determina la categoría de IMC
                String categoria = "";

                if (imc < 18.5) {
                    categoria = "Bajo peso";
                } else if (imc < 25) {
                    categoria = "Peso normal";
                } else if (imc < 30) {
                    categoria = "Sobrepeso";
                } else if (imc < 35) {
                    categoria = "Obesidad grado I";
                } else if (imc < 40) {
                    categoria = "Obesidad grado II";
                } else {
                    categoria = "Obesidad grado III";
                }

                // Crea un Intent para pasar los datos a Activity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("PESO", peso);
                intent.putExtra("ALTURA", altura);
                intent.putExtra("CATEGORIA", categoria);
                intent.putExtra("IMC", imc); // Agrega el IMC al intent
                startActivity(intent);

            }
        });
    }
}
