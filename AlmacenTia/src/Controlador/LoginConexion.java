package Controlador;

import Vista.frmInicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que gestiona la conexión y validación de inicio de sesión de usuarios.
 */
public class LoginConexion {
    
    // Consulta SQL para validar usuario
    private static final String SELECT_USER_QUERY = "SELECT * FROM usuario WHERE usuario.Nombre = ? AND usuario.contraseña = ?";
    
    // Mensajes para el usuario
    private static final String USER_SUCCESS_MESSAGE = "Usuario ingresado correctamente";
    private static final String USER_FAILURE_MESSAGE = "Usuario ingresado incorrectamente, verifique su usuario o contraseña";
    private static final String ERROR_MESSAGE = "Error: ";

    /**
     * Método para validar el usuario al intentar iniciar sesión.
     * @param usuario Campo de texto que contiene el nombre de usuario.
     * @param contrasenia Campo de contraseña que contiene la contraseña del usuario.
     */
    public void validarUsuario(JTextField usuario, JPasswordField contrasenia) {
        try {
            Modelo.ConexionBase objConexion = new Modelo.ConexionBase();
            String contra = String.valueOf(contrasenia.getPassword());

            // Verifica si el usuario es válido
            if (esUsuarioValido(objConexion, usuario.getText(), contra)) {
                mostrarMensaje(USER_SUCCESS_MESSAGE);
                abrirVentanaInicio();
            } else {
                mostrarMensaje(USER_FAILURE_MESSAGE);
            }

        } catch (Exception e) {
            mostrarMensaje(ERROR_MESSAGE + e.toString());
        }
    }

    /**
     * Método para verificar si un usuario es válido.
     * @param conexion Objeto de conexión a la base de datos.
     * @param nombreUsuario Nombre de usuario a verificar.
     * @param contrasenia Contraseña del usuario a verificar.
     * @return true si el usuario es válido, false si no.
     */
    private boolean esUsuarioValido(Modelo.ConexionBase conexion, String nombreUsuario, String contrasenia) {
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(SELECT_USER_QUERY)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            mostrarMensaje(ERROR_MESSAGE + e.toString());
            return false;
        }
    }

    /**
     * Método para abrir la ventana de inicio después de una sesión exitosa.
     */
    private void abrirVentanaInicio() {
        frmInicio objInicio = new frmInicio();
        objInicio.setVisible(true);
    }

    /**
     * Método para mostrar mensajes en un cuadro de diálogo.
     * @param mensaje Mensaje a mostrar.
     */
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
