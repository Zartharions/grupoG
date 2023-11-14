package Controlador;

import Modelo.ConexionBase;
import Modelo.Detalles;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaControlador {
    Connection con;
    ConexionBase cn = new ConexionBase();
    PreparedStatement ps;
    int result;
    ResultSet rs;

    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM ventas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return id;
    }

    public int RegistrarVenta(Venta v){
        String sql ="INSERT INTO ventas (cliente, vendedor, total) VALUES (?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            result = ps.executeUpdate(); // Cambiado a executeUpdate
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return result;
    }

    public int RegistrarDetalleVenta(Detalles Dv){
        String sql = "INSERT INTO detalles (codigo_producto, cantidad, precio, id_venta) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dv.getCod_Pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio()); // Cambiado a getPrecio
            ps.setInt(4, Dv.getId_venta());
            result = ps.executeUpdate(); // Cambiado a executeUpdate

            // Después de insertar el detalle de la venta, actualizamos el stock
            if (result > 0) {
                ActualizarStock(Dv.getCantidad(), Dv.getCod_Pro());
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return result;
    }

    public boolean ActualizarStock(int cant, String cod){
        String sql = "UPDATE  productos  SET stock = ? WHERE id=? ";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.executeUpdate(); // Cambiado a executeUpdate
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

    public List<Venta> ListarVentas(){
        List<Venta> ListaVenta = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Venta vent = new Venta();
                vent.setId(rs.getInt("id"));
                vent.setCliente(rs.getString("cliente"));
                vent.setVendedor(rs.getString("vendedor"));
                vent.setTotal(rs.getDouble("total"));
                ListaVenta.add(vent);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return ListaVenta;
    }
}
