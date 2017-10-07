package com.example.usuario.ejerciciosdeintroduccion;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEjercicio1;
    private Button btnEjercicio2;
    private Button btnEjercicio3;
    private Button btnEjercicio4;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEjercicio1 = (Button)findViewById(R.id.btnEjercicio1);
        btnEjercicio2 = (Button) findViewById(R.id.btnEjercicio2);
        btnEjercicio3 = (Button)findViewById(R.id.btnEjercicio3);
        btnEjercicio4 = (Button) findViewById(R.id.btnEjercicio4);
        btnEjercicio1.setOnClickListener(this);
        btnEjercicio2.setOnClickListener(this);
        btnEjercicio3.setOnClickListener(this);
        btnEjercicio4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnEjercicio1)
        {
            intent = new Intent(this, Ejercicio1Activity.class);
            startActivity(intent);
        }
        if (view == btnEjercicio2)
        {
            intent = new Intent(this, Ejercicio2Activity.class);
            startActivity(intent);
        }
        if (view == btnEjercicio3)
        {
            intent = new Intent(this, Ejercicio3Activity.class);
            startActivity(intent);
        }
        if (view == btnEjercicio4)
        {
            intent = new Intent(this, Ejercicio4Activity.class);
            startActivity(intent);
        }
    }
}
