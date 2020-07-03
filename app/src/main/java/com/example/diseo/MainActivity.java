package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    EditText Correo, Contraseña;
    Button Iniciar;
    TextView tvBienvenido;
    ProgressBar barInicio;
    ConMySql conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Correo = findViewById(R.id.Correo);
        Contraseña = findViewById(R.id.Contraseña);
        Iniciar = findViewById(R.id.btn_Iniciar);
        barInicio = findViewById(R.id.barInicio);
        tvBienvenido = findViewById(R.id.tvBienvenido);

        barInicio.setVisibility(View.GONE);

        conexion = new ConMySql();

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicioSesion sesion = new inicioSesion();
                sesion.execute("");
            }
        });//Termina onClick iniciar
    }//Termina onCreate

    public class inicioSesion extends AsyncTask<String, String, String> {
        String mensaje = "";
        boolean exito = false;
        String usuario = Correo.getText().toString();
        String pass = Contraseña.getText().toString();


        @Override
        protected void onPreExecute() {
            barInicio.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String msj) {

            barInicio.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, msj, Toast.LENGTH_LONG).show();

            if (exito) {
                Intent iniciar = new Intent(getApplicationContext(), MenuPrincipalB.class);
                startActivity(iniciar);
            }
        }

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {
            Connection con = conexion.Conectar();
            //Preparamos query a la base de datos
            String query = "select * from empleados where Correo=? and Contrasenia=?";
            if (con != null) {
                try {

                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, usuario);
                    ps.setString(2, pass);

                    //ejecutar la instruccion (query) y prepara la respuesta de la base de datos
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        exito = true;
                        mensaje = "Bienvenido: " + rs.getString("nombre");
                        //String Nombre = rs.getString("nombre");
                        Intent datos = new Intent(getApplicationContext(), MenuPrincipalB.class);
                        datos.putExtra("NomEmpleado", rs.getString("nombre"));
                    } else {
                        mensaje = "Usuario o contraseña incorrectos";
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //Cierre de sesión
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                mensaje = "Error al conectar a la base de datos";
            }


            return mensaje;
        }
    }//Termina metodo Iniciar Sesion
}//Termina class ManinActivity
