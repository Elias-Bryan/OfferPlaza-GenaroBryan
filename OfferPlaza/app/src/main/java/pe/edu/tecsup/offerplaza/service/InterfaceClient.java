package pe.edu.tecsup.offerplaza.service;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import pe.edu.tecsup.offerplaza.models.LoginResponse;
import pe.edu.tecsup.offerplaza.models.RetroEmpresa;
import pe.edu.tecsup.offerplaza.models.RetroProducto;
import pe.edu.tecsup.offerplaza.models.UserRequest;
import pe.edu.tecsup.offerplaza.models.UserResponse;
import pe.edu.tecsup.offerplaza.models.LoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfaceClient {

    @GET("empresas/{idcliente}")
    Call<List<RetroEmpresa>> getAllEmpresa(@Path("idcliente") int idcliente);



    /*@POST("auth")
    Call<LoginResponse> userLogin(
            @Field("dni")String dni,
            @Field("password")String password
    );*/
    @POST("registro")
    Call<UserResponse> saveUser(@Body UserRequest userRequest);
    @POST("auth")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("categoria/C1/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria1(@Path("idcliente") int idcliente);

    @GET("categoria/C2/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria2(@Path("idcliente") int idcliente);

    @GET("categoria/C3/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria3(@Path("idcliente") int idcliente);

    @GET("categoria/C4/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria4(@Path("idcliente") int idcliente);

    @GET("categoria/C5/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria5(@Path("idcliente") int idcliente);

    @GET("categoria/C6/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria6(@Path("idcliente") int idcliente);

    @GET("categoria/C7/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria7(@Path("idcliente") int idcliente);

    @GET("categoria/C8/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria8(@Path("idcliente") int idcliente);

    @GET("categoria/C9/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria9(@Path("idcliente") int idcliente);

    @GET("categoria/C10/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria10(@Path("idcliente") int idcliente);

    @GET("categoria/C11/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria11(@Path("idcliente") int idcliente);

    @GET("categoria/C12/{idcliente}")
    Call<List<RetroProducto>> getAllCategoria12(@Path("idcliente") int idcliente);

    @GET("buscar/{idcliente}")
    Call<List<RetroProducto>> getAllProductos(@Path("idcliente") int idcliente);





}



