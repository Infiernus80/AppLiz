package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Correo,Contraseña;
    private Button Iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Correo = (EditText) findViewById(R.id.Correo);
        Contraseña = (EditText) findViewById(R.id.Contraseña);
        Iniciar = (Button) findViewById(R.id.btn_Iniciar);

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Correo.getText().toString().equals("Bodega") && Contraseña.getText().toString().equals("Root")){
                    Intent intent = new Intent(v.getContext(),MenuPrincipalB.class);
                    startActivity(intent);

                }




            }
        });

    }
}
