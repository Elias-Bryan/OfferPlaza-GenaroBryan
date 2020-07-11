package pe.edu.tecsup.offerplaza.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.UserRequest;
import pe.edu.tecsup.offerplaza.models.UserResponse;
import pe.edu.tecsup.offerplaza.service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Registro extends AppCompatActivity {

    TextView tv_login;
    Button btn_registro;
    private EditText reg_nombre,reg_DNI,reg_correo,reg_phono,reg_password,conf_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        reg_nombre = findViewById(R.id.reg_nombre);
        reg_DNI = findViewById(R.id.reg_DNI);
        reg_correo= findViewById(R.id.reg_correo);
        reg_phono = findViewById(R.id.reg_phone);
        reg_password = findViewById(R.id.reg_password);
        conf_password = findViewById(R.id.conf_password);
        btn_registro=findViewById(R.id.btn_registro);
        tv_login=findViewById(R.id.tv_login);
        btn_registro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveUser(createRequest());
                if (validar())
                {
                    Intent intentReg= new Intent(Registro.this, Home.class);
                    Registro.this.startActivity(intentReg);}
            }
        });


        tv_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentLog= new Intent(Registro.this, LoginActivity.class);
                Registro.this.startActivity(intentLog);

            }


        });
    }
    public UserRequest createRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setNombre(reg_nombre.getText().toString());
        userRequest.setDni(reg_DNI.getText().toString());
        userRequest.setEmail(reg_correo.getText().toString());
        userRequest.setPhone(reg_phono.getText().toString());
        userRequest.setPassword(reg_password.getText().toString());

        return userRequest;
    }

    public void saveUser(UserRequest userRequest){
        Call<UserResponse> userResponseCall = ApiClient.getInterfaceClient().saveUser(userRequest);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(Registro.this,"Saved succes",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Registro.this,"Saved faild",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(Registro.this,"Saved succes"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }




    public boolean validar()
    {
        boolean retorno=true;
        String c1=reg_nombre.getText().toString();
        String c2=reg_DNI.getText().toString();
        String c3=reg_correo.getText().toString();
        String c4=reg_phono.getText().toString();
        String c5=reg_password.getText().toString();
        String c6=conf_password.getText().toString();

        if(c1.isEmpty())
        {
            reg_nombre.setError("Este campo no puede quedar vacio");
            retorno=false;
        }
        if(c2.isEmpty())
        {
            reg_DNI.setError("Este campo no puede quedar vacio");
            retorno=false;
        }
        if(c3.isEmpty())
        {
            reg_correo.setError("Este campo no puede quedar vacio");
            retorno=false;
        }
        if(c4.isEmpty())
        {
            reg_phono.setError("Este campo no puede quedar vacio");
            retorno=false;
        }
        if(c5.isEmpty())
        {
            reg_password.setError("Este campo no puede quedar vacio");
            retorno=false;
        }
        if(c6.isEmpty())
        {
            conf_password.setError("Este campo no puede quedar vacio");
            retorno=false;
        }


        return retorno;
    }
}

