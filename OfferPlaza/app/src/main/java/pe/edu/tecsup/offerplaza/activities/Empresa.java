package pe.edu.tecsup.offerplaza.activities;
import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;



import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.RecyclerViewEmpresaAdaptador;
import pe.edu.tecsup.offerplaza.models.EmpresaModelo;


public class Empresa extends AppCompatActivity {
    private RecyclerView recyclerViewEmpresa;
    private RecyclerViewEmpresaAdaptador adaptadorEmpresa;
    private Button btn_Productos;

    private Toolbar mToolbar;
    Spinner spinnerSede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        btn_Productos = findViewById(R.id.btn_Productos);
        btn_Productos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentReg= new Intent(Empresa.this, Productos.class);
                Empresa.this.startActivity(intentReg);
            }
        });

        ArrayList<String> ComboSedes=new ArrayList<String>();
        ComboSedes.add("Lima");
        ComboSedes.add("Centro");
        ComboSedes.add("Surquillo");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, R.layout.item_spinner_geekipedia,ComboSedes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSede.setAdapter(adapter);


        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerViewEmpresa=(RecyclerView)findViewById(R.id.recyclerEmpresa);
        recyclerViewEmpresa.setLayoutManager(new LinearLayoutManager(this));

        adaptadorEmpresa=new RecyclerViewEmpresaAdaptador(obtenerEmpresa());
        recyclerViewEmpresa.setAdapter(adaptadorEmpresa);
    }
    public List<EmpresaModelo> obtenerEmpresa(){
        List<EmpresaModelo> empresa=new ArrayList<>();
        empresa.add(new EmpresaModelo("Plaza vea ","Lima",4,R.drawable.plaza));
        empresa.add(new EmpresaModelo("Metro","Centro",5,R.drawable.metro));
        empresa.add(new EmpresaModelo("Mass","Surquillo",6,R.drawable.mass));
        empresa.add(new EmpresaModelo("Vivanda","Lima",7,R.drawable.vivanda));
        empresa.add(new EmpresaModelo("Tottus","Centro",9,R.drawable.tottus));
        empresa.add(new EmpresaModelo("Plaza vea","Callao",3,R.drawable.plaza));

        return empresa;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
