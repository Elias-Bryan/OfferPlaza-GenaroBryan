package pe.edu.tecsup.offerplaza.service;

import java.util.List;

import okhttp3.ResponseBody;
import pe.edu.tecsup.offerplaza.models.EmpresaResponse;
import pe.edu.tecsup.offerplaza.models.Login;
import pe.edu.tecsup.offerplaza.models.User;
import pe.edu.tecsup.offerplaza.models.UserRequest;
import pe.edu.tecsup.offerplaza.models.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Header;


public interface InterfaceClient {

    @GET("v1/listar/empresa")
    Call<List<EmpresaResponse>> getAllEmpresa();

    @POST("login")
    Call<String> checkLogin(@Header("Authorization") String authToken);

    @GET("secretinfo")
    Call<ResponseBody> getSecret(@Header("Authorization")String authToken);

    @POST("users/")
    Call<UserResponse> saveUser(@Body UserRequest userRequest);
}
