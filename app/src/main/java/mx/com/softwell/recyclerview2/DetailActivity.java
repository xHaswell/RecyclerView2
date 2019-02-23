package mx.com.softwell.recyclerview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtNoControl;
    private Button btnOk;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        configUI();
        inicializar();
        configListeners();
    }

    private void configListeners() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Misc.alumno.setNombre(txtNombre.getText().toString());
                Misc.alumno.setNoControl(txtNoControl.getText().toString());
                Misc.modificado = true;
                finish();
            }
        });
    }

    private void configUI() {
        txtNombre = findViewById(R.id.txtNombre);
        txtNoControl = findViewById(R.id.txtNoControl);
        btnOk = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    private void inicializar() {
        txtNombre.setText(Misc.alumno.getNombre());
        txtNoControl.setText(Misc.alumno.getNoControl());
    }
}
