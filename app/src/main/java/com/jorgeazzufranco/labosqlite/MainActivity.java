package com.jorgeazzufranco.labosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jorgeazzufranco.labosqlite.Entidades.DBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btn_registrar, btn_consultar, btn_consultarS, getBtn_consultarLv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper.getInstance(this);
        inicializarControladores();

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrarActivity.class);
                startActivity(intent);
            }
        });

        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModificarActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inicializarControladores() {
        btn_registrar = findViewById(R.id.button1);
        btn_consultar = findViewById(R.id.button2);
    }
}
