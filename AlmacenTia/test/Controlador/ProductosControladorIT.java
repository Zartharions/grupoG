/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.LecturaExcepcion;

import Modelo.Productos;
import java.sql.SQLException;

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
public class ProductosControladorIT {
    
    public ProductosControladorIT() {
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

    /**
     * Test of RegistrarProductos method, of class ProductosControlador.
     */
    @Test
    public void testRegistrarProductoConCodigoNegativo() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ProductosControlador productosControlador = new ProductosControlador();
        Productos productoConCodigoNegativo = new Productos();
        productoConCodigoNegativo.setId(10);
        productoConCodigoNegativo.setCodigo("25");
        productoConCodigoNegativo.setStock(-123);
        productoConCodigoNegativo.setNombre("PruebaProducto");
        productoConCodigoNegativo.setProveedor("Bimbom");
        productoConCodigoNegativo.setPrecio(10);
        // Establecer otros datos del producto

        boolean resultado = productosControlador.RegistrarProductos(productoConCodigoNegativo);

        assertFalse(resultado); // Se espera que no permita registrar con código negativo
    }

    @Test
    public void testRegistrarProductoConCodigoExistente() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ProductosControlador productosControlador = new ProductosControlador();
        
        // Crear un nuevo producto con el mismo código
        Productos productoConMismoCodigo = new Productos();
        productoConMismoCodigo.setId(11);
        productoConMismoCodigo.setCodigo("25");
        productoConMismoCodigo.setStock(123);
        productoConMismoCodigo.setNombre("PruebaProductodos");
        productoConMismoCodigo.setProveedor("Bimbom");
        productoConMismoCodigo.setPrecio(10);
        // Establecer otros datos del producto

        boolean resultado = productosControlador.RegistrarProductos(productoConMismoCodigo);

        assertFalse(resultado); // Se espera que no permita registrar con el mismo código
    }

    @Test
    public void testRegistrarProductoConCantidadNegativa() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ProductosControlador productosControlador = new ProductosControlador();
        Productos productoConCantidadNegativa = new Productos();
        productoConCantidadNegativa.setId(111);
        productoConCantidadNegativa.setCodigo("253");
        productoConCantidadNegativa.setStock(-123);
        productoConCantidadNegativa.setNombre("PruebaProductodos");
        productoConCantidadNegativa.setProveedor("Bimbom");
        productoConCantidadNegativa.setPrecio(10);

        boolean resultado = productosControlador.RegistrarProductos(productoConCantidadNegativa);

        assertFalse(resultado); // Se espera que no permita registrar con cantidad negativa
    }

    @Test
    public void testRegistrarProductoConPrecioNegativo() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ProductosControlador productosControlador = new ProductosControlador();
        Productos productoConPrecioNegativo = new Productos();
        productoConPrecioNegativo.setId(112);
        productoConPrecioNegativo.setCodigo("325");
        productoConPrecioNegativo.setStock(123);
        productoConPrecioNegativo.setNombre("PruebaProductodos");
        productoConPrecioNegativo.setProveedor("Bimbom");
        productoConPrecioNegativo.setPrecio(-10);

        boolean resultado = productosControlador.RegistrarProductos(productoConPrecioNegativo);

        assertFalse(resultado); // Se espera que no permita registrar con precio negativo
    }
    
}
