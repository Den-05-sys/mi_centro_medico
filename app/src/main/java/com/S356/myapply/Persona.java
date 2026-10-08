package com.S356.myapply;

public class Persona {
    private String nombre;
    private String apellido;
    private String tipo_identidad;
    private String Dni;
    private int edad;
    private String nacionalidad;
    private double estatura;

    public Persona(){

    }

    // Constructor con parámetros (para facilitar la creación de objetos)
    public Persona(String nombre,String apellido,String tipo_identidad,String Dni,int edad,String nacionalidad,double estatura) {
        this.nombre=nombre;
        this.apellido=apellido;
        this.tipo_identidad=tipo_identidad;
        this.Dni=Dni;
        this.edad=edad;
        this.nacionalidad=nacionalidad;
        this.estatura=estatura;

    }

    public Persona(String nombre, String apellido, String Dni, int edad, String nacionalidad, double estatura) {
        this(nombre, apellido, "CC", Dni, edad, nacionalidad, estatura);
    }

    // --- MÉTODOS DE LECTURA (GETTERS) ---
    public String getNombreCompleto() {
        return (nombre != null ? nombre : "") + " " + (apellido != null ? apellido : "");
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipo_identidad() {
        return tipo_identidad;
    }

    public String getN_dentidad() {
        return Dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public double getEstatura() {
        return estatura;
    }


    // --- MÉTODOS DE ASIGNACIÓN (SETTERS) ---
    public void setNombres(String nombres) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellido = apellido;
    }

    public void setTipo_identidad(String tipo_identidad) {
        this.tipo_identidad = tipo_identidad;
    }

    public void setIdentidad(String n_identidad) {
        this.Dni = Dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellido);
        System.out.println("Tipo de identidad: " + tipo_identidad);
        System.out.println("Identidad: " + Dni);
        System.out.println("Edad: " + edad);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Estatura: " + estatura + " m");
    }
    public String generarInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre completo: ").append(nombre).append(" ").append(apellido).append("\n");
        sb.append("Identidad: ").append(tipo_identidad).append(" nº ").append(Dni).append("\n");
        sb.append("Edad: ").append(edad).append(" años\n");
        sb.append("Nacionalidad: ").append(nacionalidad).append("\n");
        sb.append("Estatura: ").append(estatura).append(" m");
        return sb.toString();
    }

}
