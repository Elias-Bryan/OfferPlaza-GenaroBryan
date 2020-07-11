package pe.edu.tecsup.offerplaza.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pe.edu.tecsup.offerplaza.R;

public class DetalleEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_empresa);
        TextView titulo = (TextView) findViewById(R.id.tbTituloDescripcion);
        TextView detalles = (TextView) findViewById(R.id.tvDescripcion);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null){
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }
    }
}
