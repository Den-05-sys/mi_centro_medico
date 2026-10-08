package com.S356.myapply;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona{
    private String numeroHistoria;
    private HistorialMedico historial;
    private List<Consulta>consultas;

    public Paciente(String nombre,String apellido,String Dni,int edad,
                    String nacionalidad,double estatura,String numeroHistoria){

        super(nombre,apellido,Dni,edad,nacionalidad,estatura);

        this.numeroHistoria=numeroHistoria;

        historial=new HistorialMedico();
        consultas = new ArrayList<>();

    }
    public void agregarConsulta(Consulta consulta){
        consultas.add(consulta);
    }
    public void mostrarHistorial(){
        System.out.println("Historial de, "+getNombreCompleto());
        historial.mostrar();
    }
    public HistorialMedico getHistorial() {
        return historial;
    }
    public String getNumeroHistoria() {
        return numeroHistoria;
    }
}
