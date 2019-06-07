package com.ibermatica.pruebaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculadora extends AppCompatActivity {

    private EditText etOperando1, etOperando2;
    private RadioGroup rGrupo;
    private RadioButton opsum, opres, opmul, opdiv;
    private Button btCalcular;
    private TextView tvResultado;
    ArrayList<RadioButton> operadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //Referenciar los controles:
        etOperando1 = findViewById(R.id.etOperando1);
        etOperando2 = findViewById(R.id.etOperando2);
        opsum = findViewById(R.id.radioButtonSumar);
        opres = findViewById(R.id.radioButtonRestar);
        opmul = findViewById(R.id.radioButtonMulti);
        opdiv = findViewById(R.id.radioButtonDivi);

        operadores = new ArrayList<RadioButton>();
        operadores.add(opsum);
        operadores.add(opres);
        operadores.add(opmul);
        operadores.add(opdiv);
        btCalcular = findViewById(R.id.buttonCalculate2);
        tvResultado = findViewById(R.id.tvResultado);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //comprobar los campos y la operacion seleccionada:

                if (isNumber(etOperando1) && isNumber(etOperando2)){
                    tvResultado.setText(hayOperadorSeleccionado(etOperando1,etOperando2,operadores));
                }else{
                    tvResultado.setText("Alguno de los operandos no es numérico");
                }
            }
        });
    }

    public boolean isNumber(EditText editText) {

        String input = editText.getText().toString().trim();
        try {
            return (input.length() > 0 && Float.parseFloat(input)>=0 || Float.parseFloat(input)<0);
        }catch (Exception e){
            return false;
        }
    }

    private String hayOperadorSeleccionado(EditText etop1, EditText etop2, ArrayList<RadioButton> operadores) {
        float op1 = Float.parseFloat(etop1.getText().toString());
        float op2 = Float.parseFloat(etop2.getText().toString());
        float resultado = 0;
        for (RadioButton rb : operadores ) {
            if (rb.isChecked()) {

                switch (operadores.indexOf(rb)) {
                    case 0: //Suma
                        resultado = op1 + op2;
                        break;
                    case 1: //Resta
                        resultado = op1 - op2;
                        break;
                    case 2: //Multiplicacion
                        resultado = op1 * op2;
                        break;
                    default://division
                        if (op2 != 0){
                            return ((double)op1 / op2 )+"";
                        }else{
                            return "Indeterminado";
                        }
                }
                return resultado + "";
            }
        }
        return "NaN";
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        finish();
    }
}