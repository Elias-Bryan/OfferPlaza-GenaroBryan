package pe.edu.tecsup.offerplaza.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;



import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.RecyclerViewProductoAdaptador;
import pe.edu.tecsup.offerplaza.models.ProductoModelo;


public class Productos extends AppCompatActivity {
    private RecyclerView recyclerViewProducto;
    private RecyclerViewProductoAdaptador adaptadorProducto;

    private Toolbar mToolbar;
    Spinner spinnerSede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

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


        recyclerViewProducto=(RecyclerView)findViewById(R.id.recyclerProducto);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));

        adaptadorProducto=new RecyclerViewProductoAdaptador(obtenerProductos());
        recyclerViewProducto.setAdapter(adaptadorProducto);
    }
    public List<ProductoModelo> obtenerProductos(){
        List<ProductoModelo> producto=new ArrayList<>();
        producto.add(new ProductoModelo("Leche ","Lima","130","S/4.20",R.drawable.pilsen));
        producto.add(new ProductoModelo("Redbull","Centro","100","S/6.20",R.drawable.redbull));
        producto.add(new ProductoModelo("Panes","Surquillo","200","S/3.40",R.drawable.panes));
        producto.add(new ProductoModelo("Yogurt","Lima","300","S/5.50",R.drawable.yogurt));
        producto.add(new ProductoModelo("leche","Centro","130","S/4.20",R.drawable.leche));
        producto.add(new ProductoModelo("Redbull","Callao","300","S/4.20",R.drawable.redbull));

        return producto;
    }




}
