package com.example.talleer;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.VistaHolder> {

    private List<Usuario> listaUsuarios;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Usuario usuario);
    }

    public AdaptadorUsuario(List<Usuario> listaUsuarios, OnItemClickListener listener) {
        this.listaUsuarios = listaUsuarios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VistaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new VistaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull VistaHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.textoNombre.setText(usuario.getNombre());
        Glide.with(holder.itemView.getContext()).load(usuario.getUrlImagen()).into(holder.imagenUsuario);

        holder.itemView.setOnClickListener(v -> listener.onItemClick(usuario));
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static class VistaHolder extends RecyclerView.ViewHolder {
        ImageView imagenUsuario;
        TextView textoNombre;

        public VistaHolder(@NonNull View itemView) {
            super(itemView);
            imagenUsuario = itemView.findViewById(R.id.imageView);
            textoNombre = itemView.findViewById(R.id.textView);
        }
    }
}
