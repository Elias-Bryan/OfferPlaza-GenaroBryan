package pe.edu.tecsup.offerplaza.models;

public class ProductoModelo {
    private String nombre,sede,stock,precio;
    private int imgProducto;

    public ProductoModelo(String nombre, String sede, String stock, String precio, int imgProducto) {
        this.nombre = nombre;
        this.sede = sede;
        this.stock = stock;
        this.precio = precio;
        this.imgProducto = imgProducto;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImgProducto() {
        return imgProducto;
    }

    public void setImgProducto(int imgProducto) {
        this.imgProducto = imgProducto;
    }
}
