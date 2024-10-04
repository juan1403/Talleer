package com.example.talleer;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Usuario> listaPersonajes = new ArrayList<>();
        listaPersonajes.add(new Usuario("Juan", "https://rickandmortyapi.com/api/character/avatar/72.jpeg"));
        listaPersonajes.add(new Usuario("Fernando", "https://rickandmortyapi.com/api/character/avatar/120.jpeg"));
        listaPersonajes.add(new Usuario("Jose", "https://rickandmortyapi.com/api/character/avatar/190.jpeg"));
        listaPersonajes.add(new Usuario("Camilo", "https://rickandmortyapi.com/api/character/avatar/241.jpeg"));

        AdaptadorUsuario adaptador = new AdaptadorUsuario(listaPersonajes, personaje -> {
            Intent intent = new Intent(MainActivity.this, ActivityDetalle.class);
            intent.putExtra("nombre", personaje.getNombre());
            intent.putExtra("urlImagen", personaje.getUrlImagen());
            startActivity(intent);
        });

        recyclerView.setAdapter(adaptador);
    }
}

