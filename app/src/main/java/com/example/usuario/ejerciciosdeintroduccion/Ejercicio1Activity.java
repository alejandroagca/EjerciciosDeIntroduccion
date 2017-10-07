package com.example.usuario.ejerciciosdeintroduccion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Ejercicio1Activity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbtDaE;
    Button convertir;
    EditText etDolares;
    EditText etEuros;
    EditText edtConversion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        rbtDaE = (RadioButton) findViewById(R.id.radioButtonDaE);
        etDolares = (EditText) findViewById(R.id.editTextDolares);
        etEuros = (EditText) findViewById(R.id.editTextEuros);
        edtConversion = (EditText)findViewById(R.id.edtValorConversion);
        convertir = (Button) findViewById(R.id.buttonConvertir);
        convertir.setOnClickListener(this);
    }

        public String Convertir(String cantidad)
        {
            double calculo;
            double cambioAEuros = 0;
            try
            {
                cambioAEuros = Double.parseDouble(edtConversion.getText().toString());
            }
            catch (NumberFormatException e)
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Has introducido un valor no válido",Toast.LENGTH_SHORT);
                toast.show();
            }
            double cambioADolares = 1/cambioAEuros;
            if (rbtDaE.isChecked())
            {
                calculo = (Double.parseDouble(cantidad)*cambioAEuros);
            }
            else
            {
                calculo =(Double.parseDouble(cantidad)*cambioADolares);
            }

            return String.format("%.2f",calculo);
        }

        public void onClick(View view)
        {
            try {
                if (view == convertir)
                {
                    if (rbtDaE.isChecked())
                    {
                        etEuros.setText(Convertir(etDolares.getText().toString()));
                    }
                    else
                    {
                        etDolares.setText(Convertir(etEuros.getText().toString()));
                    }
                }
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), "Has introducido un valor no válido",Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }

