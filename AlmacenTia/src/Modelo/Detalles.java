package Modelo;

/**
 *
 * @author usuario
 */
public class Detalles {
    private int id, cantidad, id_venta;
    private String Cod_Pro;
    private double precio;

    public Detalles() {
    }

    public Detalles(int id, int cantidad, int id_venta, String Cod_Pro, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.id_venta = id_venta;
        this.Cod_Pro = Cod_Pro;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getCod_Pro() {
        return Cod_Pro;
    }

    public void setCod_Pro(String Cod_Pro) {
        this.Cod_Pro = Cod_Pro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
