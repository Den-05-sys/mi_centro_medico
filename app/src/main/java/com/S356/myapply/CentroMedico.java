package com.S356.myapply;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class CentroMedico {
    private String nombre;

    RecyclerView recyclerPacientes;
    RecyclerView recyclerMedicos;
    RecyclerView recyclerConsultas;


    List<Empleado>empleados;
    List<Consulta>consultas;
    List<Paciente>pacientes;

    List<Medico>medicos;

    Paciente_adapter pacienteAdapter;
    Empleado_adapter empleadoAdapter;

    public CentroMedico(String nombre){
        this.nombre=nombre;

        pacientes=new ArrayList<>();
        empleados=new ArrayList<>();
        consultas=new ArrayList<>();
        medicos=new ArrayList<>();

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void contratar(Empleado empleado) {
        empleados.add(empleado);
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        medicos.add(medico);

        // Como Medico es un Empleado,
        // también lo agregamos al personal
        empleados.add(medico);
    }

    public void agendarConsulta(Consulta consulta) {
        consultas.add(consulta);

        System.out.println("Consulta agendada");
        consulta.mostrarInfo();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void mostrarPersonal() {

        System.out.println("Personal:");

        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombreCompleto());
        }
    }

    public void mostrarPacientes() {

        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNombreCompleto());
        }
    }

    public void mostrarMedicos() {

        for (Medico medico : medicos) {
            System.out.println(medico.getNombreCompleto());
        }
    }
}

