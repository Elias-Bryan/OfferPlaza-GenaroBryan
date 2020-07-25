package pe.edu.tecsup.offerplaza.activities;
import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;



import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.EmpresaAdapter;
import pe.edu.tecsup.offerplaza.adapters.RecyclerViewEmpresaAdaptador;
import pe.edu.tecsup.offerplaza.models.EmpresaModelo;
import pe.edu.tecsup.offerplaza.models.RetroEmpresa;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import pe.edu.tecsup.offerplaza.service.InterfaceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Empresa extends AppCompatActivity {
    private EmpresaAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresas);

        progressDialog = new ProgressDialog(Empresa.this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        InterfaceClient service = ApiClient.getRetrofitInstance().create(InterfaceClient.class);
        Call<List<RetroEmpresa>> call = service.getAllEmpresa(1);

        call.enqueue(new Callback<List<RetroEmpresa>>() {
            @Override
            public void onResponse(Call<List<RetroEmpresa>> call, Response<List<RetroEmpresa>> response) {
                progressDialog.dismiss();
                generateList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroEmpresa>> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(Empresa.this,"Fallo la conexion"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void generateList(List<RetroEmpresa> empresaList) {
        recyclerView = findViewById(R.id.recyclerEmpresa);
        adapter = new EmpresaAdapter(this, empresaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Empresa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
