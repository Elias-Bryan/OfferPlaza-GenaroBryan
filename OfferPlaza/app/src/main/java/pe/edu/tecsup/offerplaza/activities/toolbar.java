package pe.edu.tecsup.offerplaza.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import pe.edu.tecsup.offerplaza.R;
import androidx.appcompat.widget.Toolbar;

public class toolbar extends AppCompatActivity {

    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
