package com.S356.myapply;

public class Medico extends Empleado{
    String especialidad;
    String numero_colegiado;


    public Medico(String nombre,String apellido,String tipo_identidad,String Dni,int edad,
                  String nacionalidad,double estatura,String id_empleado ,double pago_por_hora,String especialidad,String numero_colegiado ) {
        super(nombre,apellido,tipo_identidad,Dni,edad,nacionalidad,estatura,id_empleado ,pago_por_hora); // Llama al constructor de Persona
        this.especialidad = especialidad;
        this.numero_colegiado=numero_colegiado;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad= especialidad;
    }
    public void setNumero_colegiado(String numero_colegiado){
        this.numero_colegiado= numero_colegiado;
    }
    public String getEspecialidad( ){
        return especialidad;
    }
    public String getNumero_colegiado( ){
        return numero_colegiado;
    }

    @Override
    public double calculo_sal_m(double pago_por_hora) {
        double bonificacion = 1000000;
        this.pago_por_hora = (pago_por_hora * 900)+ bonificacion;
        return this.pago_por_hora ;
    }
    @Override
    public String generarInformacion() {
        return super.generarInformacion()
                + "\nEspecialidad: " + especialidad
                + "\nColegiado: " + numero_colegiado;
    }

}
