package com.jorgeazzufranco.labosqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.jorgeazzufranco.labosqlite.Datos.Persona;
import com.jorgeazzufranco.labosqlite.Entidades.DBHelper;

public class RegistrarActivity extends AppCompatActivity {

    private EditText txtId, txtNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        inicializarControles();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("DATOS:", txtId.getText().toString()+", "+txtNombre.getText().toString());

                String dui = txtId.getText().toString();
                String nom =txtNombre.getText().toString();

               boolean flag = DBHelper.myDB.add(new Persona(dui,nom));

               if (flag){
                    Log.d("Edit", txtNombre.getText().toString());
                }
            }
        });
    }

    private void inicializarControles() {
        txtId = findViewById(R.id.rdui);
        txtNombre = findViewById(R.id.rnombre);
        btnEnviar = findViewById(R.id.renviar);
    }
}
