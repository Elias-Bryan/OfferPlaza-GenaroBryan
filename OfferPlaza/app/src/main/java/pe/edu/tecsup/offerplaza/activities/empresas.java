package pe.edu.tecsup.offerplaza.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.empresasAdapter;
import pe.edu.tecsup.offerplaza.models.EmpresaModelo;
import pe.edu.tecsup.offerplaza.models.EmpresaResponse;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import pe.edu.tecsup.offerplaza.service.InterfaceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class empresas extends AppCompatActivity {
    private empresasAdapter adapter;
    private RecyclerView recyclerView;
    private Button btn_Productos;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        btn_Productos = findViewById(R.id.btn_Productos);

        progressDialog = new ProgressDialog(empresas.this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        btn_Productos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentReg= new Intent(empresas.this, Productos.class);
                empresas.this.startActivity(intentReg);
            }
        });

        InterfaceClient service = ApiClient.getRetrofitInstance().create(InterfaceClient.class);
        Call<List<EmpresaResponse>> call = service.getAllEmpresa();

        call.enqueue(new Callback<List<EmpresaResponse>>() {
            @Override
            public void onResponse(Call<List<EmpresaResponse>> call, Response<List<EmpresaResponse>> response) {
                progressDialog.dismiss();
                generateList(response.body());
            }


            @Override
            public void onFailure(Call<List<EmpresaResponse>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(empresas.this, "Falló la conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateList(List<EmpresaResponse> photoList) {
        recyclerView = findViewById(R.id.recyclerEmpresa);
        adapter = new empresasAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(empresas.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
 /* Call<List<EmpresaResponse>> empresaList = ApiClient.getUserClient().getAllEmpresa();

        empresaList.enqueue(new Callback<List<EmpresaResponse>>() {
            @Override
            public void onResponse(Call<List<EmpresaResponse>> call, Response<List<EmpresaResponse>> response) {
                if(response.isSuccessful()){
                    Log.e("succes",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<EmpresaResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());

            }
        });*/