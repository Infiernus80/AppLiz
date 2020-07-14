package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuPrincipalB extends AppCompatActivity {
    ImageButton misDatos, menuProductos;
    TextView tvBienvenido;
    String Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_b);

        tvBienvenido = findViewById(R.id.tvBienvenido);
        misDatos = findViewById(R.id.ibtnDatos);
        menuProductos = findViewById(R.id.ibtnProductos);
        Bundle extra = getIntent().getExtras();
        Nombre = extra.getString("NomEmpleado");

        tvBienvenido.setText("BIENVENIDO: "+Nombre);

        misDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos = new Intent(getApplicationContext(), MisDatos.class);
                datos.putExtra("Empleado",Nombre);
                startActivity(datos);
            }
        });//Termina OnClick de Mis datos

        menuProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productos = new Intent(getApplicationContext(), menu.class);
                startActivity(productos);
            }
        });//Termina OnClick de Productos


    }
}
