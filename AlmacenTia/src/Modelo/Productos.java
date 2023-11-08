package Modelo;

/*
 Clase que representa un producto en el sistema.
 Contiene atributos como ID, código, nombre, precio y cantidad.
 */

public class Productos {
    private int id; // Identificador único del producto
    private int codigo; // Código del producto
    private String nombre; // Nombre del producto
    private Double precio; // Precio del producto
    private int cantidad;  // Cantidad disponible en inventario

    
    // Métodos getter y setter para acceder y modificar los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
