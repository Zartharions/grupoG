package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Modelo.Clientes;
import Modelo.ConexionBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que maneja la conexión y operaciones relacionadas con la entidad Cliente.
 * Implementa métodos para validar, registrar, listar, eliminar, actualizar y buscar clientes en la base de datos.
 */
public class ClienteConexion {
    ConexionBase cn = new ConexionBase(); // Objeto de conexión a la base de datos
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    public void validarCliente(Clientes cliente) throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException, EscrituraExcepcion {
        // Validación del CI
        
        if (cliente.getCi() <= 0 || String.valueOf(cliente.getCi()).length() != 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de exactamente 10 dígitos.");
        }
        
        if (cliente.getCi() <= 0 || String.valueOf(cliente.getCi()).length() > 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de máximo 10 dígitos.");
        }
        
        // Validación de campos obligatorios
        if (cliente.getNombre().isEmpty() || cliente.getDireccion().isEmpty() || cliente.getRazon().isEmpty()) {
            throw new EscrituraExcepcion("Debe ingresar nombre, dirección y razón social.");
        }
        
        int telefonoLength = String.valueOf(cliente.getTelefono()).length();
        if (telefonoLength != 9 && telefonoLength != 10) {
            throw new EscrituraExcepcion("Número de teléfono inválido. Debe tener 9 o 10 dígitos.");
        }
        
        // Validación de CI duplicado
        if (existeCi(cliente.getCi())) {
            throw new DatoDuplicadoExcepcion("Ya existe un cliente registrado con este CI.");
        }

        // Validación de nombre duplicado
        if (existeNombre(cliente.getNombre())) {
            throw new DatoDuplicadoExcepcion("Ya existe un cliente registrado con este nombre.");
        }
    }
    
    public void validarModificar(Clientes cliente) throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException, EscrituraExcepcion {
        // Validación del CI
        
        if (cliente.getCi() <= 0 || String.valueOf(cliente.getCi()).length() != 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de exactamente 10 dígitos.");
        }
        
        if (cliente.getCi() <= 0 || String.valueOf(cliente.getCi()).length() > 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de máximo 10 dígitos.");
        }
        
        // Validación de campos obligatorios
        if (cliente.getNombre().isEmpty() || cliente.getDireccion().isEmpty() || cliente.getRazon().isEmpty()) {
            throw new EscrituraExcepcion("Debe ingresar nombre, dirección y razón social.");
        }
        
        int telefonoLength = String.valueOf(cliente.getTelefono()).length();
        if (telefonoLength != 9 && telefonoLength != 10) {
            throw new EscrituraExcepcion("Número de teléfono inválido. Debe tener 9 o 10 dígitos.");
        }
        
  }

    public boolean RegistrarCliente(Clientes cliente) throws DatoDuplicadoExcepcion, LecturaExcepcion, NumberFormatException, EscrituraExcepcion{
        try {
            // Sentencia SQL para insertar un nuevo cliente
            String sql = "INSERT INTO Cliente (Ci, Nombre, Telefono, Direccion, Razon) VALUES(?,?,?,?,?)";
            // Validación de datos del cliente
            validarCliente(cliente);
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            // Establecer valores en la sentencia SQL
            ps.setInt(1, cliente.getCi());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getRazon());
            // Ejecutar la sentencia SQL
            ps.execute();
            return true;
        } catch (SQLException | DatoDuplicadoExcepcion | LecturaExcepcion | NumberFormatException | EscrituraExcepcion e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;        
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
  
    public List ListarClientes(){
        List<Clientes> ListaCli = new ArrayList();
        String sql = "SELECT * FROM cliente";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Clientes cl = new Clientes();
                // Conversión de datos String a entero
                cl.setId(Integer.parseInt(rs.getString("id")));
                cl.setCi(Integer.parseInt(rs.getString("Ci")));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(Integer.parseInt(rs.getString("telefono")));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));
                ListaCli.add(cl);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return ListaCli;
    }
    

    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }
    

    public boolean ActualizarCliente(Clientes cliente) throws DatoDuplicadoExcepcion, LecturaExcepcion, EscrituraExcepcion{
        try {
            // Sentencia SQL para actualizar un cliente
            String sql = "UPDATE cliente SET ci=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
            validarModificar(cliente);
            // Establecer valores en la sentencia SQL
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getCi());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getRazon());
            ps.setInt(6, cliente.getId());
            // Ejecutar la sentencia SQL
            ps.execute();
            return true;
        } catch (SQLException | NumberFormatException | EscrituraExcepcion e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    } 
    
  
    public Clientes BuscarCliente(int ci){
        Clientes cl = new Clientes();
        String sql = "SELECT * FROM cliente WHERE ci = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ci);
            rs = ps.executeQuery();
            if(rs.next()){
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return cl;
    }
    

    private boolean existeCi(int ci) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente WHERE Ci=?";
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, ci);
        rs = ps.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    }
    

    private boolean existeNombre(String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente WHERE Nombre=?";
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    }
    
}
