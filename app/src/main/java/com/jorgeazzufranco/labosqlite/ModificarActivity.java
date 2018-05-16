package com.jorgeazzufranco.labosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jorgeazzufranco.labosqlite.Datos.Persona;
import com.jorgeazzufranco.labosqlite.Entidades.DBHelper;

public class ModificarActivity extends AppCompatActivity {

    private EditText id, nombre;
    private Button btnBuscar, btnEliminar, btnLimpiar, btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        inicializarControladores();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if (p == null){
                    Toast.makeText(getApplicationContext(), "El usuario no fue encontrado", Toast.LENGTH_LONG).show();
                    limpiar();
                }
                else{
                    nombre.setText(p.getNombre());
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),nombre.getText().toString()));
            }
        });

    }

    private void limpiar() {
        id.setText("");
        nombre.setText("");
    }

    private void inicializarControladores() {
        id = findViewById(R.id.dui);
        nombre = findViewById(R.id.nombre);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnActualizar = findViewById(R.id.btnActualizar);
    }
}
