package com.example.diseo;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConMySql {
    //10.0.2.2 ip para trabajar de manera local con android
    private String ip="192.168.1.119:3307"; // Ip de mi mi maquina o del servidor
    private String bd="liz";
    private String usuarioBD="android";
    private String passBD="android";
    private String url="jdbc:mysql://" + ip + "/"+ bd;


    public Connection Conectar(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,usuarioBD,passBD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }


        return con;
    }
}
