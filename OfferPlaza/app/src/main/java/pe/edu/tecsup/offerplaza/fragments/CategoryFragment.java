package pe.edu.tecsup.offerplaza.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.tecsup.offerplaza.Categorias.Categoria1;
import pe.edu.tecsup.offerplaza.Categorias.Categoria10;
import pe.edu.tecsup.offerplaza.Categorias.Categoria11;
import pe.edu.tecsup.offerplaza.Categorias.Categoria12;
import pe.edu.tecsup.offerplaza.Categorias.Categoria2;
import pe.edu.tecsup.offerplaza.Categorias.Categoria3;
import pe.edu.tecsup.offerplaza.Categorias.Categoria4;
import pe.edu.tecsup.offerplaza.Categorias.Categoria5;
import pe.edu.tecsup.offerplaza.Categorias.Categoria6;
import pe.edu.tecsup.offerplaza.Categorias.Categoria7;
import pe.edu.tecsup.offerplaza.Categorias.Categoria8;
import pe.edu.tecsup.offerplaza.Categorias.Categoria9;
import pe.edu.tecsup.offerplaza.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View vista;
    CardView cat_c1,cat_c2,cat_c3,cat_c4,cat_c5,cat_c6,cat_c7,cat_c8,cat_c9,cat_c10,cat_c11,cat_c12;



    public CategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Category.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
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
        View vista=inflater.inflate(R.layout.fragment_category, container, false);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(tb_category);
        cat_c1=(CardView)vista.findViewById(R.id.cat_c1);
        cat_c2=(CardView)vista.findViewById(R.id.cat_c2);
        cat_c3=(CardView)vista.findViewById(R.id.cat_c3);
        cat_c4=(CardView)vista.findViewById(R.id.cat_c4);
        cat_c5=(CardView)vista.findViewById(R.id.cat_c5);
        cat_c6=(CardView)vista.findViewById(R.id.cat_c6);
        cat_c7=(CardView)vista.findViewById(R.id.cat_c7);
        cat_c8=(CardView)vista.findViewById(R.id.cat_c8);
        cat_c9=(CardView)vista.findViewById(R.id.cat_c9);
        cat_c10=(CardView)vista.findViewById(R.id.cat_c10);
        cat_c11=(CardView)vista.findViewById(R.id.cat_c11);
        cat_c12=(CardView)vista.findViewById(R.id.cat_c12);

        cat_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria1.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria2.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria3.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria4.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria5.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria6.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria7.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria8.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria9.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria10.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria11.class);
                getActivity().startActivity(intentReg);
            }
        });
        cat_c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(getActivity(), Categoria12.class);
                getActivity().startActivity(intentReg);
            }
        });


        return vista;
    }
}
