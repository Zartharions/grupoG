package Controlador;
import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Modelo.ConsultaProductos;
import Modelo.Productos;
import Vista.frmNavegacion;
import Vista.frmProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class ControlProductos implements ActionListener {
    
    // Declaración de variables miembro
    private final Productos modelo; // El modelo de datos
    private final ConsultaProductos consultas;  // Clase para realizar consultas en la base de datos
    private final frmProductos vista;   // La vista (interfaz gráfica)
    
    // Constructor del controlador
    public ControlProductos(Productos modelo, ConsultaProductos consultas, frmProductos vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        
        // Asociación de eventos a los botones de la vista
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        
    }
  
  
    // Método para iniciar el controlador
    public void iniciar() {
        vista.setTitle("Test Almacen");
        vista.setLocationRelativeTo(null);
        vista.txtId.setVisible(false);
        
    }

    
     // Manejo de eventos (acciones del usuario)
    @Override
    public void actionPerformed(ActionEvent e){

        try{
            if (e.getSource() == vista.btnGuardar){
            // Captura de datos desde la vista
            modelo.setCodigo(Integer.parseInt(vista.txtCodigo.getText()));
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
           
           
            
            // Llamada al modelo para registrar un producto
            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();  // Limpieza de campos
            }               
        }
          
            if (e.getSource() == vista.btnModificar) {
                // Captura de datos desde la vista
                modelo.setId(Integer.parseInt(vista.txtId.getText()));
                modelo.setCodigo(Integer.parseInt(vista.txtCodigo.getText()));
                modelo.setNombre(vista.txtNombre.getText());
                modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
                modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));

                // Llamada al modelo para modificar un producto
                if (consultas.modificar(modelo)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();  // Limpieza de campos
                } 
            }
        }
        
                
        catch(EscrituraExcepcion | NumberFormatException | DatoDuplicadoExcepcion ee){
            JOptionPane.showMessageDialog(null, "Error al Guardar: " + ee.getMessage());
            limpiar();  // Limpieza de campos
        }
        // Limpieza de campos


        if (e.getSource() == vista.btnEliminar) {
            // Captura del ID del producto desde la vista
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            // Llamada al modelo para eliminar un producto
            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar(); // Limpieza de campos
            } 
        }

        try{
            if (e.getSource() == vista.btnBuscar) {
                 // Captura del código del producto desde la vista
                modelo.setCodigo(Integer.parseInt(vista.txtCodigo.getText()));


                // Llamada al modelo para buscar un producto por su código
                if (consultas.buscar(modelo)) {
                    // Actualización de los campos en la vista con los datos encontrados
                    vista.txtId.setText(String.valueOf(modelo.getId()));
                    vista.txtCodigo.setText(String.valueOf(modelo.getCodigo()));
                    vista.txtNombre.setText(modelo.getNombre());
                    vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                    vista.txtCantidad.setText(String.valueOf(modelo.getCantidad()));

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro registro");
                    limpiar(); // Limpieza de campos
                }
            }
        } 
        catch(LecturaExcepcion le){
            JOptionPane.showMessageDialog(null, "Error al Buscar: "+ le.getMessage());
            limpiar();
        }
        
        catch(NumberFormatException  nfe){
            JOptionPane.showMessageDialog(null, "Error al Buscar: El campo se encuentra incorrecto o Vacío");
            limpiar();
        }
        
        if (e.getSource() == vista.btnLimpiar) {
            limpiar(); // Limpieza de campos
        }

    }
    

    // Método para limpiar los campos en la vista
    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtCodigo.setText(null);
        vista.txtNombre.setText(null);
        vista.txtPrecio.setText(null);
        vista.txtCantidad.setText(null);
    }

}

