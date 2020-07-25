package pe.edu.tecsup.offerplaza.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.ProductoAdapter;
import pe.edu.tecsup.offerplaza.adapters.TiendaAdapter;
import pe.edu.tecsup.offerplaza.models.RetroEmpresa;
import pe.edu.tecsup.offerplaza.models.RetroProducto;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import pe.edu.tecsup.offerplaza.service.InterfaceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ProductoAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    public ProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductoFragment newInstance(String param1, String param2) {
        ProductoFragment fragment = new ProductoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_producto, container, false);
        int idcliente = getIdSharedPreference("id");
        InterfaceClient service = ApiClient.getRetrofitInstance().create(InterfaceClient.class);
        Call<List<RetroProducto>> call = service.getAllProductos(idcliente);

        call.enqueue(new Callback<List<RetroProducto>>() {
                         @Override
                         public void onResponse(Call<List<RetroProducto>> call, Response<List<RetroProducto>> response) {

                             generateList(response.body());

                         }

                         @Override
                         public void onFailure(Call<List<RetroProducto>> call, Throwable t) {
                             Toast.makeText(getActivity(), "Falló la conexión"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                         }
                     }
        );
        /*List<TiendaModelo> tienda=new ArrayList<>();
        recyclerViewTienda=(RecyclerView)vista.findViewById(R.id.recyclerTienda);
        recyclerViewTienda.setLayoutManager(new LinearLayoutManager(getContext()));
        obtenerTienda();
        adaptadorTienda=new RecyclerViewTiendaAdaptador(obtenerTienda());
        recyclerViewTienda.setAdapter(adaptadorTienda);*/


        return vista;
    }
    private void generateList(List<RetroProducto> photoList) {
        recyclerView = getActivity().findViewById(R.id.recyclerProducto);
        adapter = new ProductoAdapter(getActivity(), photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private int getIdSharedPreference(String key){
        SharedPreferences sharedPref =getActivity().getSharedPreferences("id_preferences", Context.MODE_PRIVATE);
        return sharedPref.getInt(key,100);
    }
}