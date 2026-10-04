package Ventanas;

import Conceptos.Cliente;
import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Ventana principal (Escritorio) de la aplicación.
 * Actúa como lanzador visual para Clientes, Servicios y Médicos Veterinarios.
 * 
 * @author fuent
 */
public class Escritorio extends javax.swing.JFrame {

    //listas de datos
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Servicio> listaServicios;
    private ArrayList<Veterinario> listaVeterinarios;

    /**
     * Constructor por defecto.
     */
    public Escritorio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(1024, 768);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        cargarIconos();
    }

    /**
     * Constructor que recibe las 3 listas de datos cargadas desde los XML.
     */
    public Escritorio(ArrayList<Cliente> clientes, ArrayList<Servicio> servicios, ArrayList<Veterinario> veterinarios) {
        this();
        this.listaClientes = clientes;
        this.listaServicios = servicios;
        this.listaVeterinarios = veterinarios;
    }

    /**
     * Carga las imágenes de la carpeta Imagenes/ y las asigna a los botones.
     */
    private void cargarIconos() {
        //cargar imagenes para los botones
        try {
            File imgClientes = new File("Imagenes/clientes.png");
            if (imgClientes.exists()) {
                buttonClientes.setIcon(new ImageIcon(imgClientes.getAbsolutePath()));
            }
            File imgServicios = new File("Imagenes/servicios.png");
            if (imgServicios.exists()) {
                buttonServicios.setIcon(new ImageIcon(imgServicios.getAbsolutePath()));
            }
            File imgVeterinarios = new File("Imagenes/veterinarios.png");
            if (imgVeterinarios.exists()) {
                buttonVeterinarios.setIcon(new ImageIcon(imgVeterinarios.getAbsolutePath()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        buttonClientes = new javax.swing.JButton();
        buttonServicios = new javax.swing.JButton();
        buttonVeterinarios = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Veterinaria Plus");

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Clínica Veterinaria - Menú Principal");

        buttonClientes.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonClientes.setText("Clientes");
        buttonClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClientesActionPerformed(evt);
            }
        });

        buttonServicios.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonServicios.setText("Servicios");
        buttonServicios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonServicios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonServiciosActionPerformed(evt);
            }
        });

        buttonVeterinarios.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        buttonVeterinarios.setText("Médicos Veterinarios");
        buttonVeterinarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonVeterinarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVeterinariosActionPerformed(evt);
            }
        });

        menuArchivo.setText("Archivo");

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemSalir);

        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buttonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(buttonVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVeterinarios, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de veterinarios
        VentanaVeterinarios ventana = new VentanaVeterinarios(this, true, this.listaVeterinarios, this.listaServicios);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void buttonServiciosActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de servicios
        VentanaServicios ventana = new VentanaServicios(this, true, this.listaServicios);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void buttonClientesActionPerformed(java.awt.event.ActionEvent evt) {
        //abrir ventana de clientes
        VentanaClientes ventana = new VentanaClientes(this, true, this.listaClientes);
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {
        //salir del programa
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Escritorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClientes;
    private javax.swing.JButton buttonServicios;
    private javax.swing.JButton buttonVeterinarios;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemSalir;
    // End of variables declaration//GEN-END:variables
}
