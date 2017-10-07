package com.example.usuario.ejerciciosdeintroduccion;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejercicio3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mas;
    private Button menos;
    private Button comenzar;
    private TextView contador;
    private TextView tiempo;
    int contadorCafes = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mas = (Button) findViewById(R.id.btnMas);
        menos = (Button)findViewById(R.id.btnMenos);
        comenzar = (Button) findViewById(R.id.btnComenzar);
        contador = (TextView) findViewById(R.id.txvContador);
        tiempo = (TextView) findViewById(R.id.txvTiempo);
        tiempo.setText(String.format("%.2f",0.0));
        mas.setOnClickListener(this);
        menos.setOnClickListener(this);
        comenzar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        double medicion = Double.parseDouble(tiempo.getText().toString());
        if (view == mas)
        {
            if (medicion < 10) {
                tiempo.setText(String.format("%.2f", ++medicion));
            }
        }

        if (view == menos)
        {
            if (medicion > 0)
                tiempo.setText(String.format("%.2f", --medicion));
        }

        if (view == comenzar)
        {
            MiContador temporizador = new MiContador((long) medicion * 60 * 1000, (long)1000.0);
            temporizador.start();
        }
    }

    public class MiContador extends CountDownTimer {
        public MiContador(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long minutos = (millisUntilFinished/1000) / 60;
            long segundos = (millisUntilFinished/1000) % 60;
            tiempo.setText(minutos + "." + segundos);
        }

        @Override
        public void onFinish()
        {contador.setText(String.valueOf(++contadorCafes));
            tiempo.setText("0.00");
        }
    }
}