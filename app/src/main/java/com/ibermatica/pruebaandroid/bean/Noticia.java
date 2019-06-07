package com.ibermatica.pruebaandroid.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Noticia {
    @SerializedName("title")
    private String title;
    @SerializedName("Categories")
    private String Categorias;

    public Noticia(String title, String categorias) {
        this.title = title;
        this.Categorias = categorias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategorias() {
        return Categorias;
    }

    public void setCategorias(String categorias) {
        Categorias = categorias;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "title='" + title + '\'' +
                ", Categorias=" + Categorias +
                '}';
    }
}
