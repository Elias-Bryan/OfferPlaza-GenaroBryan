package pe.edu.tecsup.offerplaza.Categorias;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.Categoria1Adapter;
import pe.edu.tecsup.offerplaza.models.RetroProducto;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import pe.edu.tecsup.offerplaza.service.InterfaceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Categoria6 extends AppCompatActivity {
    private Categoria1Adapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria6);
        int idcliente = getIdSharedPreference("id");
        InterfaceClient service = ApiClient.getRetrofitInstance().create(InterfaceClient.class);
        Call<List<RetroProducto>> call = service.getAllCategoria6(idcliente);

        call.enqueue(new Callback<List<RetroProducto>>() {
                         @Override
                         public void onResponse(Call<List<RetroProducto>> call, Response<List<RetroProducto>> response) {

                             generateList(response.body());
                         }

                         @Override
                         public void onFailure(Call<List<RetroProducto>> call, Throwable t) {
                             Toast.makeText(Categoria6.this,"login faild",Toast.LENGTH_LONG).show();
                         }
                     }
        );
    }

    private void generateList(List<RetroProducto> photoList) {
        recyclerView = findViewById(R.id.recyclerCategoria6);
        adapter = new Categoria1Adapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Categoria6.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private int getIdSharedPreference(String key){
        SharedPreferences sharedPref =getSharedPreferences("id_preferences", Context.MODE_PRIVATE);
        return sharedPref.getInt(key,100);
    }
}