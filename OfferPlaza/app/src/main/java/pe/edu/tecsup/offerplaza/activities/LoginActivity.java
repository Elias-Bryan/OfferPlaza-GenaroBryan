package pe.edu.tecsup.offerplaza.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.LoginRequest;
import pe.edu.tecsup.offerplaza.models.LoginResponse;
import pe.edu.tecsup.offerplaza.models.UserRequest;
import pe.edu.tecsup.offerplaza.models.UserResponse;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    TextView tv_registrar;
    Button btn_login;
    private EditText dniTxt, passTxt;
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

        dniTxt = findViewById(R.id.tv_user);
        passTxt = findViewById(R.id.tv_password);
        btn_login=findViewById(R.id.btn_Login);
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                userLogin(createRequest());
            }
        });

        /*btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (validar())
                {
                    dni = dniTxt.getText().toString();
                    password = passTxt.getText().toString();

                }
            }
        });*/
    }
    public LoginRequest createRequest(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setDni(dniTxt.getText().toString());
        loginRequest.setPassword(passTxt.getText().toString());
        return loginRequest;
    }
    public void userLogin(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getInterfaceClient().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(Objects.equals("0",response.body().getErrorCode() )){
                    final String Nombre=response.body().getUsuario().getNombres();
                    final int Id=response.body().getUsuario().getIdcliente();
                    final String Correo=response.body().getUsuario().getCelular();
                    final String Celular=response.body().getUsuario().getCorreo();
                    final String Dni = dniTxt.getText().toString();
                    saveIdSharedPreference(Id);
                    saveNombreSharedPreference(Nombre);
                    saveCorreoSharedPreference(Correo);
                    saveCelularSharedPreference(Celular);
                    if (validar())
                    {
                        String nombre = getNombreSharedPreference("nombre");

                        Toast.makeText(LoginActivity.this,"Bienvenido "+nombre,Toast.LENGTH_LONG).show();
                        Intent intentReg= new Intent(LoginActivity.this, Home.class);
                        LoginActivity.this.startActivity(intentReg);
                    }
                }else{
                    Toast.makeText(LoginActivity.this,"Ingrese bien sus credenciales",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Saved successs"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
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
    private void saveNombreSharedPreference(String Nombre){
        //(Esto se usa si se si hiciera en un fragment)SharedPreferences sharedPref =getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences("nombre_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nombre",Nombre);
        editor.apply();
    }
    private void saveIdSharedPreference(int Id){
        //(Esto se usa si se si hiciera en un fragment)SharedPreferences sharedPref =getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences("id_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("id",Id);
        editor.apply();
    }
    private void saveCorreoSharedPreference(String Correo){
        //(Esto se usa si se si hiciera en un fragment)SharedPreferences sharedPref =getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences("correo_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("correo",Correo);
        editor.apply();
    }
    private void saveCelularSharedPreference(String Celular){
        //(Esto se usa si se si hiciera en un fragment)SharedPreferences sharedPref =getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences("celular_preferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("celular",Celular);
        editor.apply();
    }
    private String getNombreSharedPreference(String key){
        SharedPreferences sharedPref = getSharedPreferences("nombre_preferences",Context.MODE_PRIVATE);
        return sharedPref.getString(key,"");
    }


    /*private void checkLoginDeatils(String authToken) {
        Retrofit retrofit = ApiClient.getRetrofitInstance();
        final InterfaceClient api = retrofit.create(InterfaceClient.class);

        Call<String> call = api.checkLogin(authToken);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().matches("success")){
                        Toast.makeText(LoginActivity.this,"Saved succeslll",Toast.LENGTH_LONG).show();
                }

                else{
                        Toast.makeText(LoginActivity.this,"error",Toast.LENGTH_LONG).show();
                    }
                    //handle
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Esta mal la conexion"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                Log.e("TAG", t.toString());
                t.printStackTrace();

            }
        });
    }*/

    /*private String createAuthToken(String dni, String password) {
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
    }*/
    /*public void userLogin(){

        String dni = dniTxt.getText().toString().trim();
        String password = passTxt.getText().toString().trim();
        if (dni.isEmpty()){
            dniTxt.setError("Email is requerid");
            dniTxt.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passTxt.setError("password Requerid");
            passTxt.requestFocus();
            return;
        }

        Call<LoginResponse> call = ApiClient.getInterfaceClient().userLogin(dni,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if(loginResponse.getError() == "0"){
                    Toast.makeText(LoginActivity.this,"Login exitoso",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this,"login faild",Toast.LENGTH_LONG).show();
                }

                }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"conexion failed"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
*/

}