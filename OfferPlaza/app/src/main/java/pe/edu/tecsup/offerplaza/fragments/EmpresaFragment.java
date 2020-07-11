package pe.edu.tecsup.offerplaza.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.adapters.RecyclerViewEmpresaAdaptador;
import pe.edu.tecsup.offerplaza.models.EmpresaModelo;
import pe.edu.tecsup.offerplaza.models.ProductoModelo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmpresaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmpresaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewEmpresa;
    private RecyclerViewEmpresaAdaptador adaptadorEmpresa;
    public List<EmpresaModelo> empresaLista;


    public EmpresaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmpresaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmpresaFragment newInstance(String param1, String param2) {
        EmpresaFragment fragment = new EmpresaFragment();
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
        View vista=inflater.inflate(R.layout.fragment_empresa, container, false);
        List<EmpresaModelo> empresa=new ArrayList<>();
        recyclerViewEmpresa=(RecyclerView)vista.findViewById(R.id.recyclerEmpresa);
        recyclerViewEmpresa.setLayoutManager(new LinearLayoutManager(getContext()));
        obtenerEmpresa();
        adaptadorEmpresa=new RecyclerViewEmpresaAdaptador(obtenerEmpresa());
        recyclerViewEmpresa.setAdapter(adaptadorEmpresa);

        return vista;

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
}

