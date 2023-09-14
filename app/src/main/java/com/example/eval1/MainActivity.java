package com.example.eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //Declarar atributos:

    //Progress Bar al Buscar:
    private Button buttonBuscar;
    private Button buttonComprar;
    private ProgressBar progressBar;
    private int contador;


    //Usar o no filtro de checkbox, activar con Toggle
    private ToggleButton toggleFiltrar;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    //Mostrar Para quién lleva -> RadioButton
    private RadioButton rb1, rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ATRIBUTOS:
        //Progress Bar al Buscar:
        buttonBuscar = (Button) findViewById(R.id.buttonBuscar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Usar o no filtro de checkbox, activar con Toggle
        toggleFiltrar = (ToggleButton) findViewById(R.id.toggleFiltrar);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        //Mostrar Para quién lleva -> RadioButton
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);

        //boton Comprar, new activity
        buttonComprar = (Button) findViewById(R.id.buttonComprar);
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this, compraActivity.class);
                startActivity(i);
            }
        });

        //Ejecutar:
        EjecutarBusqueda();
        FiltrarBusqueda();
        comprobarRb1();
        comprobarRb2();
    }//MAIN = Dentro de esto NO VAN LOS MÉTODOS, sólo ejecución



    //MÉTODOS
    //Ejecutar Busqueda -> Button Buscar y progressBar;
    public void EjecutarBusqueda(){
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        contador++;
                        progressBar.setProgress(contador);

                        if (contador == 100) {
                            t.cancel();
                        }
                    }
                };
                t.schedule(tt, 0, 100);
            }
        });
    }

    //Filtrar Busqueda -> 3CheckBoxes y Toggle
    public void FiltrarBusqueda(){
        toggleFiltrar.setTextOff("No Filtrar");
        toggleFiltrar.setTextOn("Filtrar");
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);


        toggleFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleFiltrar.isChecked()){
                    checkBox1.setEnabled(true);
                    checkBox2.setEnabled(true);
                    checkBox3.setEnabled(true);
                }else {
                    checkBox1.setEnabled(false);
                    checkBox2.setEnabled(false);
                    checkBox3.setEnabled(false);
                }
            }
        });
    }

    // Comprobar para quien está llevando el producto, uso rb1 y rb2
    public void comprobarRb1(){
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb1.getText().toString();
                Toast.makeText(MainActivity.this, "Está llevando: "+tipo, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void comprobarRb2(){
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo = rb2.getText().toString();
                Toast.makeText(MainActivity.this, "Está llevando: "+tipo, Toast.LENGTH_LONG).show();
            }
        });
    }


}