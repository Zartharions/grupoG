/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Modelo.Proveedor;
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
public class ProveedorControladorIT {

    public ProveedorControladorIT() {
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

    @Test
    public void testValidarProveedor_RucInvalido() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ProveedorControlador proveedorControlador = new ProveedorControlador();
        Proveedor proveedor = new Proveedor();
        proveedor.setRuc(-1);  // RUC inválido

        try {
            proveedorControlador.validarProveedor(proveedor);
            fail("Se esperaba una EscrituraExcepcion para RUC inválido");
        } catch (EscrituraExcepcion e) {
            assertEquals("RUC inválido. Debe ser un número positivo de exactamente 10 dígitos.", e.getMessage());
        }
    }

    @Test
    public void testValidarProveedor_TelefonoInvalido() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ProveedorControlador proveedorControlador = new ProveedorControlador();
        Proveedor proveedor = new Proveedor();
        proveedor.setRuc(1234567890);
        proveedor.setNombre("NombreProveedor");
        proveedor.setDireccion("DireccionProveedor");
        proveedor.setRazon("RazonProveedor");
        proveedor.setTelefono(1234567);  // Número de teléfono inválido

        try {
            proveedorControlador.validarProveedor(proveedor);
            fail("Se esperaba una EscrituraExcepcion para número de teléfono inválido");
        } catch (EscrituraExcepcion e) {
            assertEquals("Número de teléfono inválido. Debe tener 9 o 10 dígitos.", e.getMessage());
        }
    }

    @Test
    public void testRegistrarProveedor_RUCExistente() {
        ProveedorControlador proveedorControlador = new ProveedorControlador();
        Proveedor proveedorExistente = new Proveedor();
        proveedorExistente.setRuc(1234567902);
        proveedorExistente.setNombre("NombreProveedorS");
        proveedorExistente.setDireccion("DireccionProveedor");
        proveedorExistente.setRazon("RazonProveedor");
        proveedorExistente.setTelefono(123456789);

        try {
            // Intentar registrar un nuevo proveedor con un RUC existente
            proveedorControlador.RegistrarProveedor(proveedorExistente);
            fail("Se esperaba una DatoDuplicadoExcepcion para RUC existente");
        } catch (DatoDuplicadoExcepcion | LecturaExcepcion | EscrituraExcepcion e) {
            assertEquals("Ya existe un proveedor registrado con este RUC.", e.getMessage());
        }
    }

    @Test
    public void testRegistrarProveedor_NombreExistente() {
        ProveedorControlador proveedorControlador = new ProveedorControlador();
        Proveedor proveedorExistente = new Proveedor();
        proveedorExistente.setNombre("NombreExistente");
        proveedorExistente.setRuc(1234557902);
        proveedorExistente.setDireccion("DireccionProveedor");
        proveedorExistente.setRazon("RazonProveedor");
        proveedorExistente.setTelefono(123456789);

        try {
            // Intentar registrar un nuevo proveedor con un nombre existente
            proveedorControlador.RegistrarProveedor(proveedorExistente);
            fail("Se esperaba una DatoDuplicadoExcepcion para nombre existente");
        } catch (DatoDuplicadoExcepcion | LecturaExcepcion | EscrituraExcepcion e) {
            assertEquals("Ya existe un proveedor registrado con este nombre.", e.getMessage());
        }
    }
}
