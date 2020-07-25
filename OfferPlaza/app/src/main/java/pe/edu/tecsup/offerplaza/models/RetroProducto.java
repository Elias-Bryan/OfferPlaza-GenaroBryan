package pe.edu.tecsup.offerplaza.models;

public class RetroProducto {
    private Integer idproducto;
    private Integer idempresa;
    private String nombre;
    private String precio;
    private String descuento;
    private String imagen;
    private String fechaTermino;
    private String url;

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getImagen() {
        return "https://5ffc9dbf6589.ngrok.io/v1/producto/img/"+imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
