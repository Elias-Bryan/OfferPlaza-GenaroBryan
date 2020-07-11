package pe.edu.tecsup.offerplaza.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.EmpresaResponse;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import pe.edu.tecsup.offerplaza.service.InterfaceClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LoginActivity extends AppCompatActivity {

    TextView tv_registrar;
    private Button btn_login;
    private EditText dniTxt, passTxt;
    private String dni,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_registrar=(TextView) findViewById(R.id.tv_registrar);
        tv_registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentReg= new Intent(LoginActivity.this, Registro.class);
                LoginActivity.this.startActivity(intentReg);
            }
        });
        btn_login = findViewById(R.id.btn_Login);
        dniTxt = findViewById(R.id.tv_user);
        passTxt = findViewById(R.id.tv_password);



        /*Call<List<EmpresaResponse>> empresaList = ApiClient.getUserClient().getAllEmpresa();
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

            }});*/
    }
    public void agregar(View v)
    {
        if (validar())
        {
            btn_login.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    dni = dniTxt.getText().toString();
                    password = passTxt.getText().toString();
                    String authToken = createAuthToken(dni,password);
                    checkLoginDeatils(authToken);
                    Intent intentReg= new Intent(LoginActivity.this, Home.class);
                    LoginActivity.this.startActivity(intentReg);
                }
            });
        }
    }
    public boolean validar()
    {
        boolean retorno=true;
        String c1=dniTxt.getText().toString();
        String c2=passTxt.getText().toString();
        if(c1.isEmpty())
        {
            dniTxt.setError("Este campo no puede quedar vacio");
            retorno=false;
        }
        if(c2.isEmpty())
        {
            passTxt.setError("Este campo no puede quedar vacio");
            retorno=false;
        }

        return retorno;
    }

    private void checkLoginDeatils(String authToken) {
        Retrofit retrofit = ApiClient.getRetrofitInstance();
        final InterfaceClient api = retrofit.create(InterfaceClient.class);

        Call<String> call = api.checkLogin(authToken);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().matches("success")){

                        Toast.makeText(getApplicationContext(), "login exitoso",Toast.LENGTH_LONG).show();
                }

                else{
                        Toast.makeText(getApplicationContext(), "error",Toast.LENGTH_LONG).show();
                    }
                    //handle
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("TAG", t.toString());
                t.printStackTrace();

            }
        });
    }

    private String createAuthToken(String dni, String password) {
        byte[] data= new byte[0];
        try {
            data = (dni + ":" + password).getBytes("UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return  "Basic" + Base64.encodeToString(data, Base64.NO_WRAP);

    }
    public void btn_forgot (View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://codinginflow.com/tutorials/android/bottomnavigationview"));
        startActivity(i);
    }

}