package Modelo;

/**
 * Clase que representa a un cliente con sus atributos.
 * Contiene métodos para acceder y modificar la información del cliente.
 * 
 * Nota: Puede ser útil agregar validaciones o métodos específicos según las necesidades del sistema.
 * Por ejemplo, validar la longitud de las cadenas, o proporcionar un método toString().
 * 
 * @author usuario
 */
public class Clientes {
    private int Id, Ci, Telefono;
    private String Nombre, Direccion, Razon;

    // Constructor vacío, necesario para algunos frameworks de persistencia.
    public Clientes() {
    }

    // Constructor con todos los atributos.
    public Clientes(int Id, int Ci, int Telefono, String Nombre, String Direccion, String Razon) {
        this.Id = Id;
        this.Ci = Ci;
        this.Telefono = Telefono;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Razon = Razon;
    }

    // Métodos getter y setter para acceder y modificar los atributos.

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCi() {
        return Ci;
    }

    public void setCi(int Ci) {
        this.Ci = Ci;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getRazon() {
        return Razon;
    }

    public void setRazon(String Razon) {
        this.Razon = Razon;
    }

    // Podrías agregar otros métodos según las necesidades del sistema, como validaciones o toString().
}
