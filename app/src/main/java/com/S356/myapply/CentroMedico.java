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

    List<Empleado>empleados;
    List<Consulta>consultas;
    List<Paciente>pacientes;

    List<Medico>medicos;

    Paciente_adapter adapter;

    public CentroMedico(String nombre){
        this.nombre=nombre;

        pacientes=new ArrayList<>();
        empleados=new ArrayList<>();
        consultas=new ArrayList<>();
        medicos=new ArrayList<>();

    }

    Medico medico1 = new Medico("Laura", "Gómez", "cc", "1234",
            43, "col", 1.70, "m1233", 4.000000,"Cardiologa","98765");

    Enfermero enfermero1 = new Enfermero("Carlos", "Ruiz", "87654321B", 35,
            "ENF-014", 2200.0, "2020-06-01", "Mañana");

    Administrativo admin1 = new Administrativo("María", "López", "11223344C", "4766879",
            45, "col", 1.70, "Amd1233",1800.0,"Ti","Administrativo");
    Paciente paciente1 = new Paciente("Juan", "Pérez", "99887766D", 55,"col", 1.70,"HC-2024-001");

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void contratar(Empleado empleado){
        empleados.add(empleado);
    }
    public void registrarPaciente(Paciente paciente){
        pacientes.add(paciente);

    }
    public void agendarConsulta(Consulta consulta){
        consultas.add(consulta);
        System.out.println("Consulta agendada");
        consulta.mostrarInfo();
    }
    public void mostrarPersonal(){

        System.out.println("Personal:");
        for (Empleado empleado: empleados){
            System.out.println(empleado.getNombreCompleto());
        }
    }
    public void mostrarPacientes(){

        for (Paciente paciente : pacientes){
            System.out.println(paciente.getNombreCompleto());
        }

    }

    public void mostrarMedicos(){

        for (Medico medico : medicos){
            System.out.println(medico.getNombreCompleto());
        }

    }
}
