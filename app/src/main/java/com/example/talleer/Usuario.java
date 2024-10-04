package com.example.talleer;

public class Usuario {
    private String nombre;
    private String urlImagen;

    public Usuario(String nombre, String urlImagen) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }
}

