package com.S356.myapply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Paciente_adapter extends RecyclerView.Adapter<Paciente_adapter.ViewHolder> {

    public interface OnPacienteClickListener {
        void onPacienteClick(Paciente paciente);
    }

    private ArrayList<Paciente> pacientes;
    private OnPacienteClickListener listener;

    public Paciente_adapter(ArrayList<Paciente> pacientes, OnPacienteClickListener listener) {
        this.pacientes = pacientes;
        this.listener = listener;
    }

    public Paciente_adapter(ArrayList<Paciente> pacientes) {
        this(pacientes, null);
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
                .inflate(R.layout.activity_paciente_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paciente paciente = pacientes.get(position);

        holder.txtNombre.setText(paciente.getNombreCompleto());
        holder.txtEdad.setText("Edad: " + paciente.getEdad());
        holder.txtDni.setText("Documento: " + paciente.getN_dentidad());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onPacienteClick(paciente);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pacientes.size();
    }
}
