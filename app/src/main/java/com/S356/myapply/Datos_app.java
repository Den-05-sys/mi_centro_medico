package com.S356.myapply;

public class Datos_app {
    public static CentroMedico centroMedico = new CentroMedico("Clínica San Rafael");

    static {
        // Inicializar datos globales de prueba
        Paciente p1 = new Paciente("Juan", "Pérez", "99887766D", 55, "col", 1.70, "HC-2024-001");
        Paciente p2 = new Paciente("María", "Gómez", "11223344E", 40, "col", 1.65, "HC-2024-002");
        centroMedico.registrarPaciente(p1);
        centroMedico.registrarPaciente(p2);

        Medico m1 = new Medico("Laura", "Gómez", "CC", "98765", 40, "col", 1.65, "Ac256", 1800.0, "Cardiología", "98543");
        Medico m2 = new Medico("Carlos", "Martínez", "CC", "87654", 48, "col", 1.75, "Ac257", 2000.0, "Pediatría", "98544");
        centroMedico.registrarMedico(m1);
        centroMedico.registrarMedico(m2);
    }
}
