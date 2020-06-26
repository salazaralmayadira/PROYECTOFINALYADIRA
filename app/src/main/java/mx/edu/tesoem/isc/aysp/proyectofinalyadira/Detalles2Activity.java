package mx.edu.tesoem.isc.aysp.proyectofinalyadira;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detalles2Activity extends AppCompatActivity {
    TextView lblMatricula, lblNombre, lblCorreo,lblCalificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles2);

        lblMatricula= findViewById(R.id.dlblMatricula);
        lblNombre= findViewById(R.id.dlblnombre);
        lblCorreo= findViewById(R.id.dlblcorreo);
        lblCalificacion= findViewById(R.id.dlblcalificacion);


        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcelable dato = getIntent().getParcelableExtra("DatosParcelable");
        lblMatricula.setText(dato.getMatricula());
        lblNombre.setText(dato.getNombre());
        lblCorreo.setText(dato.getCorreo());
        lblCalificacion.setText(dato.getCalificacion());

        getSupportActionBar().setTitle(nombre);

    }
}
