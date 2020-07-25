package pe.edu.tecsup.offerplaza.models;

public class LoginRequest {

    private  String dni;
    private  String password;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
