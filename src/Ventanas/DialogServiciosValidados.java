package Ventanas;

import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Diálogo modal para marcar/desmarcar con checkboxes los servicios
 * que un médico veterinario específico está validado a realizar.
 * 
 * @author fuent
 */
public class DialogServiciosValidados extends javax.swing.JDialog {

    private Veterinario veterinario;
    private ArrayList<Servicio> catalogoServicios;

    /**
     * Constructor que recibe el veterinario seleccionado y el catálogo completo de servicios.
     */
    public DialogServiciosValidados(java.awt.Dialog parent, boolean modal, Veterinario veterinario, ArrayList<Servicio> catalogoServicios) {
        super(parent, modal);
        initComponents();
        this.veterinario = veterinario;
        this.catalogoServicios = catalogoServicios;
        
        if (veterinario != null) {
            this.labelTitulo.setText("Servicios asignados a: " + veterinario.getNombre() + " (" + veterinario.getPuesto() + ")");
        }
        
        llenarTablaServicios();
    }

    /**
     * Llena la tabla con la lista completa de servicios.
     * Marca el checkbox en true si el veterinario ya tiene asignado ese servicio.
     */
    private void llenarTablaServicios() {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"Validado", "Servicio"}, 0
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class; // Renderiza como checkbox interactivo
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 0; // Solo el checkbox es editable
            }
        };

        if (this.catalogoServicios != null) {
            for (Servicio s : this.catalogoServicios) {
                boolean estaValidado = false;
                if (this.veterinario != null && this.veterinario.getListaServicios() != null) {
                    for (Servicio vs : this.veterinario.getListaServicios()) {
                        if (vs.getIdentificacion().equalsIgnoreCase(s.getIdentificacion())) {
                            estaValidado = true;
                            break;
                        }
                    }
                }
                modelo.addRow(new Object[]{estaValidado, s.getNombre() + " (ID: " + s.getIdentificacion() + " - ₡" + s.getPrecio() + ")"});
            }
        }

        this.tableServicios.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableServicios = new javax.swing.JTable();
        buttonCancelar = new javax.swing.JButton();
        buttonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Servicios Validados");

        labelTitulo.setText("Servicios Validados");

        tableServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Validado", "Servicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableServicios);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonAceptar.setText("Aceptar");
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptar)
                    .addComponent(buttonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.veterinario != null && this.catalogoServicios != null) {
            ArrayList<Servicio> serviciosSeleccionados = new ArrayList<>();
            for (int i = 0; i < this.catalogoServicios.size(); i++) {
                Boolean marcado = (Boolean) this.tableServicios.getValueAt(i, 0);
                if (marcado != null && marcado) {
                    serviciosSeleccionados.add(this.catalogoServicios.get(i));
                }
            }
            this.veterinario.setListaServicios(serviciosSeleccionados);
        }
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tableServicios;
    // End of variables declaration//GEN-END:variables
}
