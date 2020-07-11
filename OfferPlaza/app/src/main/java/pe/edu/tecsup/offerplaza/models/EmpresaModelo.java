package pe.edu.tecsup.offerplaza.models;

public class EmpresaModelo {
    private String nombre,sede;
    private int rating,imgEmpresa;

    public EmpresaModelo(String nombre, String sede,  int rating, int imgEmpresa) {
        this.nombre = nombre;
        this.sede = sede;
        this.rating = rating;
        this.imgEmpresa = imgEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getRating() { return rating; }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImgEmpresa() { return imgEmpresa; }

    public void setImgEmpresa(int imgEmpresa) {
        this.imgEmpresa = imgEmpresa;
    }
}
