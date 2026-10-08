package com.S356.myapply;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class Registrar_paciente extends AppCompatActivity {

    private Button btnCancelar;
    private Button btnRegistrar;

    private EditText etNombre;
    private EditText etApellido;
    private EditText etDni;
    private EditText etEdad;
    private EditText etNumeroHistoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar_paciente);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        View toolbar = findViewById(R.id.toolbar);
        if (toolbar instanceof MaterialToolbar) {
            ((MaterialToolbar) toolbar).setNavigationOnClickListener(v -> finish());
        }

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etDni = findViewById(R.id.etDni);
        etEdad = findViewById(R.id.etEdad);
        etNumeroHistoria = findViewById(R.id.etNumeroHistoria);

        btnCancelar = findViewById(R.id.btnCancelar);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        if (btnCancelar != null) {
            btnCancelar.setOnClickListener(v -> {
                Toast.makeText(Registrar_paciente.this, "Se canceló el registro", Toast.LENGTH_SHORT).show();
                finish();
            });
        }

        if (btnRegistrar != null) {
            btnRegistrar.setOnClickListener(v -> {
                String nombre = etNombre != null ? etNombre.getText().toString().trim() : "";
                String apellido = etApellido != null ? etApellido.getText().toString().trim() : "";
                String dni = etDni != null ? etDni.getText().toString().trim() : "";
                String edadStr = etEdad != null ? etEdad.getText().toString().trim() : "0";
                int edad = 0;
                try {
                    edad = Integer.parseInt(edadStr);
                } catch (Exception ignored) {}
                String hc = etNumeroHistoria != null ? etNumeroHistoria.getText().toString().trim() : "";

                if (nombre.isEmpty() || apellido.isEmpty()) {
                    Toast.makeText(Registrar_paciente.this, "Por favor ingrese nombre y apellido", Toast.LENGTH_SHORT).show();
                    return;
                }

                Paciente nuevoPaciente = new Paciente(nombre, apellido, dni, edad, "Colombiana", 1.70, hc);
                Datos_app.centroMedico.registrarPaciente(nuevoPaciente);

                Toast.makeText(Registrar_paciente.this, "El paciente se registró correctamente", Toast.LENGTH_SHORT).show();
                finish();
            });
        }
    }
}
