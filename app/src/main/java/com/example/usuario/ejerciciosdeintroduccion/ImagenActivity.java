package com.example.usuario.ejerciciosdeintroduccion;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImagenActivity extends AppCompatActivity {

    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        imagen = (ImageView) findViewById(R.id.miAnimal);
        imagen.setImageResource(getIntent().getExtras().getInt("1"));
    }
}
