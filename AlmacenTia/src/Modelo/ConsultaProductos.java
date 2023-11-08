package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Excepciones.DatoDuplicadoExcepcion;
// Clase que se encarga de realizar consultas y operaciones en la base de datos
public class ConsultaProductos extends ConexionBase {
    
    
    // Método para registrar un producto en la base de datos
    public boolean registrar(Productos pro) throws EscrituraExcepcion, DatoDuplicadoExcepcion{
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO productos (codigo, nombre, precio , cantidad) VALUES(?,?,?,?)";
            
        if (pro.getCodigo() <= 0 ){
            throw new EscrituraExcepcion("No se permite guardar Códigos menores o iguales a cero");
            
        }
        if ("".equals(pro.getNombre())){
            throw new EscrituraExcepcion("No se permite guardar: campo 'Nombre' se encuentra vacío");
        }
        
        if(pro.getPrecio() <= 0 || pro.getCantidad() <= 0 ){
            throw new EscrituraExcepcion("No se permite guardar si hay campos menores o igual a 0'");
        }
        
        // Verificar si el código ya existe en la base de datos
        if (codigoExiste(con, pro.getCodigo())) {
            throw new DatoDuplicadoExcepcion("El código ya existe en la base de datos");
        }
       
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo()); 
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.execute();
            return true;    // Éxito: registro guardado en la base de datos
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;   // Error: no se pudo guardar el registro
           
        }
        
         finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    // Método para modificar un producto en la base de datos
    public boolean modificar(Productos pro) throws EscrituraExcepcion, DatoDuplicadoExcepcion{
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE productos SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=? ";
        
        if (pro.getCodigo() <= 0){
            throw new EscrituraExcepcion("No se permite Modificar Códigos menores o iguales a cero");
            
        }
        
        if(pro.getPrecio() <= 0 || pro.getCantidad() <= 0 ){
            throw new EscrituraExcepcion("No se permite modificar si hay campos menores o igual a 0'");
        }
        
        if (codigoExiste(con, pro.getCodigo())) {
            throw new DatoDuplicadoExcepcion("El código del item a modificar ya existe en la base de datos");
        }
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
            ps.execute();
            return true;    // Éxito: registro modificado en la base de datos
        } catch (SQLException e) {
            System.err.println(e);
            return false;   // Error: no se pudo modificar el registro
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    // Método para eliminar un producto de la base de datos
    public boolean eliminar(Productos pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM productos WHERE id=? ";
 
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;    // Éxito: registro eliminado de la base de datos
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;   // Error: no se pudo eliminar el registro
            
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    // Método para buscar un producto en la base de datos por su código
    public boolean buscar(Productos pro) throws LecturaExcepcion {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM productos WHERE codigo=? ";
        

        if (pro.getCodigo() <= 0){
            throw new LecturaExcepcion("No se puede buscar Códigos menores o iguales a cero");         
        }
            
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                return true;    // Éxito: registro encontrado en la base de datos
            }
            return false;   // No se encontró el registro
        } catch (SQLException e) {
            System.err.println(e);
            return false;   // Error: no se pudo realizar la búsqueda
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    // Método para verificar si el código ya existe en la base de datos
    private boolean codigoExiste(Connection con, int codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT id FROM productos WHERE codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            // Si encuentra un resultado, significa que el código ya existe
            return rs.next();
        } catch (SQLException e) {
            System.err.println(e);
            return false; // Error al realizar la consulta
        }
    }
}
