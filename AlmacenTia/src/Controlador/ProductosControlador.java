package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.LecturaExcepcion;
import Modelo.ConexionBase;
import Modelo.Config;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Controlador para la gestión de productos y configuraciones.
 */
public class ProductosControlador {
    Connection con;
    ConexionBase cn = new ConexionBase();
    PreparedStatement ps;
    ResultSet rs;

    /**
     * Registra un nuevo producto en la base de datos.
     * @param pro Objeto Productos con la información del producto.
     * @return true si se registra correctamente, false en caso contrario.
     * @throws Excepciones.DatoDuplicadoExcepcion
     */
    public boolean RegistrarProductos(Productos pro) throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException, IllegalArgumentException {
        String sql = "INSERT INTO productos(codigo,nombre,proveedor,stock,precio) VALUES (?,?,?,?,?) ";
        try {
            con = cn.getConexion();

            // Validación de datos vacíos
            if (pro.getCodigo().isEmpty() || pro.getNombre().isEmpty() || pro.getProveedor().isEmpty()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }

            // Validación de código duplicado
            if (existeCodigo(pro.getCodigo())) {
                throw new DatoDuplicadoExcepcion("Ya existe un producto registrado con este código.");
            }

            // Validación de nombre duplicado
            if (existeNombre(pro.getNombre())) {
                throw new DatoDuplicadoExcepcion("Ya existe un producto registrado con este nombre.");
            }

            // Validación de stock y precio no negativos
            if (pro.getStock() <= 0 || pro.getPrecio() <= 0) {
                throw new IllegalArgumentException("El stock y el precio deben ser mayores a cero.");
            }

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException | DatoDuplicadoExcepcion | IllegalArgumentException e) {
            mostrarMensajeDeError(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    private void cerrarConexion() throws LecturaExcepcion, SQLException {
        try {
            con.close();
        } catch (SQLException ex) {
            throw new SQLException("Error al cerrar la conexión.", ex);
        }
    }

    /**
     * Consulta y llena un JComboBox con los nombres de los proveedores.
     * @param Proveedor JComboBox a llenar con los nombres de los proveedores.
     * @return true si se consulta correctamente, false en caso contrario.
     */
    public boolean ConsultarProveedor(JComboBox Proveedor) {
        String sql = "SELECT nombre FROM proveedor";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor.addItem(rs.getString("nombre"));
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Lista todos los productos en una lista.
     * @return Lista de objetos Productos con la información de los productos.
     */
    public List ListarProductos() {
        List<Productos> ListaProduct = new ArrayList();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setProveedor(rs.getString("proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
                ListaProduct.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaProduct;
    }

    /**
     * Lista todas las configuraciones en una lista.
     * @return Lista de objetos Config con la información de las configuraciones.
     */
    public List ListarConfig() {
        List<Config> ListaConf = new ArrayList();
        String sql = "SELECT * FROM config";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Config conf = new Config();
                conf.setId(rs.getInt("id"));
                conf.setRuc(rs.getInt("ruc"));
                conf.setNombre(rs.getString("nombre"));
                conf.setTelefono(rs.getInt("telefono"));
                conf.setDireccion(rs.getString("direccion"));
                conf.setRazon(rs.getString("razon"));
                ListaConf.add(conf);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaConf;
    }

    /**
     * Elimina un producto de la base de datos.
     * @param id ID del producto a eliminar.
     * @return true si se elimina correctamente, false en caso contrario.
     */
    public boolean EliminarProductos(int id) throws LecturaExcepcion, SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            throw new SQLException("Error al eliminar el producto de la base de datos.", ex);
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Actualiza la información de un producto en la base de datos.
     * @param pro Objeto Productos con la nueva información del producto.
     * @return true si se actualiza correctamente, false en caso contrario.
     */
    public boolean ActualizarProveedor(Productos pro) throws IllegalArgumentException {
        String sql = "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?";
        try {
            if (pro.getCodigo().isEmpty() || pro.getNombre().isEmpty() || pro.getProveedor().isEmpty()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }
              
            
            // Validación de stock y precio no negativos
            if (pro.getStock() <= 0 || pro.getPrecio() <= 0) {
                throw new IllegalArgumentException("El stock y el precio deben ser mayores a cero.");
            }
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException | IllegalArgumentException e) {
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

    /**
     * Busca un producto por su código en la base de datos.
     * @param cod Código del producto a buscar.
     * @return Objeto Productos con la información del producto encontrado.
     */
    public Productos BuscarPro(String cod) {
        Productos product = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                product.setNombre(rs.getString("nombre"));
                product.setPrecio(rs.getInt("precio"));
                product.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return product;
    }

    /**
     * Actualiza la información de configuración en la base de datos.
     * @param conf Objeto Config con la nueva información de configuración.
     * @return true si se actualiza correctamente, false en caso contrario.
     */
    public boolean ActualizarDatos(Config conf) {
        String sql = "UPDATE config SET ruc=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, conf.getRuc());
            ps.setString(2, conf.getNombre());
            ps.setInt(3, conf.getTelefono());
            ps.setString(4, conf.getDireccion());
            ps.setString(5, conf.getRazon());
            ps.setInt(6, conf.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    private boolean existeCodigo(String codigo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM productos WHERE codigo=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, codigo);
        rs = ps.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    }

    private boolean existeNombre(String nombre) throws SQLException {
        String sql = "SELECT COUNT(*) FROM productos WHERE nombre=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        return rs.next() && rs.getInt(1) > 0;
    }

    private void mostrarMensajeDeError(String mensaje) {
        // Mostrar mensaje de error usando JOptionPane
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
