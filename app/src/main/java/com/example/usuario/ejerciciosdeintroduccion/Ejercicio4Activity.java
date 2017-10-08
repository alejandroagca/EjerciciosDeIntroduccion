package com.example.usuario.ejerciciosdeintroduccion;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Ejercicio4Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView imagen;
    Button btnElefante;
    Button btnTigre;
    Button btnLeon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
        imagen = (ImageView) findViewById(R.id.imgAnimal);
        btnElefante = (Button)findViewById(R.id.btnElefante);
        btnTigre = (Button) findViewById(R.id.btnTigre);
        btnLeon = (Button)findViewById(R.id.btnLeon);
        btnLeon.setOnClickListener(this);
        btnTigre.setOnClickListener(this);
        btnElefante.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Drawable drawable;
        if (v == btnElefante)
        {
            drawable = this.getResources().getDrawable(R.drawable.elefante);
            imagen.setImageDrawable(drawable);
        }
        if (v == btnTigre)
        {
            drawable = this.getResources().getDrawable(R.drawable.tigre);
            imagen.setImageDrawable(drawable);
        }
        if (v==btnLeon)
        {
            drawable = this.getResources().getDrawable(R.drawable.leon);
            imagen.setImageDrawable(drawable);
        }
    }
}
