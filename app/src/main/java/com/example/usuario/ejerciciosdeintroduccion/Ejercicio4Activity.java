package com.example.usuario.ejerciciosdeintroduccion;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio4Activity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNumero;
    Button btnProbar;
    int prueba;
    TextView txvResultado;
    int intentos = 0;
    AlertDialog.Builder popup;
    MediaPlayer mp;
    int numero;
    boolean fin = false;
    Button btnGenerarNumero;
    Toast alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
        edtNumero = (EditText)findViewById(R.id.edtNumero);
        btnProbar = (Button) findViewById(R.id.btnProbar);
        btnProbar.setOnClickListener(this);
        txvResultado = (TextView) findViewById(R.id.txvResultado);
        popup=new AlertDialog.Builder(this);
        popup.setTitle("ENHORABUENA");
        popup.setPositiveButton("Ok", null);
        mp = MediaPlayer.create(this,R.raw.acierto);
        btnGenerarNumero = (Button) findViewById(R.id.btnNuevoNumero);
        btnGenerarNumero.setOnClickListener(this);
        alerta = Toast.makeText(this, "Para jugar de nuevo genera un nuevo número aleatorio", Toast.LENGTH_LONG);
        GenerarNumeroAleatorio();
    }

    @Override
    public void onClick(View v)
    {
        if (v == btnProbar)
        {
            if (fin == false)
            {
                intentos++;
                prueba = Integer.parseInt(String.valueOf(edtNumero.getText().toString()));
                if (prueba > numero) {
                    txvResultado.setText(String.valueOf("Prueba con un número mas pequeño"));
                } else if (prueba < numero) {
                    txvResultado.setText(String.valueOf("Prueba con un número mas grande"));
                } else {
                    txvResultado.setText("Acertaste");
                    mp.start();
                    popup.setMessage("¡Acertaste en " + intentos + " intentos!");
                    popup.show();
                    fin = true;
                }
            }
            else
                {
                    alerta.show();
                }

        }
        if (btnGenerarNumero == v)
        {
            GenerarNumeroAleatorio();
            intentos = 0;
            fin = false;
            txvResultado.setText("");
            edtNumero.setText("");
        }
    }

    public int GenerarNumeroAleatorio()
    {
        numero = (int) Math.floor(Math.random()*101);
        return numero;
    }
}
