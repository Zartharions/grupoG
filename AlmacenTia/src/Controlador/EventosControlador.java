package Controlador;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que maneja eventos relacionados con la validación de entrada en campos de texto.
 */
public class EventosControlador {

    // Constantes para algunos caracteres especiales
    private static final char BACKSPACE = (char) KeyEvent.VK_BACK_SPACE;
    private static final char SPACE = ' ';
    private static final char DOT = '.';

    // Máximo número de dígitos permitidos
    private static final int MAX_DIGITOS = 10;

    /**
     * Método para validar la entrada de letras y espacios.
     * @param evt Evento KeyEvent generado al presionar una tecla.
     */
    public void validarLetras(KeyEvent evt) {
        char car = evt.getKeyChar();
        if (!esCaracterLetra(car) && car != BACKSPACE && car != SPACE) {
            mostrarMensajeError("Solo se permiten letras y espacios.");
            evt.consume();
        }
    }

    /**
     * Método para validar la entrada de números.
     * @param evt Evento KeyEvent generado al presionar una tecla.
     * @param textField Campo de texto donde se verifica la entrada.
     */
    
    public void validarNumeros(KeyEvent evt) {
        char car = evt.getKeyChar();
        if (!esCaracterNumero(car) && car != BACKSPACE) {
            mostrarMensajeError("Solo se permiten números.");
            evt.consume();
        }
    }

    /**
     * Método para validar la entrada de números y un punto decimal.
     * @param evt Evento KeyEvent generado al presionar una tecla.
     * @param textField Campo de texto donde se verifica la entrada.
     */
    public void validarNumerosDecimales(KeyEvent evt, JTextField textField) {
        char car = evt.getKeyChar();
        if (!esCaracterNumero(car) && !esPuntoDecimalValido(evt, textField) && car != BACKSPACE) {
            mostrarMensajeError("Solo se permiten números y un punto decimal.");
            evt.consume();
        } 
    }

    /**
     * Verifica si un caracter es una letra.
     * @param car Caracter a verificar.
     * @return true si es una letra, false si no.
     */
    private boolean esCaracterLetra(char car) {
        return (car >= 'a' && car <= 'z') || (car >= 'A' && car <= 'Z');
    }

    /**
     * Verifica si un caracter es un número.
     * @param car Caracter a verificar.
     * @return true si es un número, false si no.
     */
    private boolean esCaracterNumero(char car) {
        return car >= '0' && car <= '9';
    }

    /**
     * Verifica si un punto decimal es válido en el contexto del campo de texto.
     * @param evt Evento KeyEvent generado al presionar una tecla.
     * @param textField Campo de texto donde se verifica la entrada.
     * @return true si el punto decimal es válido, false si no.
     */
    private boolean esPuntoDecimalValido(KeyEvent evt, JTextField textField) {
        char car = evt.getKeyChar();
        return car == DOT && !textField.getText().contains(String.valueOf(DOT));
    }

    /**
     * Verifica si la longitud de la entrada numérica es válida.
     */
    public void validarLongitudNumerica(JTextField textField) {
        String input = textField.getText();
        if (input.length() > MAX_DIGITOS) {
            mostrarMensajeError("No se permiten más de 10 dígitos.");
            textField.setText(input.substring(0, MAX_DIGITOS));
        } else if (input.length() < MAX_DIGITOS) {
            mostrarMensajeError("Se requieren al menos 10 dígitos.");
        }
    }

    /**
     * Muestra un mensaje de error en un cuadro de diálogo.
     * @param mensaje Mensaje de error a mostrar.
     */
    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
