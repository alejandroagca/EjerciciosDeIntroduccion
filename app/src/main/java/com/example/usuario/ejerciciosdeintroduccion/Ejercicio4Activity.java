package com.example.usuario.ejerciciosdeintroduccion;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

    Button btnElefante;
    Button btnTigre;
    Button btnLeon;
    Intent intent;
    Bundle bundle;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);
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
        bundle = new Bundle();
        if (v == btnElefante)
        {
            bundle.putInt("1",R.drawable.elefante);
            intent = new Intent(this, ImagenActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if (v == btnTigre)
        {
            bundle.putInt("1",R.drawable.tigre);
            intent = new Intent(this, ImagenActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if (v==btnLeon)
        {
            bundle.putInt("1",R.drawable.leon);
            intent = new Intent(this, ImagenActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
