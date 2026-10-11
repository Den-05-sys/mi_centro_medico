package com.S356.myapply;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Empleado_adapter extends RecyclerView.Adapter<Empleado_adapter.ViewHolder> {

    public interface OnEmpleadoClickListener {
        void onEmpleadoClick(Empleado empleado);
    }

    private ArrayList<Empleado> empleados;
    private ArrayList<Empleado> empleadosFiltrados;
    private OnEmpleadoClickListener listener;

    public Empleado_adapter(ArrayList<Empleado> empleados, OnEmpleadoClickListener listener) {
        this.empleados = new ArrayList<>(empleados);
        this.empleadosFiltrados = new ArrayList<>(empleados);
        this.listener = listener;
    }

    public Empleado_adapter(ArrayList<Empleado> empleados) {
        this(empleados, null);
    }

    public void filtrar(String rol) {
        empleadosFiltrados.clear();

        if (rol == null || rol.equalsIgnoreCase("Todos")) {
            empleadosFiltrados.addAll(empleados);
        } else {
            for (Empleado empleado : empleados) {
                if (rol.equalsIgnoreCase("Medico") && empleado instanceof Medico) {
                    empleadosFiltrados.add(empleado);
                } else if (rol.equalsIgnoreCase("Administrativo") && empleado instanceof Administrativo) {
                    empleadosFiltrados.add(empleado);
                } else if (rol.equalsIgnoreCase("Enfermero") && empleado instanceof Enfermero) {
                    empleadosFiltrados.add(empleado);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtid_empleado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtid_empleado = itemView.findViewById(R.id.txtid_empleado);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_empleado_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Empleado empleado = empleadosFiltrados.get(position);

        holder.txtNombre.setText(empleado.getNombreCompleto());
        holder.txtid_empleado.setText("ID: " + (empleado.getId_empleado() != null ? empleado.getId_empleado() : ""));

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEmpleadoClick(empleado);
            }
        });
    }

    @Override
    public int getItemCount() {
        return empleadosFiltrados.size();
    }
}
