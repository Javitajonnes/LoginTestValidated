package com.example.logintestvalidated;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessActivity extends AppCompatActivity {

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes definir qué hacer después (e.g., regresar a la pantalla inicial)
                Intent intent = new Intent(SuccessActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finaliza esta actividad
            }
        });
    }
}
