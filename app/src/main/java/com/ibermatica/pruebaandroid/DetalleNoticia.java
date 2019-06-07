package com.ibermatica.pruebaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetalleNoticia extends AppCompatActivity {


    private TextView tvCategorias;
    private String categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle_noticia);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            //categorias = extras.getStringArray("categorias");
            categorias = extras.getString("categorias");
        }

        tvCategorias = findViewById(R.id.tv_categorias);
        tvCategorias.setText(categorias);
        /*
        StringBuilder sb = new StringBuilder();
        for (String str : categorias)
            sb.append(str).append(", ");
        String texto = sb.substring(0, sb.length() - 2);

        tvCategorias.setText(texto);
        */

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent (getApplicationContext(), JsonListView.class);
        startActivityForResult(intent, 0);
        finish();
    }
}