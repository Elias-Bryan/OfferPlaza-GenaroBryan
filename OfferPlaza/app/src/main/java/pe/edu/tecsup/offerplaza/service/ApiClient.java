package pe.edu.tecsup.offerplaza.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String API_BASE_URL ="https://offerplaza.herokuapp.com/";
    private static Retrofit retrofit;
    private static Gson gson;


    public static Retrofit getRetrofitInstance(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        if(retrofit==null){
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();

        }
        return retrofit;

    }

    public static  InterfaceClient getInterfaceClient(){
        InterfaceClient interfaceClient = getRetrofitInstance().create(InterfaceClient.class);
        return interfaceClient;
    }
 /*   private static Retrofit gerRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://offerplaza.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static UserClient getUserClient(){
        UserClient userClient = gerRetrofit().create(UserClient.class);
        return userClient;

    }*/

}
