package com.example.diseo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MenuModificar extends AppCompatActivity {
    Button btn_EscanearMd;
    EditText etCodigoMd,etNombreMd,etFechaCaduMd,etPrecioMd,etCategoriaMd,etExistenciaMd,etDescripcionMd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_modificar);

        btn_EscanearMd = findViewById(R.id.btn_EscanearMd);
        etCodigoMd = findViewById(R.id.etCodigoMd);

        btn_EscanearMd.setOnClickListener(mOnClickListener);
    }

    //Metodo para escanear
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null){
            if (result.getContents() != null){
                etCodigoMd.setText(result.getContents());
            }else{
                Toast.makeText(this, "Error al escanear el codigo", Toast.LENGTH_SHORT).show();
            }

        }
    }//Termina metodo para escanear
    //Metodo del boton escanera
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_EscanearMd:
                    new IntentIntegrator(MenuModificar.this).initiateScan();

            }
        }
    };//Termina metodo del boton escanear
}
