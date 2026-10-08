package com.S356.myapply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Medico_adapter extends RecyclerView.Adapter<Medico_adapter.ViewHolder> {

    public interface OnMedicoClickListener {
        void onMedicoClick(Medico medico);
    }

    private ArrayList<Medico> medicos;
    private OnMedicoClickListener listener;

    public Medico_adapter(ArrayList<Medico> medicos, OnMedicoClickListener listener) {
        this.medicos = medicos;
        this.listener = listener;
    }

    public Medico_adapter(ArrayList<Medico> medicos) {
        this(medicos, null);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtEdad;
        TextView txtDni;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtEdad = itemView.findViewById(R.id.txtEdad);
            txtDni = itemView.findViewById(R.id.txtDni);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_medico_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medico medico = medicos.get(position);

        holder.txtNombre.setText(medico.getNombreCompleto());
        holder.txtEdad.setText("Especialidad: " + (medico.getEspecialidad() != null ? medico.getEspecialidad() : "General"));
        holder.txtDni.setText("Documento: " + medico.getN_dentidad());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMedicoClick(medico);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicos.size();
    }
}
