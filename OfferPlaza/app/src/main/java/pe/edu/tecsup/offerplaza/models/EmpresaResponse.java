package pe.edu.tecsup.offerplaza.models;

import android.os.strictmode.IntentReceiverLeakedViolation;

public class EmpresaResponse {
    private String photo;
    private String razon_social;
    private String nombre_comercial;
    private String domicilio_fiscal;

    public String getRazon_social() {
        return razon_social;
    }
    public void setRazon_social(String razon_social) { this.razon_social = razon_social;
    }
    public String getNombre_comercial() {
        return nombre_comercial;
    }
    public void setNombre_comercial(String nombre_comercial) { this.nombre_comercial = nombre_comercial;
    }
    public String getDomicilio_fiscal() { return domicilio_fiscal; }
    public void setDomicilio_fiscal(String domicilio_fiscal) { this.domicilio_fiscal = domicilio_fiscal;
    }
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo;
    }

    @Override
    public String toString() {
        return "EmpresaResponse{" +
                "photo='" + photo + '\'' +
                "razon_social='" + razon_social + '\'' +
                ", nombre_comercial='" + nombre_comercial + '\'' +
                ", domicilio_fiscal='" + domicilio_fiscal + '\'' +
                '}';
    }
}
