package com.S356.myapply;

public class Empleado extends Persona {
    String id_empleado;
    double pago_por_hora;

    public Empleado(String nombre,String apellido,String tipo_identidad,String Dni,int edad,String nacionalidad,double estatura,String id_empleado,double pago_por_hora) {
        super(nombre,apellido,tipo_identidad,Dni,edad,nacionalidad,estatura); // Llama al constructor de Persona

        this.id_empleado =id_empleado ;
        this.pago_por_hora = pago_por_hora;
    }

    public Empleado(String nombre, String apellido, String Dni, int edad, String id_empleado, String fechaIngreso, double sueldo) {
        super(nombre, apellido, "CC", Dni, edad, "Colombiano", 1.70);
        this.id_empleado = id_empleado;
        this.pago_por_hora = sueldo;
    }

    public void setId_empleado(String id_empleado){
        this.id_empleado=id_empleado;
    }

    public String getId_empleado(){
        return id_empleado;
    }
    // calculo salario mensual
    public double calculo_sal_m(double pago_por_hora){
        this.pago_por_hora = pago_por_hora * 900;
        return this.pago_por_hora;

    }
    @Override
    public String generarInformacion() {
        return super.generarInformacion()
                + "\nID Empleado: " + id_empleado
                + "\nSalario: $" + pago_por_hora;
    }

}
