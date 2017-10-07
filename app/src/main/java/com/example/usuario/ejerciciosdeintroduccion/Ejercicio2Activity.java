package com.example.usuario.ejerciciosdeintroduccion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ejercicio2Activity extends AppCompatActivity implements View.OnClickListener{

    EditText edtURL;
    Button btnIr;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        edtURL = (EditText)findViewById(R.id.edtURL);
        btnIr = (Button) findViewById(R.id.btnIr);
        btnIr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == btnIr)
        {
            intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url",edtURL.getText().toString());
            startActivity(intent);
        }
    }
}
