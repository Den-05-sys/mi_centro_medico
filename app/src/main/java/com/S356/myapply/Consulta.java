package com.S356.myapply;

public class Consulta {
    private String fecha;
    private String motivo;
    Medico medico;
    Paciente paciente;

    public Consulta(String fecha,String motivo,Medico medico,Paciente paciente){
        this.fecha=fecha;
        this.motivo=motivo;
        this.medico=medico;
        this.paciente=paciente;

    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
    public void setMotivo(String motivo){
        this.motivo=motivo;
    }
    public String getFecha(){
        return fecha;

    }
    public String getMotivo(){
        return motivo;
    }
    public void realizar(){
        System.out.println("Consulta:");
        System.out.println("Fecha"+fecha);
        System.out.println("Motivo :"+motivo);
        System.out.println("Paciente "+paciente);
        System.out.println("Medico "+medico);
        paciente.agregarConsulta(this);

    }
    public void mostrarInfo() {

        System.out.println("Fecha: " + fecha);
        System.out.println("Motivo: " + motivo);
        System.out.println("Médico: " + medico.getNombreCompleto());
        System.out.println("Paciente: " + paciente.getNombreCompleto());
    }
}
