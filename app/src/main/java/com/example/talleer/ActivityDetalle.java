package com.example.talleer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class ActivityDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);

        ImageView imagenDetalle = findViewById(R.id.imageViewDetail);
        TextView textoDetalle = findViewById(R.id.textViewDetail);

        String nombre = getIntent().getStringExtra("nombre");
        String urlImagen = getIntent().getStringExtra("urlImagen");

        textoDetalle.setText(nombre);
        Glide.with(this).load(urlImagen).into(imagenDetalle);
    }
}
