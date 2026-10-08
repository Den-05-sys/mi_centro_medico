package com.S356.myapply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List_adapter extends RecyclerView.Adapter<List_adapter.ViewHolder> {

    public interface OnBuscarPacienteClickListener {
        void onBuscarPacienteClick(Paciente paciente);
    }

    private ArrayList<Paciente> pacientes;
    private ArrayList<Paciente> listaOriginal;
    private OnBuscarPacienteClickListener listener;

    public List_adapter(ArrayList<Paciente> pacientes, OnBuscarPacienteClickListener listener) {
        this.pacientes = new ArrayList<>(pacientes);
        this.listaOriginal = new ArrayList<>(pacientes);
        this.listener = listener;
    }

    public List_adapter(ArrayList<Paciente> pacientes) {
        this(pacientes, null);
    }

    public void filtrar(String texto) {
        pacientes.clear();
        if (texto.isEmpty()) {
            pacientes.addAll(listaOriginal);
        } else {
            String busqueda = texto.toLowerCase().trim();
            for (Paciente p : listaOriginal) {
                if (p.getNombreCompleto().toLowerCase().contains(busqueda)
                        || (p.getN_dentidad() != null && p.getN_dentidad().toLowerCase().contains(busqueda))
                        || (p.getNumeroHistoria() != null && p.getNumeroHistoria().toLowerCase().contains(busqueda))) {
                    pacientes.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtDni;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDni = itemView.findViewById(R.id.txtDni);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paciente paciente = pacientes.get(position);

        holder.txtNombre.setText(paciente.getNombreCompleto());
        holder.txtDni.setText("Documento: " + paciente.getN_dentidad());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onBuscarPacienteClick(paciente);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pacientes.size();
    }
}
