package com.example.diseo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MisDatos extends AppCompatActivity {
    EditText etNombre, etApellido, etFechaNac, etTelefono, etCorreo, etContraseña, etSuledo;
    Button btnVolverD;
    String empleado;
    ConMySql conexion;
    String Nombre,Apellido,FechaNac,Telefono,Correo,Contraseña;
    double Sueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_datos);
        //Declaracion de variables
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etFechaNac = findViewById(R.id.etFechaNac);
        etTelefono = findViewById(R.id.etTelefono);
        etCorreo = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContraseña);
        etSuledo = findViewById(R.id.etSueldo);
        btnVolverD = findViewById(R.id.btnVolverD);

        conexion = new ConMySql();
        //Se obtiene el nombre del empleado
        Bundle extra = getIntent().getExtras();
        empleado = extra.getString("Empleado");

        OperaABM datos = new OperaABM();
        datos.execute("select * from empleados where nombre="+empleado);

        btnVolverD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(getApplicationContext(), MenuPrincipalB.class);
                startActivity(volver);
            }
        });//Termina metodo onClick Volver
    }//Termina onCreate
    public class OperaABM extends AsyncTask<String, String, String> {
        String mensaje = "";
        boolean exito = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String msj) {
            if(exito){
                etNombre.setText(Nombre);
                etApellido.setText(Apellido);
                etFechaNac.setText(FechaNac);
                etTelefono.setText(Telefono);
                etCorreo.setText(Correo);
                etContraseña.setText(Contraseña);
                etSuledo.setText((int) Sueldo);

            }else{
                Toast.makeText(MisDatos.this, msj, Toast.LENGTH_SHORT).show();
            }

        }


        @Override
        protected String doInBackground(String... strings) {
            Connection con = conexion.Conectar();
            if (con != null){
                try {
                    PreparedStatement ps =con.prepareStatement(strings[0]);
                    ps.setString(1,empleado);
                    ResultSet rs = ps.executeQuery();

                    if(rs.next()){
                        exito = true;
                        Nombre = rs.getString("Nombre");
                        Apellido = rs.getString("Apellido");
                        FechaNac = rs.getString("FechaNac");
                        Telefono = rs.getString("Telefono");
                        Correo = rs.getString("Correo");
                        Contraseña = rs.getString("contrasenia");
                        Sueldo = rs.getDouble("Sueldo");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                mensaje= "Error al conectar a la base de datos";
            }

            return mensaje;
        }
    }//Cierre de la clase ABM*/

}//Termina class Mis datos
