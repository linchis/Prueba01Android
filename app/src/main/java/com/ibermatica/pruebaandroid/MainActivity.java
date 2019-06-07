package com.ibermatica.pruebaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etOpA, etOpB, etNombre;
    private TextView tvNombre, tvResultado = null;
    private Button btCalcular, btnCalculadora, btnListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOpA = findViewById(R.id.etOpA);
        etOpB = findViewById(R.id.etOpB);

        tvResultado = findViewById(R.id.tvResultado);
        tvNombre = findViewById(R.id.tvNombre);
        etNombre = findViewById(R.id.etNombre);

        btCalcular = findViewById(R.id.btCalculate);
        btnCalculadora = findViewById(R.id.btnCalculadora);
        btnListView = findViewById(R.id.btnListView);
        /*
        ((View) btCalcular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicar();
            }
        });*/

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicar();
            }
        });

        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), Calculadora.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(), JsonListView.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });
    }

    private void multiplicar(){
        int resultado = Integer.parseInt(etOpA.getText().toString()) * Integer.parseInt(etOpB.getText().toString());
        tvResultado.setText(resultado+"");
    }



    public void showNombre(View view) {
        tvNombre.setText(etNombre.getText().toString());
    }
}
