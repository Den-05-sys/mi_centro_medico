package com.S356.myapply;

public class Enfermero extends Empleado{
    String turno;
    public Enfermero(String nombre,String apellido,String Dni,int edad,
                     String idEmpleado,double sueldo,String fechaIngreso,String turno){
        super(nombre,apellido,Dni,edad,idEmpleado,fechaIngreso,sueldo);
        this.turno=turno;
    }
    public void tomarSignosVitales(Paciente paciente){
        System.out.println("Tomando signos vitales..."+paciente.getNombreCompleto());
    }
    public void administrarMedicamento(Paciente paciente,String medicamento){
        System.out.println("Administrando "+medicamento+ "al paciente "+paciente.getNombreCompleto());
    }
}
