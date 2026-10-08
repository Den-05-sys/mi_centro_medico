package com.S356.myapply;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class Administrar_medicamento extends AppCompatActivity {
    private Button btnRegistrar;
    private View btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_administrar_medicamento);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolver = findViewById(R.id.btnVolver);

        if (btnRegistrar != null) {
            btnRegistrar.setOnClickListener(v -> {
                Toast.makeText(Administrar_medicamento.this, "Se registro correctamente el medicamento", Toast.LENGTH_SHORT).show();
            });
        }

        if (btnVolver != null) {
            if (btnVolver instanceof MaterialToolbar) {
                ((MaterialToolbar) btnVolver).setNavigationOnClickListener(v -> finish());
            } else {
                btnVolver.setOnClickListener(v -> finish());
            }
        }
    }
}
