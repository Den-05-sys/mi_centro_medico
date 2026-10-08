package com.S356.myapply;
import java.util.ArrayList;
import java.util.List;
public class HistorialMedico {
    List<String>diagnosticos;
    List<String>tratamientos;

    public HistorialMedico(){
        diagnosticos=new ArrayList<>();
        tratamientos=new ArrayList<>();
    }
    public void agregarDiagnostico(String diagnostico){
        diagnosticos.add(diagnostico);
    }
    public void agregarTratamiento(String tratamiento){
        tratamientos.add(tratamiento);
    }
    public void mostrar(){
        System.out.println("Diagnosticos:");

        for (String diagnostico : diagnosticos){
            System.out.println("Diagnostico agregados "+ diagnostico);
        }
        for (String i : tratamientos){
            System.out.println("Tratamientos agregados "+ i);
        }
    }
}
