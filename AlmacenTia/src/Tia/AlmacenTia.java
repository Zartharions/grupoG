package Tia;
import Controlador.ControlProductos;
import Modelo.ConsultaProductos;
import Modelo.Productos;
import Vista.frmProductos;


public class AlmacenTia {
    public static void main(String[] args) {
        
        // Crear una instancia del modelo de Productos
        Productos mod = new Productos();
        
        // Crear una instancia de la clase ConsultaProductos que se encarga de interactuar con la base de datos
        ConsultaProductos modC = new ConsultaProductos();
        
        // Crear una instancia de la vista frmProductos que representa la interfaz de usuario
        frmProductos frm = new frmProductos();

        // Crear una instancia del controlador ControlProductos, que coordina las interacciones entre el modelo y la vista
        ControlProductos ctrl = new ControlProductos(mod, modC, frm);
        
        // Iniciar la interfaz de usuario
        ctrl.iniciar();
        
        // Hacer visible la interfaz de usuario
        frm.setVisible(true);
       
    }
}
