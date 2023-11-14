package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Modelo.Clientes;
import Modelo.ConexionBase;
import Modelo.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que gestiona la conexión y operaciones con la tabla proveedor en la base de datos.
 */
public class ProveedorConex {
    private Connection con;
    private ConexionBase cn = new ConexionBase();
    private PreparedStatement ps;
    private ResultSet rs;
    
    public void validarProveedor(Proveedor proveedor) throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException, EscrituraExcepcion {
        // Validación del CI
        
        if (proveedor.getRuc() <= 0 || String.valueOf(proveedor.getRuc()).length() != 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de exactamente 10 dígitos.");
        }
        
        if (proveedor.getRuc() <= 0 || String.valueOf(proveedor.getRuc()).length() > 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de máximo 10 dígitos.");
        }
        
        // Validación de campos obligatorios
        if (proveedor.getNombre().isEmpty() || proveedor.getDireccion().isEmpty() || proveedor.getRazon().isEmpty()) {
            throw new EscrituraExcepcion("Debe ingresar nombre, dirección y razón social.");
        }
        
        int telefonoLength = String.valueOf(proveedor.getTelefono()).length();
        if (telefonoLength != 9 && telefonoLength != 10) {
            throw new EscrituraExcepcion("Número de teléfono inválido. Debe tener 9 o 10 dígitos.");
        }
        
        // Validación de CI duplicado
        if (existeRuc(proveedor.getRuc())) {
            throw new DatoDuplicadoExcepcion("Ya existe un proveedor registrado con este CI.");
        }

        // Validación de nombre duplicado
        if (existeProveedor(proveedor.getNombre())) {
            throw new DatoDuplicadoExcepcion("Ya existe un proveedor registrado con este nombre.");
        }
    }

    public void validarModificar(Proveedor proveedor) throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException, EscrituraExcepcion {
        // Validación del CI
        
        if (proveedor.getRuc() <= 0 || String.valueOf(proveedor.getRuc()).length() != 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de exactamente 10 dígitos.");
        }
        
        if (proveedor.getRuc() <= 0 || String.valueOf(proveedor.getRuc()).length() > 10) {
            throw new EscrituraExcepcion("CI inválido. Debe ser un número positivo de máximo 10 dígitos.");
        }
        
        // Validación de campos obligatorios
        if (proveedor.getNombre().isEmpty() || proveedor.getDireccion().isEmpty() || proveedor.getRazon().isEmpty()) {
            throw new EscrituraExcepcion("Debe ingresar nombre, dirección y razón social.");
        }
        
        int telefonoLength = String.valueOf(proveedor.getTelefono()).length();
        if (telefonoLength != 9 && telefonoLength != 10) {
            throw new EscrituraExcepcion("Número de teléfono inválido. Debe tener 9 o 10 dígitos.");
        }
        
  }
    
    public boolean RegistrarProveedor(Proveedor pr) throws DatoDuplicadoExcepcion, LecturaExcepcion, EscrituraExcepcion {
        String sql = "INSERT INTO proveedor(ruc, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?) ";
        try {
            con = cn.getConexion();
            validarProveedor(pr);
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.execute();
            return true;
        } catch (SQLException | IllegalArgumentException | EscrituraExcepcion | LecturaExcepcion e) {
            mostrarMensajeDeError(e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    public List<Proveedor> ListarProveedor() {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pr = new Proveedor();
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getInt("Ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getInt("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setRazon(rs.getString("razon"));
                listaProveedores.add(pr);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            cerrarConexion();
        }
        return listaProveedores;
    }

    public boolean EliminarProveedor(int id) {
        String sql = "DELETE FROM proveedor WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            mostrarMensajeDeError(e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    public boolean ActualizarProveedor(Proveedor pr) throws LecturaExcepcion, EscrituraExcepcion {
        String sql = "UPDATE proveedor SET ruc=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try {
            con = cn.getConexion();
            validarModificar(pr);
            // Validación de campos obligatorios
            

            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getRazon());
            ps.setInt(6, pr.getId());
            ps.execute();
            return true;
        } catch (SQLException | IllegalArgumentException | DatoDuplicadoExcepcion | EscrituraExcepcion | LecturaExcepcion e) {
            mostrarMensajeDeError(e.getMessage());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    private boolean existeRuc(int ruc) throws SQLException {
        String sql = "SELECT COUNT(*) FROM proveedor WHERE Ruc=?";
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, ruc);
        rs = ps.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    }

    private boolean existeProveedor(String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente WHERE Nombre=?";
        con = cn.getConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    }

    private void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    private void mostrarMensajeDeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
