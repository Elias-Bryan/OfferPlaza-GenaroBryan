package pe.edu.tecsup.offerplaza.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.activities.LoginActivity;
import pe.edu.tecsup.offerplaza.interfaces.IComunicaFragments;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private TextView p_nombre,p_correo,p_celular;
    View vista;
    Activity actividad;
    CardView cardFavoritos;
    IComunicaFragments interfaceComunicaFragments;





    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context){
            super.onAttach(context);
            if(context instanceof Activity){
                actividad= (Activity)context;
                interfaceComunicaFragments=(IComunicaFragments) actividad;
            }
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
        vista=inflater.inflate(R.layout.fragment_perfil, container, false);

        p_nombre=(TextView) vista.findViewById(R.id.nom_perfil);
        p_celular=(TextView) vista.findViewById(R.id.celular_perfil);
        p_correo=(TextView) vista.findViewById(R.id.correo_perfil);
        p_nombre.setText(getNombreSharedPreference("nombre"));
        p_correo.setText(getCorreoSharedPreference("correo"));
        p_celular.setText(getCelularSharedPreference("celular"));




        return vista;
    }


    /*private String getNombrepSharedPreference(String key){
        SharedPreferences sharedPref =getActivity().getSharedPreferences("nombrep_preference",Context.MODE_PRIVATE);
        return sharedPref.getString(key,"");
    }*/
    private String getNombreSharedPreference(String key){
        SharedPreferences sharedPref = getActivity().getSharedPreferences("nombre_preferences",Context.MODE_PRIVATE);
        return sharedPref.getString(key,"");
    }
    private String getCorreoSharedPreference(String key){
        SharedPreferences sharedPref = getActivity().getSharedPreferences("correo_preferences",Context.MODE_PRIVATE);
        return sharedPref.getString(key,"");
    }
    private String getCelularSharedPreference(String key){
        SharedPreferences sharedPref = getActivity().getSharedPreferences("celular_preferences",Context.MODE_PRIVATE);
        return sharedPref.getString(key,"");
    }



}
