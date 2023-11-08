/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControlProductos;
import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Vista.frmProductos;
import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;




/**
 *
 * @author Ignacio Valencia
 */
public class ConsultaProductosIT {
  
    
    public ConsultaProductosIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
    }
    
    @After
    public void tearDown() {
    }

    /*@Test
    public void testRegistroProductoExitoso() throws EscrituraExcepcion, DatoDuplicadoExcepcion {
        // Crear un objeto Producto con valores válidos
        Productos producto = new Productos();
        producto.setCodigo(1213);
        producto.setNombre("Producto de Prueba");
        producto.setPrecio(19.99);
        producto.setCantidad(50);

        // Crear una instancia de ConsultaProductos
        ConsultaProductos consultas = new ConsultaProductos();

        // Intentar registrar el producto en la base de datos
        boolean registroExitoso = consultas.registrar(producto);

        // Verificar si el registro fue exitoso
        assertTrue(registroExitoso);
    }*/
    
    /*@Test
    public void testIngresoCodigoNegativo() throws EscrituraExcepcion, DatoDuplicadoExcepcion {
        // Crear un objeto Producto con código negativo y valores válidos
        Productos producto = new Productos();
        producto.setCodigo(5); 
        producto.setNombre(""); // Campo de Nombre vacio.
        producto.setPrecio(89.89);
        producto.setCantidad(20);

        // Crear una instancia de ConsultaProductos
        ConsultaProductos consultas = new ConsultaProductos();

        // Intentar registrar el producto en la base de datos
        boolean registroExitoso = consultas.registrar(producto);

        // Verificar que el registro no sea exitoso
        assertFalse(registroExitoso);
    }*/
    
    /*@Test
    public void testRegistroProductoDuplicado() throws EscrituraExcepcion, DatoDuplicadoExcepcion {
        Productos producto1 = new Productos();
        producto1.setCodigo(13);
        producto1.setNombre("Producto 1");
        producto1.setPrecio(9.99);
        producto1.setCantidad(10);

        Productos producto2 = new Productos();
        producto2.setCodigo(13); // Mismo código que producto1
        producto2.setNombre("Producto 2");
        producto2.setPrecio(14.99);
        producto2.setCantidad(5);

        ConsultaProductos consultas = new ConsultaProductos();
        boolean registroExitoso1 = consultas.registrar(producto1);
        assertTrue(registroExitoso1);

        boolean registroExitoso2 = consultas.registrar(producto2);
        assertFalse(registroExitoso2); // Debería fallar debido a un código duplicado
    }*/
    
    @Test
    public void testEliminacionProductoExitosa() throws EscrituraExcepcion, DatoDuplicadoExcepcion {
        Productos producto = new Productos();
        producto.setCodigo(12663);
        producto.setNombre("Producto de prueba");
        producto.setPrecio(9.99);
        producto.setCantidad(10);

        ConsultaProductos consultas = new ConsultaProductos();
        boolean registroExitoso = consultas.registrar(producto);
        assertTrue(registroExitoso);

        boolean eliminacionExitosa = consultas.eliminar(producto);
        assertTrue(eliminacionExitosa);
    }
}




