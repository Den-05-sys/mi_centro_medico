package com.S356.myapply;

public class Administrativo extends Empleado{
    private String departamento;
    private String cargo;


    public Administrativo(String nombre,String apellido,String tipo_identidad,String Dni,int edad,String nacionalidad,double estatura,String id_empleado,
                          double pago_por_hora,String departamento,String cargo) {
        super(nombre, apellido, tipo_identidad, Dni,
                edad, nacionalidad, estatura,id_empleado, pago_por_hora); // Llama al constructor de Persona

        this.departamento = departamento;
        this.cargo = cargo;
    }
    public void setDepartamento(String departamento){
        this.departamento=departamento;
    }
    public void setCargo(String cargo){
        this.cargo=cargo;
    }

    public String getDepartamento(){
        return departamento;
    }
    public String getCargo(){
        return cargo;
    }

    @Override
    public double calculo_sal_m(double pago_por_hora) {
        double bonificacion = 990000;
        this.pago_por_hora = (pago_por_hora * 900)+ bonificacion;
        return this.pago_por_hora ;
    }
    @Override
    public String generarInformacion() {
        return super.generarInformacion()
                + "\nDepartamento: " + departamento
                + "\nCargo: " + cargo;
    }

}
