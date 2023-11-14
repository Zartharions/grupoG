package Controlador;

import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Modelo.Detalles;
import Modelo.Venta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VentaControladorIT {

    public VentaControladorIT() {
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
    public void testRegistrarVentaExitosa() throws EscrituraExcepcion {
        VentaControlador ventaControlador = new VentaControlador();
        Venta venta = new Venta();
        venta.setCliente("ClientePrueba");
        venta.setVendedor("VendedorPrueba");
        venta.setTotal(100.0);

        int resultado = ventaControlador.RegistrarVenta(venta);
        assertEquals(1, resultado); // Esperamos que se haya registrado una fila
    }

    @Test
    public void testRegistrarDetalleVentaExitoso() throws EscrituraExcepcion {
        VentaControlador ventaControlador = new VentaControlador();
        Venta venta = new Venta();
        venta.setCliente("ClientePrueba");
        venta.setVendedor("VendedorPrueba");
        venta.setTotal(100.0);

        Detalles detalle = new Detalles();
        detalle.setCod_Pro("ProductoPrueba");
        detalle.setCantidad(2);
        detalle.setPrecio(50.0);
        detalle.setId_venta(1); // ID de la venta registrada en el paso anterior
        int resultadoVenta = ventaControlador.RegistrarVenta(venta);
        assertEquals(1, resultadoVenta); // Esperamos que se haya registrado una fila
        int resultadoDetalle = ventaControlador.RegistrarDetalleVenta(detalle);
        assertEquals(1, resultadoDetalle); // Esperamos que se haya registrado una fila
    }

    // Puedes continuar con más pruebas según tus necesidades y casos de uso
}
