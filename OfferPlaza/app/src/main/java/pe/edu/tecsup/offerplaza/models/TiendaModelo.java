package pe.edu.tecsup.offerplaza.models;

public class TiendaModelo {
    private String nombre,like,n_producto;
    private int imgTienda;

    public TiendaModelo(String nombre, String like, String n_producto, int imgTienda) {
        this.nombre = nombre;
        this.like = like;
        this.n_producto = n_producto;
        this.imgTienda = imgTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getN_producto() {
        return n_producto;
    }

    public void setN_producto(String n_producto) {
        this.n_producto = n_producto;
    }

    public int getImgTienda() {
        return imgTienda;
    }

    public void setImgTienda(int imgTienda) {
        this.imgTienda = imgTienda;
    }
}
