package pe.edu.tecsup.offerplaza.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.fragments.CategoryFragment;
import pe.edu.tecsup.offerplaza.fragments.PerfilFragment;
import pe.edu.tecsup.offerplaza.fragments.ProductoFragment;
import pe.edu.tecsup.offerplaza.fragments.TiendaFragment;
import pe.edu.tecsup.offerplaza.interfaces.IComunicaFragments;

public class Home extends AppCompatActivity implements IComunicaFragments {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar =findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CategoryFragment()).commit();
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.tb_buscar:
                Toast.makeText(this,"hola bb",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.m_categorias:
                            selectedFragment = new CategoryFragment();
                            break;
                        case R.id.m_tiendas:
                            selectedFragment = new TiendaFragment();
                            break;
                        case R.id.m_productos:
                            selectedFragment = new ProductoFragment();
                            break;
                        case R.id.m_perfil:
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
        /*Intent intent = new Intent(this, Productos.class);
        startActivity(intent);*/
    }
}

