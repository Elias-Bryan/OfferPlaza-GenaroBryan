package pe.edu.tecsup.offerplaza.models;
public class RetroEmpresa {
    private Integer idempresa;
    private String nombre;
    private String logo;
    private String likes;
    private String productos;

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

    public String getLogo() {
        return "https://5ffc9dbf6589.ngrok.io/v1/producto/img/"+logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String  getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

}
