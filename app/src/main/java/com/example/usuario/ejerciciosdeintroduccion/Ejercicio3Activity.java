package com.example.usuario.ejerciciosdeintroduccion;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejercicio3Activity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;
    private Button reiniciar;
    private Button mas;
    private Button menos;
    private Button comenzar;
    private TextView contador;
    private TextView tiempo;
    AlertDialog.Builder popup;
    int contadorCafes = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        mp = MediaPlayer.create(this,R.raw.campana);
        popup=new AlertDialog.Builder(this);
        popup.setTitle("FIN");
        popup.setMessage("Has llegado a 10 cafes, que es el máximo");
        popup.setPositiveButton("Ok", null);
        mas = (Button) findViewById(R.id.btnMas);
        contadorCafes = 0;
        reiniciar = (Button) findViewById(R.id.btnReiniciar);
        menos = (Button)findViewById(R.id.btnMenos);
        comenzar = (Button) findViewById(R.id.btnComenzar);
        contador = (TextView) findViewById(R.id.txvContador);
        tiempo = (TextView) findViewById(R.id.txvTiempo);
        tiempo.setText(String.format("%.2f",0.0));
        mas.setOnClickListener(this);
        menos.setOnClickListener(this);
        comenzar.setOnClickListener(this);
        reiniciar.setOnClickListener(this);
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

            if (Integer.parseInt(contador.getText().toString()) < 10)
            {
                MiContador temporizador = new MiContador((long) medicion * 60 * 1000, (long) 1000.0);
                temporizador.start();
            }
        }
        if (view == reiniciar)
        {
            contadorCafes = 0;
            contador.setText("0");
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
        {
            contador.setText(String.valueOf(++contadorCafes));
            tiempo.setText("0.00");
            mp.start();
            if (contadorCafes == 10)
            {
                popup.show();
            }

        }
    }
}