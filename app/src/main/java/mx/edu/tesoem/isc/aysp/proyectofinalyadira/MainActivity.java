package mx.edu.tesoem.isc.aysp.proyectofinalyadira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gvDatos;
    EditText txtMatricula, txtNobre, txtCorreo,txtCalificacion;
    List<Datos> datos = new ArrayList<>();
    AdaptadorBase adaptadorBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvDatos=findViewById(R.id.gvDatos);
        txtMatricula= findViewById(R.id.txtMatricula);
        txtNobre =findViewById(R.id.txtNombre);
        txtCorreo= findViewById(R.id.txtCorreo);
        txtCalificacion= findViewById(R.id.txtCalificacion);
        Verifica();
        gvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos dato=(Datos) adaptadorBase.getItem(position);
                DatosParcelable datosParcelable = new DatosParcelable(dato.getMatricula(),dato.getNombre(),dato.getCorreo(),dato.getCalificacion());
                Intent intent = new Intent(MainActivity.this,Detalles2Activity.class);
                intent.putExtra("nombre",dato.getNombre());
                intent.putExtra("DatosParcelable",datosParcelable);
                startActivity(intent);
            }
        });
    }
    private void Verifica(){
        Almacen conexion = new Almacen();

        if (conexion.Exite(this)){
            if (conexion.Leer(this)){
                datos=conexion.getDatos();
                adaptadorBase= new AdaptadorBase(datos,this);
                gvDatos.setAdapter(adaptadorBase);
            }else {
                Toast.makeText(this, "No se pudo leer la informacion", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No existe el archivo, favor de grabar informacion ", Toast.LENGTH_SHORT).show();
        }
    }
    public void Graba(View v){
        Datos dato= new Datos();
        Almacen conexion= new Almacen();
        dato.setMatricula(txtMatricula.getText().toString());
        dato.setNombre(txtNobre.getText().toString());
        dato.setCorreo(txtCorreo.getText().toString());
        dato.setCalificacion(txtCalificacion.getText().toString());

        datos.add(dato);
        if (conexion.Escribir(this,datos)){
            Toast.makeText(this, "Se escribieron correctamente ", Toast.LENGTH_SHORT).show();
            Verifica();
        }else{
            Toast.makeText(this, "Error al escribir", Toast.LENGTH_SHORT).show();
        }


    }

}




