package com.ibermatica.pruebaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etOpA, etOpB, etNombre;
    private TextView tvNombre, tvResultado = null;
    private Button btCalcular;


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
    }

    private void multiplicar(){
        int resultado = Integer.parseInt(etOpA.getText().toString()) * Integer.parseInt(etOpB.getText().toString());
        tvResultado.setText(resultado+"");
    }



    public void showNombre(View view) {
        tvNombre.setText(etNombre.getText().toString());
    }
}
