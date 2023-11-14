/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controlador.ClienteControlador;
import Modelo.Clientes;
import Modelo.Config;
import Modelo.Detalles;
import Controlador.EventosControlador;
import Modelo.Productos;
import Controlador.ProductosControlador;
import Modelo.Proveedor;
import Controlador.ProveedorControlador;
import Modelo.Venta;
import Controlador.VentaControlador;
import Excepciones.DatoDuplicadoExcepcion;
import Excepciones.EscrituraExcepcion;
import Excepciones.LecturaExcepcion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author usuario
 */
public class frmInicio extends javax.swing.JFrame {
    int xMouse, yMouse;
    Clientes cl = new Clientes();
    ClienteControlador clicon = new ClienteControlador();
    Proveedor pr = new Proveedor();
    ProveedorControlador prconex = new ProveedorControlador();
    Productos pro = new Productos();
    ProductosControlador proConex = new ProductosControlador();
    Venta v = new Venta();
    VentaControlador vConex = new VentaControlador();
    Detalles Dv = new Detalles();
    EventosControlador events = new EventosControlador();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    int item;
    double totalPagar = 0.00;

    /**
     * Creates new form frmInicio
     */
    public frmInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdCli.setVisible(false);
        txtIdProveedor.setVisible(false);
        txtIdPro.setVisible(false);
        txtIdProducto.setVisible(false);
        txttelefHome.setVisible(false);
        txtDirecHome.setVisible(false);
        txtRazonHome.setVisible(false);
        txtIdVenta.setVisible(false);
        AutoCompleteDecorator.decorate(cbxProveedor);
        proConex.ConsultarProveedor(cbxProveedor);
    }

    public void ListarCliente() {
        List<Clientes> ListaCli = clicon.ListarClientes();
        modelo = (DefaultTableModel) jtbCliente.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < ListaCli.size(); i++) {
            obj[0] = ListaCli.get(i).getId();
            obj[1] = ListaCli.get(i).getCi();
            obj[2] = ListaCli.get(i).getNombre();
            obj[3] = ListaCli.get(i).getTelefono();
            obj[4] = ListaCli.get(i).getDireccion();
            obj[5] = ListaCli.get(i).getRazon();
            modelo.addRow(obj);
        }
        jtbCliente.setModel(modelo);
    }
    
    public void ListarProveedor() {
        List<Proveedor> ListaProvee = prconex.ListarProveedor();
        modelo = (DefaultTableModel) jtbProveedor.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < ListaProvee.size(); i++) {
            obj[0] = ListaProvee.get(i).getId();
            obj[1] = ListaProvee.get(i).getRuc();
            obj[2] = ListaProvee.get(i).getNombre();
            obj[3] = ListaProvee.get(i).getTelefono();
            obj[4] = ListaProvee.get(i).getDireccion();
            obj[5] = ListaProvee.get(i).getRazon();
            modelo.addRow(obj);
        }
        jtbProveedor.setModel(modelo);
    }
    
    public void ListarProducto() {
        List<Productos> ListaProduct = proConex.ListarProductos();
        modelo = (DefaultTableModel) jtbProducto.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < ListaProduct.size(); i++) {
            obj[0] = ListaProduct.get(i).getId();
            obj[1] = ListaProduct.get(i).getCodigo();
            obj[2] = ListaProduct.get(i).getNombre();
            obj[3] = ListaProduct.get(i).getProveedor();
            obj[4] = ListaProduct.get(i).getStock();
            obj[5] = ListaProduct.get(i).getPrecio();
            modelo.addRow(obj);
        }
        jtbProducto.setModel(modelo);
    }

    
     public void ListarConfig() {
        List<Config> ListaConf = proConex.ListarConfig();
        modelo = (DefaultTableModel) jtbProducto.getModel();
        Object[] obj = new Object[6];
        for (int i = 0; i < ListaConf.size(); i++) {
            obj[0] = ListaConf.get(i).getId();
            obj[1] = ListaConf.get(i).getRuc();
            obj[2] = ListaConf.get(i).getNombre();
            obj[3] = ListaConf.get(i).getTelefono();
            obj[4] = ListaConf.get(i).getDireccion();
            obj[5] = ListaConf.get(i).getRazon();
            modelo.addRow(obj);
        }
        jtbProducto.setModel(modelo);
    }
     
     public void ListarVenta() {
        List<Venta> ListaVenta = vConex.ListarVentas();
        modelo = (DefaultTableModel) jtbVenta.getModel();
        Object[] obj = new Object[4];
        for (int i = 0; i < ListaVenta.size(); i++) {
            obj[0] = ListaVenta.get(i).getId();
            obj[1] = ListaVenta.get(i).getCliente();
            obj[2] = ListaVenta.get(i).getVendedor();
            obj[3] = ListaVenta.get(i).getTotal();
            modelo.addRow(obj);
        }
        jtbVenta.setModel(modelo);
    }
    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblEslogan = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevaVenta = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        tbpTabla = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEliminarventa = new javax.swing.JButton();
        txtIdHome = new javax.swing.JTextField();
        txtPrecioHome = new javax.swing.JTextField();
        txtCantidadHome = new javax.swing.JTextField();
        txtDescripcionHome = new javax.swing.JTextField();
        txtStockHome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTablaHome = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCiHome = new javax.swing.JTextField();
        txtNombreCliHome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtIdPro = new javax.swing.JTextField();
        txttelefHome = new javax.swing.JTextField();
        txtDirecHome = new javax.swing.JTextField();
        txtRazonHome = new javax.swing.JTextField();
        lblVendedor = new javax.swing.JLabel();
        btnDetVenta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCiCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtDireccionCli = new javax.swing.JTextField();
        txtRazonCli = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCliente = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        txtIdCli = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtRucProvee = new javax.swing.JTextField();
        txtNombreProvee = new javax.swing.JTextField();
        txtTelefonoProvee = new javax.swing.JTextField();
        txtDireccionProvee = new javax.swing.JTextField();
        txtRazonProvee = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbProveedor = new javax.swing.JTable();
        btnGuardarProve = new javax.swing.JButton();
        btnActualizarProve = new javax.swing.JButton();
        btnNuevoProve = new javax.swing.JButton();
        btnEliminarProve = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtPrecioProdu = new javax.swing.JTextField();
        txtCantidadProduc = new javax.swing.JTextField();
        txtDescripcionProdu = new javax.swing.JTextField();
        txtCodigoProduc = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbProducto = new javax.swing.JTable();
        cbxProveedor = new javax.swing.JComboBox<>();
        btnNuevoProdu = new javax.swing.JButton();
        btnGuardarProdu = new javax.swing.JButton();
        btnEliminarProdu = new javax.swing.JButton();
        btnActualizarProdu = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbVenta = new javax.swing.JTable();
        txtIdVenta = new javax.swing.JTextField();
        jpBarra1 = new javax.swing.JPanel();
        jpSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1020, 721));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1020, 721));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblEslogan.setBackground(new java.awt.Color(255, 255, 255));
        lblEslogan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eslogan-tia.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEslogan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEslogan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1020, 150));

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        btnNuevaVenta.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pila-de-billetes-de-dolar.png"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.setBorder(null);
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnCliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cliente.png"))); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.setBorder(null);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cajas.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnProveedor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/repartidor.png"))); // NOI18N
        btnProveedor.setText("Proveedor");
        btnProveedor.setBorder(null);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ahorrar-dinero.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setBorder(null);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 290, 520));

        tbpTabla.setBackground(new java.awt.Color(255, 255, 255));
        tbpTabla.setPreferredSize(new java.awt.Dimension(843, 482));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(327, 327));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("Precio");

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("Descripción");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel5.setText("Stock Disponible");

        btnEliminarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basura.png"))); // NOI18N
        btnEliminarventa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminarventa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarventaActionPerformed(evt);
            }
        });

        txtIdHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtIdHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdHomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdHomeKeyTyped(evt);
            }
        });

        txtPrecioHome.setEditable(false);
        txtPrecioHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        txtCantidadHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtCantidadHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadHomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadHomeKeyTyped(evt);
            }
        });

        txtDescripcionHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtDescripcionHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionHomeActionPerformed(evt);
            }
        });
        txtDescripcionHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionHomeKeyTyped(evt);
            }
        });

        txtStockHome.setEditable(false);
        txtStockHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        jtbTablaHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jtbTablaHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripción", "Cantidad", "Precio U.", "Total"
            }
        ));
        jScrollPane1.setViewportView(jtbTablaHome);
        if (jtbTablaHome.getColumnModel().getColumnCount() > 0) {
            jtbTablaHome.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtbTablaHome.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbTablaHome.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbTablaHome.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbTablaHome.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel6.setText("C.I./R.U.C.");

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel7.setText("Nombre");

        txtCiHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtCiHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCiHomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiHomeKeyTyped(evt);
            }
        });

        txtNombreCliHome.setEditable(false);
        txtNombreCliHome.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pila-de-billetes-de-dolar.png"))); // NOI18N
        jLabel8.setText("Total a Pagar:");

        lblTotal.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblTotal.setText("--------");

        lblVendedor.setText("vendedor");

        btnDetVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/impresora.png"))); // NOI18N
        btnDetVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDetVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdHome, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtDescripcionHome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCantidadHome, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtPrecioHome, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtStockHome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtCiHome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNombreCliHome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttelefHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirecHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRazonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblVendedor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcionHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnEliminarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(lblVendedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCiHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCliHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDirecHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lblTotal)))
                    .addComponent(btnDetVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        tbpTabla.addTab("tab1", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel10.setText("C.I/R.U.C:");

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        jLabel12.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel12.setText("Nombre:");

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel13.setText("Dirección:");

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel14.setText("Razón Social:");

        txtCiCliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtCiCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiClienteKeyTyped(evt);
            }
        });

        txtNombreCliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });

        txtDireccionCli.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtDireccionCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionCliKeyTyped(evt);
            }
        });

        txtRazonCli.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtRazonCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonCliKeyTyped(evt);
            }
        });

        txtTelefonoCliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });

        jtbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "C.I/R.U.C", "Nombre", "Telefono", "Dirección", "Razon"
            }
        ));
        jtbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbCliente);
        if (jtbCliente.getColumnModel().getColumnCount() > 0) {
            jtbCliente.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtbCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtbCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbCliente.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtbCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
            jtbCliente.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salvar.png"))); // NOI18N
        btnGuardarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        btnActualizarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/documento.png"))); // NOI18N
        btnNuevoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basura.png"))); // NOI18N
        btnEliminarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        txtIdCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRazonCli)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDireccionCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 196, Short.MAX_VALUE)
                                .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCiCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCiCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazonCli, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 118, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        tbpTabla.addTab("tab2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel15.setText("R.U.C:");

        jLabel16.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel16.setText("Nombre:");

        jLabel17.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel17.setText("Telefono:");

        jLabel18.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel18.setText("Dirección:");

        jLabel19.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel19.setText("Razón Social:");

        txtRucProvee.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtRucProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucProveeKeyTyped(evt);
            }
        });

        txtNombreProvee.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtNombreProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveeKeyTyped(evt);
            }
        });

        txtTelefonoProvee.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtTelefonoProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveeKeyTyped(evt);
            }
        });

        txtDireccionProvee.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtDireccionProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionProveeKeyTyped(evt);
            }
        });

        txtRazonProvee.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtRazonProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonProveeKeyTyped(evt);
            }
        });

        jtbProveedor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jtbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "R.U.C", "Nombre", "Telefono", "Dirección", "Razón "
            }
        ));
        jtbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbProveedor);
        if (jtbProveedor.getColumnModel().getColumnCount() > 0) {
            jtbProveedor.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbProveedor.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtbProveedor.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbProveedor.getColumnModel().getColumn(3).setPreferredWidth(40);
            jtbProveedor.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbProveedor.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        btnGuardarProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salvar.png"))); // NOI18N
        btnGuardarProve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardarProve.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveActionPerformed(evt);
            }
        });

        btnActualizarProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        btnActualizarProve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizarProve.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizarProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveActionPerformed(evt);
            }
        });

        btnNuevoProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/documento.png"))); // NOI18N
        btnNuevoProve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevoProve.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveActionPerformed(evt);
            }
        });

        btnEliminarProve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basura.png"))); // NOI18N
        btnEliminarProve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminarProve.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarProve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGuardarProve, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarProve, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnActualizarProve, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNuevoProve, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRucProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelefonoProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDireccionProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(txtRazonProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtRucProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccionProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazonProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarProve, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarProve, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarProve, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoProve, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tbpTabla.addTab("tab3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel20.setText("Codigo:");

        jLabel21.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel21.setText("Descripción:");

        jLabel22.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel22.setText("Cantidad:");

        jLabel23.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel23.setText("Precio:");

        jLabel24.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel24.setText("Proveedor:");

        txtPrecioProdu.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtPrecioProdu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProduKeyTyped(evt);
            }
        });

        txtCantidadProduc.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtCantidadProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProducKeyTyped(evt);
            }
        });

        txtDescripcionProdu.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtDescripcionProdu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProduKeyTyped(evt);
            }
        });

        txtCodigoProduc.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtCodigoProduc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProducKeyTyped(evt);
            }
        });

        jtbProducto.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jtbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Descripción", "Proveedor", "Stock", "Precio"
            }
        ));
        jtbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbProducto);
        if (jtbProducto.getColumnModel().getColumnCount() > 0) {
            jtbProducto.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbProducto.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtbProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbProducto.getColumnModel().getColumn(3).setPreferredWidth(60);
            jtbProducto.getColumnModel().getColumn(4).setPreferredWidth(40);
            jtbProducto.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        cbxProveedor.setEditable(true);

        btnNuevoProdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/documento.png"))); // NOI18N
        btnNuevoProdu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevoProdu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProduActionPerformed(evt);
            }
        });

        btnGuardarProdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/salvar.png"))); // NOI18N
        btnGuardarProdu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGuardarProdu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProduActionPerformed(evt);
            }
        });

        btnEliminarProdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/basura.png"))); // NOI18N
        btnEliminarProdu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminarProdu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProduActionPerformed(evt);
            }
        });

        btnActualizarProdu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        btnActualizarProdu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnActualizarProdu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizarProdu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProduActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioProdu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadProduc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcionProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtCodigoProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtDescripcionProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCantidadProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtPrecioProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoProdu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tbpTabla.addTab("tab4", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jtbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Vendedor", "Total"
            }
        ));
        jScrollPane5.setViewportView(jtbVenta);
        if (jtbVenta.getColumnModel().getColumnCount() > 0) {
            jtbVenta.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbVenta.getColumnModel().getColumn(1).setPreferredWidth(60);
            jtbVenta.getColumnModel().getColumn(2).setPreferredWidth(60);
            jtbVenta.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        tbpTabla.addTab("tab5", jPanel7);

        getContentPane().add(tbpTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 720, 610));

        jpBarra1.setBackground(new java.awt.Color(255, 255, 255));
        jpBarra1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpBarra1MouseDragged(evt);
            }
        });
        jpBarra1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpBarra1MousePressed(evt);
            }
        });

        jpSalir.setBackground(new java.awt.Color(255, 255, 255));

        lblSalir.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(233, 28, 43));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("x");
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpSalirLayout = new javax.swing.GroupLayout(jpSalir);
        jpSalir.setLayout(jpSalirLayout);
        jpSalirLayout.setHorizontalGroup(
            jpSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSalirLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpSalirLayout.setVerticalGroup(
            jpSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSalirLayout.createSequentialGroup()
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpBarra1Layout = new javax.swing.GroupLayout(jpBarra1);
        jpBarra1.setLayout(jpBarra1Layout);
        jpBarra1Layout.setHorizontalGroup(
            jpBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarra1Layout.createSequentialGroup()
                .addGap(0, 930, Short.MAX_VALUE)
                .addComponent(jpSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpBarra1Layout.setVerticalGroup(
            jpBarra1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarra1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jpBarra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        LimpiarTabla();
        ListarCliente();
        tbpTabla.setSelectedIndex(1);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        LimpiarTabla();
        ListarProveedor();
        tbpTabla.setSelectedIndex(2);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        LimpiarTabla();
        ListarProducto();
        tbpTabla.setSelectedIndex(3);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        tbpTabla.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        tbpTabla.setSelectedIndex(4);
        LimpiarTabla();
        ListarVenta();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void jpBarra1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBarra1MousePressed
        xMouse=evt.getX();
       yMouse=evt.getY();
    }//GEN-LAST:event_jpBarra1MousePressed

    private void jpBarra1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpBarra1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse,  y - yMouse);
    }//GEN-LAST:event_jpBarra1MouseDragged

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseEntered
        jpSalir.setBackground(Color.red);
        lblSalir.setForeground(Color.white);
    }//GEN-LAST:event_lblSalirMouseEntered

    private void lblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseExited
       jpSalir.setBackground(Color.WHITE);
        lblSalir.setForeground(Color.red);
    }//GEN-LAST:event_lblSalirMouseExited

    private void btnActualizarProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProduActionPerformed
        if("".equals(txtIdProducto.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtCodigoProduc.getText()) || !"".equals(txtDescripcionProdu.getText()) || !"".equals(txtCantidadProduc.getText()) || !"".equals(txtPrecioProdu.getText())) {
                pro.setCodigo(txtCodigoProduc.getText());
                pro.setNombre(txtDescripcionProdu.getText());
                pro.setProveedor(cbxProveedor.getSelectedItem().toString());
                pro.setStock(Integer.parseInt(txtCantidadProduc.getText()));
                pro.setPrecio(Double.parseDouble(txtPrecioProdu.getText()));
                pro.setId(Integer.parseInt(txtIdProducto.getText()));
                if(proConex.ActualizarProveedor(pro)==true){
                    JOptionPane.showMessageDialog(null, "Producto Modificado");
                    }
                LimpiarTabla();
                ListarProducto();
                LimpiarProducto();
                    
                
            }
        }
    }//GEN-LAST:event_btnActualizarProduActionPerformed

    private void btnEliminarProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProduActionPerformed
        if (!"".equals(txtIdProducto.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas Seguro de Eliminarlo");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdProducto.getText());
                try {
                    proConex.EliminarProductos(id);
                } catch (LecturaExcepcion ex) {
                    Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                LimpiarTabla();
                ListarProducto();
                LimpiarProducto();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnEliminarProduActionPerformed

    private void btnGuardarProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProduActionPerformed
        if (!"".equals(txtCodigoProduc.getText()) || !"".equals(txtDescripcionProdu.getText()) || !"".equals(cbxProveedor.getSelectedItem())
            || !"".equals(txtCantidadProduc.getText())|| !"".equals(txtPrecioProdu.getText())) {
            pro.setCodigo(txtCodigoProduc.getText());
            pro.setNombre(txtDescripcionProdu.getText());
            pro.setProveedor(cbxProveedor.getSelectedItem().toString());
            pro.setStock(Integer.parseInt(txtCantidadProduc.getText()));
            pro.setPrecio(Double.parseDouble(txtPrecioProdu.getText()));
            try {
                if(proConex.RegistrarProductos(pro)==true){
                JOptionPane.showMessageDialog(null, "Producto Registrado");}
                
            } catch (DatoDuplicadoExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LecturaExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            LimpiarTabla();
            ListarProducto();
            LimpiarProducto();
 
        } else {
            JOptionPane.showMessageDialog(null, "Campos Vacios");
        }
    }//GEN-LAST:event_btnGuardarProduActionPerformed

    private void btnNuevoProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProduActionPerformed
        LimpiarProducto();
    }//GEN-LAST:event_btnNuevoProduActionPerformed

    private void jtbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductoMouseClicked
        int fila = jtbProducto.rowAtPoint(evt.getPoint());
        txtIdProducto.setText(jtbProducto.getValueAt(fila, 0).toString());
        txtCodigoProduc.setText(jtbProducto.getValueAt(fila, 1).toString());
        txtDescripcionProdu.setText(jtbProducto.getValueAt(fila, 2).toString());
        cbxProveedor.setSelectedItem(jtbProducto.getValueAt(fila, 3).toString());
        txtCantidadProduc.setText(jtbProducto.getValueAt(fila, 4).toString());
        txtPrecioProdu.setText(jtbProducto.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_jtbProductoMouseClicked

    private void txtCodigoProducKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProducKeyTyped
        events.validarNumeros(evt);
    }//GEN-LAST:event_txtCodigoProducKeyTyped

    private void txtDescripcionProduKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionProduKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtDescripcionProduKeyTyped

    private void txtCantidadProducKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProducKeyTyped
        events.validarNumeros(evt);
    }//GEN-LAST:event_txtCantidadProducKeyTyped

    private void txtPrecioProduKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProduKeyTyped
        events.validarNumerosDecimales(evt, txtPrecioProdu);
    }//GEN-LAST:event_txtPrecioProduKeyTyped

    private void btnEliminarProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveActionPerformed
        if (!"".equals(txtIdProveedor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas Seguro de Eliminarlo");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdProveedor.getText());
                if(prconex.EliminarProveedor(id)==true){
                    JOptionPane.showMessageDialog(null, "Proveedor Eliminado");}
            }     
        }    
        else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
            
        }
           
            
    }//GEN-LAST:event_btnEliminarProveActionPerformed

    private void btnNuevoProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveActionPerformed
        LimpiarProveedor();
    }//GEN-LAST:event_btnNuevoProveActionPerformed

    private void btnActualizarProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveActionPerformed
        if("".equals(txtIdProveedor.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtRucProvee.getText()) || !"".equals(txtNombreProvee.getText()) || !"".equals(txtTelefonoProvee.getText()) || !"".equals(txtDireccionProvee.getText()) || !"".equals(txtRazonProvee.getText())) {
                pr.setRuc(Integer.parseInt(txtRucProvee.getText()));
                pr.setNombre(txtNombreProvee.getText());
                pr.setTelefono(Integer.parseInt(txtTelefonoProvee.getText()));
                pr.setDireccion(txtDireccionProvee.getText());
                pr.setRazon(txtRazonProvee.getText());
                pr.setId(Integer.parseInt(txtIdProveedor.getText()));
                try {
                    if(prconex.ActualizarProveedor(pr)==true){
                    JOptionPane.showMessageDialog(null, "Proveedor Modificado");}
                } catch (LecturaExcepcion ex) {
                    Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EscrituraExcepcion ex) {
                    Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                LimpiarTabla();
                ListarProveedor();
                LimpiarProveedor();
            }
        }
    }//GEN-LAST:event_btnActualizarProveActionPerformed

    private void btnGuardarProveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveActionPerformed
        if (!"".equals(txtRucProvee.getText()) || !"".equals(txtNombreProvee.getText()) || !"".equals(txtTelefonoProvee.getText())
            || !"".equals(txtDireccionProvee.getText())|| !"".equals(txtRazonProvee.getText())) {
            pr.setRuc(Integer.parseInt(txtRucProvee.getText()));
            pr.setNombre(txtNombreProvee.getText());
            pr.setTelefono(Integer.parseInt(txtTelefonoProvee.getText()));
            pr.setDireccion(txtDireccionProvee.getText());
            pr.setRazon(txtRazonProvee.getText());
            
            try {
                if(prconex.RegistrarProveedor(pr)==true){
                JOptionPane.showMessageDialog(null, "Proveedor Registrado");}
                
            } catch (DatoDuplicadoExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LecturaExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EscrituraExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            LimpiarTabla();
            ListarProveedor();
            LimpiarProveedor();
            
        } else {
            JOptionPane.showMessageDialog(null, "Campos Vacios");
        }
    }//GEN-LAST:event_btnGuardarProveActionPerformed

    private void jtbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProveedorMouseClicked
        int fila = jtbProveedor.rowAtPoint(evt.getPoint());
        txtIdProveedor.setText(jtbProveedor.getValueAt(fila, 0).toString());
        txtRucProvee.setText(jtbProveedor.getValueAt(fila, 1).toString());
        txtNombreProvee.setText(jtbProveedor.getValueAt(fila, 2).toString());
        txtTelefonoProvee.setText(jtbProveedor.getValueAt(fila, 3).toString());
        txtDireccionProvee.setText(jtbProveedor.getValueAt(fila, 4).toString());
        txtRazonProvee.setText(jtbProveedor.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_jtbProveedorMouseClicked

    private void txtRazonProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonProveeKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtRazonProveeKeyTyped

    private void txtDireccionProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionProveeKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtDireccionProveeKeyTyped

    private void txtTelefonoProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveeKeyTyped
        events.validarNumeros(evt);
    }//GEN-LAST:event_txtTelefonoProveeKeyTyped

    private void txtNombreProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveeKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtNombreProveeKeyTyped

    private void txtRucProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucProveeKeyTyped
        events.validarNumeros(evt);
    }//GEN-LAST:event_txtRucProveeKeyTyped

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        if (!"".equals(txtIdCli.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Estas Seguro de Eliminarlo");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdCli.getText());
                clicon.EliminarCliente(id);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        LimpiarCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        if ("".equals(txtIdCli.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txtCiCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText())
                || !"".equals(txtDireccionCli.getText())) {
                cl.setCi(Integer.parseInt(txtCiCliente.getText()));
                cl.setNombre(txtNombreCliente.getText());
                cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
                cl.setDireccion(txtDireccionCli.getText());
                cl.setRazon(txtRazonCli.getText());
                cl.setId(Integer.parseInt(txtIdCli.getText()));
                try {
                    if(true == clicon.ActualizarCliente(cl)){
                        JOptionPane.showMessageDialog(null, "Proveedor Modificado");
                }
                    
                    
                } catch (DatoDuplicadoExcepcion | LecturaExcepcion | EscrituraExcepcion ex) {
                    Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                LimpiarTabla();
                ListarCliente();
                LimpiarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        if (!"".equals(txtCiCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText())
            || !"".equals(txtDireccionCli.getText())|| !"".equals(txtRazonCli.getText())) {
            cl.setCi(Integer.parseInt(txtCiCliente.getText()));
            cl.setNombre(txtNombreCliente.getText());
            cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            cl.setDireccion(txtDireccionCli.getText());
            cl.setRazon(txtRazonCli.getText());
            try {
                if(true== clicon.RegistrarCliente(cl)){
                    JOptionPane.showMessageDialog(null, "Cliente Registrado");}   
            } catch (DatoDuplicadoExcepcion | LecturaExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EscrituraExcepcion ex) {
                Logger.getLogger(frmInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            LimpiarTabla();
            LimpiarCliente();
            ListarCliente();
            
        } else {
            JOptionPane.showMessageDialog(null, "Campos Vacios");
        }
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void jtbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbClienteMouseClicked
        int fila = jtbCliente.rowAtPoint(evt.getPoint());
        txtIdCli.setText(jtbCliente.getValueAt(fila, 0).toString());
        txtCiCliente.setText(jtbCliente.getValueAt(fila, 1).toString());
        txtNombreCliente.setText(jtbCliente.getValueAt(fila, 2).toString());
        txtTelefonoCliente.setText(jtbCliente.getValueAt(fila, 3).toString());
        txtDireccionCli.setText(jtbCliente.getValueAt(fila, 4).toString());
        txtRazonCli.setText(jtbCliente.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_jtbClienteMouseClicked

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped
        events.validarNumeros(evt);
    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void txtRazonCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonCliKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtRazonCliKeyTyped

    private void txtDireccionCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionCliKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtDireccionCliKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        events.validarLetras(evt);
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtCiClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiClienteKeyTyped
        events.validarNumeros(evt);
    }//GEN-LAST:event_txtCiClienteKeyTyped

    private void btnDetVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetVentaActionPerformed
        if(jtbTablaHome.getRowCount() > 0){
            if(!"".equals(txtNombreCliHome.getText())){
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                LimpiarTablaVenta();
                LimpiarClienteVenta();
            }else{
                JOptionPane.showMessageDialog(null, "Debes de buscar un cliente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay productos en la venta");
        }
    }//GEN-LAST:event_btnDetVentaActionPerformed

    private void txtCiHomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiHomeKeyTyped
        
    }//GEN-LAST:event_txtCiHomeKeyTyped

    private void txtCiHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiHomeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtCiHome.getText())){
                int ci = Integer.parseInt(txtCiHome.getText());
                cl = clicon.BuscarCliente(ci);
                if(cl.getNombre()!=null){
                    txtNombreCliHome.setText(""+cl.getNombre());
                    txttelefHome.setText(""+cl.getTelefono());
                    txtDirecHome.setText(""+cl.getDireccion());
                    txtRazonHome.setText(""+cl.getRazon());
                }else{
                    txtCiHome.setText("");
                    JOptionPane.showMessageDialog(null, "Cliente no existe");
                }
            }
        }
    }//GEN-LAST:event_txtCiHomeKeyPressed

    private void txtDescripcionHomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionHomeKeyTyped
       
    }//GEN-LAST:event_txtDescripcionHomeKeyTyped

    private void txtCantidadHomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadHomeKeyTyped
       
    }//GEN-LAST:event_txtCantidadHomeKeyTyped

    private void txtCantidadHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadHomeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtCantidadHome.getText())){
                String cod = txtIdHome.getText();
                String descripcion = txtDescripcionHome.getText();
                int cant = Integer.parseInt(txtCantidadHome.getText());
                double precio = Double.parseDouble(txtPrecioHome.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txtStockHome.getText());
                if(stock >= cant){
                    item = item +1;
                    tmp = (DefaultTableModel) jtbTablaHome.getModel();
                    for (int i = 0; i < jtbTablaHome.getRowCount(); i++) {
                        if(jtbTablaHome.getValueAt(i, 1).equals(txtDescripcionHome.getText())){
                            JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(cod);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] ob = new Object[5];
                    ob[0] = lista.get(1);
                    ob[1] = lista.get(2);
                    ob[2] = lista.get(3);
                    ob[3] = lista.get(4);
                    ob[4] = lista.get(5);
                    tmp.addRow(ob);
                    jtbTablaHome.setModel(tmp);
                    TotalPagar();
                    LimpiarVenta();
                    txtIdHome.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadHomeKeyPressed

    private void txtIdHomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdHomeKeyTyped
        
    }//GEN-LAST:event_txtIdHomeKeyTyped

    private void txtIdHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdHomeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            if(!"".equals(txtIdHome.getText())){
                String cod = txtIdHome.getText();
                pro = proConex.BuscarPro(cod);
                if(pro.getNombre()!= null){
                    txtDescripcionHome.setText(""+pro.getNombre());
                    txtPrecioHome.setText(""+pro.getPrecio());
                    txtStockHome.setText(""+pro.getStock());
                    txtCantidadHome.requestFocus();
                }else{
                    LimpiarVenta();
                    txtCantidadHome.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del producto");
                txtCantidadHome.requestFocus();
            }
        }
    }//GEN-LAST:event_txtIdHomeKeyPressed

    private void btnEliminarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarventaActionPerformed
        modelo = (DefaultTableModel) jtbTablaHome.getModel();
        modelo.removeRow(jtbTablaHome.getSelectedRow());
        TotalPagar();
        txtIdHome.requestFocus();
    }//GEN-LAST:event_btnEliminarventaActionPerformed

    private void txtIdCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCliActionPerformed

    private void txtDescripcionHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnActualizarProdu;
    private javax.swing.JButton btnActualizarProve;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnDetVenta;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProdu;
    private javax.swing.JButton btnEliminarProve;
    private javax.swing.JButton btnEliminarventa;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarProdu;
    private javax.swing.JButton btnGuardarProve;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoProdu;
    private javax.swing.JButton btnNuevoProve;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> cbxProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpBarra1;
    private javax.swing.JPanel jpSalir;
    private javax.swing.JTable jtbCliente;
    private javax.swing.JTable jtbProducto;
    private javax.swing.JTable jtbProveedor;
    private javax.swing.JTable jtbTablaHome;
    private javax.swing.JTable jtbVenta;
    private javax.swing.JLabel lblEslogan;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTabbedPane tbpTabla;
    private javax.swing.JTextField txtCantidadHome;
    private javax.swing.JTextField txtCantidadProduc;
    private javax.swing.JTextField txtCiCliente;
    private javax.swing.JTextField txtCiHome;
    private javax.swing.JTextField txtCodigoProduc;
    private javax.swing.JTextField txtDescripcionHome;
    private javax.swing.JTextField txtDescripcionProdu;
    private javax.swing.JTextField txtDirecHome;
    private javax.swing.JTextField txtDireccionCli;
    private javax.swing.JTextField txtDireccionProvee;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtIdHome;
    private javax.swing.JTextField txtIdPro;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombreCliHome;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProvee;
    private javax.swing.JTextField txtPrecioHome;
    private javax.swing.JTextField txtPrecioProdu;
    private javax.swing.JTextField txtRazonCli;
    private javax.swing.JTextField txtRazonHome;
    private javax.swing.JTextField txtRazonProvee;
    private javax.swing.JTextField txtRucProvee;
    private javax.swing.JTextField txtStockHome;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoProvee;
    private javax.swing.JTextField txttelefHome;
    // End of variables declaration//GEN-END:variables

    private void LimpiarCliente() {
        txtIdCli.setText("");
        txtCiCliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCli.setText("");
        txtRazonCli.setText("");
    }
    
    private void LimpiarProveedor() {
        txtIdProveedor.setText("");
        txtRucProvee.setText("");
        txtNombreProvee.setText("");
        txtTelefonoProvee.setText("");
        txtDireccionProvee.setText("");
        txtRazonProvee.setText("");
    }
    
    private void LimpiarProducto() {
        txtIdProducto.setText("");
        txtCodigoProduc.setText("");
        txtDescripcionProdu.setText("");
        cbxProveedor.setSelectedItem(null);
        txtCantidadProduc.setText("");
        txtPrecioProdu.setText("");
    }

    
    private void TotalPagar(){
        totalPagar = 0.00;
        int numfila = jtbTablaHome.getRowCount();
        for (int i = 0; i < numfila; i++) {
            double calcular = Double.parseDouble(String.valueOf(jtbTablaHome.getModel().getValueAt(i, 4)));
            totalPagar = totalPagar + calcular;
        }
        lblTotal.setText(String.format("%.2f",totalPagar));
    }
    
    private void LimpiarVenta(){
        txtIdHome.setText("");
        txtDescripcionHome.setText("");
        txtCantidadHome.setText("");
        txtStockHome.setText("");
        txtPrecioHome.setText("");
        txtIdPro.setText("");
    }
    
    private void RegistrarVenta(){
        String cliente = txtNombreCliHome.getText();
        String vendedor = lblVendedor.getText();
        double monto = totalPagar;
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setTotal(monto);
        
        vConex.RegistrarVenta(v);
    }
    
    private void RegistrarDetalle(){
        int id = vConex.IdVenta();
        for (int i = 0; i < jtbTablaHome.getRowCount(); i++) {
            String cod = jtbTablaHome.getValueAt(i, 0).toString();
            int can = Integer.parseInt(jtbTablaHome.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(jtbTablaHome.getValueAt(i, 3).toString());
            Dv.setCod_Pro(cod);
            Dv.setCantidad(can);
            Dv.setPrecio(precio);
            Dv.setId(id);
            vConex.RegistrarDetalleVenta(Dv);
        }
    }
    
    private void ActualizarStock(){
        for (int i = 0; i < jtbTablaHome.getRowCount(); i++) {
            String cod = jtbTablaHome.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(jtbTablaHome.getValueAt(i, 2).toString());
            pro = proConex.BuscarPro(cod);
            int StockActual = pro.getStock()-cant;
            vConex.ActualizarStock(StockActual, cod);
        }
    }
    
    private void LimpiarTablaVenta(){
        tmp = (DefaultTableModel) jtbTablaHome.getModel();
        int fila = jtbTablaHome.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }
    
    private void LimpiarClienteVenta(){
        txtCiHome.setText("");
        txtNombreCliHome.setText("");
        txttelefHome.setText("");
        txtDirecHome.setText("");
        txtRazonHome.setText("");
    }
}
