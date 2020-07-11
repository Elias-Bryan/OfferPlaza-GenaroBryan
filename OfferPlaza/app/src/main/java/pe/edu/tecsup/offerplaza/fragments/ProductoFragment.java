package pe.edu.tecsup.offerplaza.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.RecyclerViewProductoAdaptador;
import pe.edu.tecsup.offerplaza.models.ProductoModelo;

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
    private RecyclerView recyclerViewProducto;
    private RecyclerViewProductoAdaptador adaptadorProducto;
    private EditText editText;


    public List<ProductoModelo> obtenerProductos;

    public ProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductosFragment.
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
        editText=(EditText)vista.findViewById(R.id.p_busqueda);

        List<ProductoModelo> productoLista;
        recyclerViewProducto=(RecyclerView)vista.findViewById(R.id.recyclerProducto);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(getContext()));
        obtenerProductos();
        adaptadorProducto=new RecyclerViewProductoAdaptador(obtenerProductos());
        recyclerViewProducto.setAdapter(adaptadorProducto);

        return vista;
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

    public void btn_adquirir (View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/jetpack/androidx/releases/gridlayout?hl=es"));
        startActivity(i);
    }
}
