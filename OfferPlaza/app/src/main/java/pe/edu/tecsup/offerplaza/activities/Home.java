package pe.edu.tecsup.offerplaza.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.fragments.EmpresaFragment;
import pe.edu.tecsup.offerplaza.fragments.FavoritoFragment;
import pe.edu.tecsup.offerplaza.fragments.PerfilFragment;
import pe.edu.tecsup.offerplaza.fragments.ProductoFragment;
import pe.edu.tecsup.offerplaza.interfaces.IComunicaFragments;

public class Home extends AppCompatActivity implements IComunicaFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new EmpresaFragment()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_empresa:
                            selectedFragment = new EmpresaFragment();
                            break;
                        case R.id.nav_busqueda:
                            selectedFragment = new ProductoFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new PerfilFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public void favoritos() {
//        Toast.makeText(getApplicationContext(), "iniciar juego desde el activity", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, Productos.class);
        startActivity(intent);
    }
}

