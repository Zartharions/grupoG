/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import Modelo.Clientes;
import java.sql.SQLException;
import java.util.List;
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
public class ClienteControladorIT {
    
    public ClienteControladorIT() {
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
     * Test of validarCliente method, of class ClienteControlador.
     */
    @Test
    public void testValidarCliente_CiInvalido() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ClienteControlador clienteControlador = new ClienteControlador();
        Clientes cliente = new Clientes();
        cliente.setCi(-1);  // CI inválido

        try {
            clienteControlador.validarCliente(cliente);
            fail("Se esperaba una EscrituraExcepcion para CI inválido");
        } catch (EscrituraExcepcion e) {
            assertEquals("CI inválido. Debe ser un número positivo de exactamente 10 dígitos.", e.getMessage());
        }
    }

    @Test
    public void testValidarCliente_TelefonoInvalido() throws DatoDuplicadoExcepcion, LecturaExcepcion, SQLException {
        ClienteControlador clienteControlador = new ClienteControlador();
        Clientes cliente = new Clientes();
        cliente.setCi(1234567890);
        cliente.setNombre("NombreCliente");
        cliente.setDireccion("DireccionCliente");
        cliente.setRazon("RazonCliente");
        cliente.setTelefono(12345678);  // Número de teléfono inválido

        try {
            clienteControlador.validarCliente(cliente);
            fail("Se esperaba una EscrituraExcepcion para número de teléfono inválido");
        } catch (EscrituraExcepcion e) {
            assertEquals("Número de teléfono inválido. Debe tener 9 o 10 dígitos.", e.getMessage());
        }
    }
    
    @Test
    public void testRegistrarCliente_CIExistente() {
        ClienteControlador clienteControlador = new ClienteControlador();
        Clientes clienteExistente = new Clientes();
        clienteExistente.setCi(1234567890); 
        clienteExistente.setNombre("NombreClientes");
        clienteExistente.setDireccion("DireccionCliente");
        clienteExistente.setRazon("RazonCliente");
        clienteExistente.setTelefono(123456789);
        

        try {
            // Intentar registrar un nuevo cliente con un CI existente
            clienteControlador.RegistrarCliente(clienteExistente);
            fail("Se esperaba una DatoDuplicadoExcepcion para CI existente");
        } catch (DatoDuplicadoExcepcion | LecturaExcepcion | EscrituraExcepcion  e) {
            assertEquals("Ya existe un cliente registrado con este CI.", e.getMessage());
        }
    }

    @Test
    public void testRegistrarCliente_NombreExistente() {
        ClienteControlador clienteControlador = new ClienteControlador();
        Clientes clienteExistente = new Clientes();
        clienteExistente.setNombre("NombreExistente");
        clienteExistente.setCi(1234567888);     
        clienteExistente.setDireccion("DireccionCliente");
        clienteExistente.setRazon("RazonCliente");
        clienteExistente.setTelefono(123456789);

        try {
            // Intentar registrar un nuevo cliente con un nombre existente
            clienteControlador.RegistrarCliente(clienteExistente);
            fail("Se esperaba una DatoDuplicadoExcepcion para nombre existente");
        } catch (DatoDuplicadoExcepcion | LecturaExcepcion | EscrituraExcepcion  e) {
            assertEquals("Ya existe un cliente registrado con este nombre.", e.getMessage());
        }
    }
   
}
