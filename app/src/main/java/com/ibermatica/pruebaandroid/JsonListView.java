package com.ibermatica.pruebaandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibermatica.pruebaandroid.adapter.NoticiaAdapter;
import com.ibermatica.pruebaandroid.bean.Noticia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class JsonListView extends AppCompatActivity {

    private ListView listView;
    //List<String> titleList = new ArrayList<>();
    ArrayList<Noticia> noticias = new ArrayList<>();
    public static final String noticiasUrl = "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Fep00.epimg.net%2Frss%2Ftags%2Fultimas_noticias.xml&api_key=cholcaalacwrsnfb7prpt38b92oqdhq4udcvswpo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonlistview);



        /*
        titleList.add("HOLA");
        titleList.add("HELLO");
        titleList.add("HI");
        titleList.add("ALO");
        titleList.add("ALOHA");
        */
        listView = findViewById(R.id.listviewNoticias);


        try {
            String respuesta = new JsonTask().execute(noticiasUrl).get();

            //partes de la estructura: items
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(respuesta).getAsJsonObject();
            JsonArray notic = obj.get("items").getAsJsonArray();

            System.out.println(notic.toString());

            JsonArray items = parser.parse(notic.toString()).getAsJsonArray();

            for (int i = 0; i < items.size(); i++) {
                JsonObject obj1 = (JsonObject) notic.get(i);
                String title = obj1.get("title").getAsString();
                JsonArray categorias = obj1.get("categories").getAsJsonArray();
                String lista = "";
                for (int c = 0; c < categorias.size(); c++) {
                    lista += categorias.get(c).getAsString() + ", ";
                }

                System.out.println("NOTICIA: tiulo=" + title + ", Categorias=" + lista.substring(0,lista.length()-2));
                noticias.add(new Noticia(title,lista));
            }

            NoticiaAdapter noticaAdapter = new NoticiaAdapter(this, noticias);
            listView.setAdapter(noticaAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                    Intent appInfo = new Intent(JsonListView.this, DetalleNoticia.class);
                    //appInfo.putExtra("categorias",noticias.get(position).getCategorias().toArray(new String[noticias.get(position).getCategorias().size()]));
                    appInfo.putExtra("categorias",noticias.get(position).getCategorias());
                    startActivity(appInfo);
                    finish();
                }
            });

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*
        ArrayList<String> categorias = new ArrayList<String>();
        categorias.add("SALUDO");
        categorias.add("AMISTAD");
        categorias.add("AMOR");
        categorias.add("SEXO");
        noticias.add(new Noticia("HOLA",categorias));
        ArrayList<String> categorias2 = new ArrayList<String>();
        categorias2.add("PAZ");
        categorias2.add("DEPORTE");
        noticias.add(new Noticia("ADIOS",categorias2));
*/
        //ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titleList);
        //listView.setAdapter(stringArrayAdapter);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        finish();
    }


    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

        }
    }
}