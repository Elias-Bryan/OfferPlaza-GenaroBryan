package pe.edu.tecsup.offerplaza.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pe.edu.tecsup.offerplaza.R;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);
        ImageView bg =(ImageView) findViewById(R.id.bgEmpresaImg);
        ImageView img =(ImageView) findViewById(R.id.ivEmpresaCompleta);
        TextView detalles = (TextView) findViewById(R.id.tvDescripcion);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null) {
            img.setImageResource(b.getInt("IMG"));
            bg.setImageResource(b.getInt("BG"));
            detalles.setText(b.getString("DET"));
        }


    }
}
