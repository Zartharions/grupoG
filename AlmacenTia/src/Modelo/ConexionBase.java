package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBase {
    Connection con = null;
    // Definición de los parámetros de conexión a la base de datos
    String base = "almacenestia";   // Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base; // URL de la base de datos
    String user = "root";   // Nombre de usuario de la base de datos
    String password = "123456789";  // Contraseña de la base de datos

    // Método para obtener una conexión a la base de datos
    public Connection getConexion() {

        try {
            // Carga del controlador de la base de datos (MySQL en este caso)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecimiento de la conexión utilizando los parámetros definidos
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e); // Manejo de excepciones: impresión de errores en la consola
        }
        return con; // Devuelve la conexión establecida
    }
    
}
