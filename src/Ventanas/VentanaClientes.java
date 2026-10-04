package Ventanas;

import Conceptos.Cliente;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana modal para la gestión de Clientes (CRUD).
 * 
 * @author fuent
 */
public class VentanaClientes extends javax.swing.JDialog {

    private ArrayList<Cliente> listaClientes;

    /**
     * Constructor que inicializa los componentes y carga la lista de clientes.
     */
    public VentanaClientes(java.awt.Frame parent, boolean modal, ArrayList<Cliente> listaClientes) {
        super(parent, modal);
        initComponents();
        this.listaClientes = listaClientes;
        this.textFieldID.setEditable(false);
        this.textFieldID.setText(generarNuevoId());
        LlenarTabla();
    }

    /**
     * Genera un nuevo ID secuencial automático basado en los IDs existentes.
     */
    private String generarNuevoId() {
        long maxId = 300000000L;
        if (this.listaClientes != null) {
            for (Cliente c : this.listaClientes) {
                try {
                    long idNum = Long.parseLong(c.getIdentificacion().trim());
                    if (idNum > maxId) {
                        maxId = idNum;
                    }
                } catch (NumberFormatException e) {
                    // ignorar identificaciones no numéricas
                }
            }
        }
        return String.valueOf(maxId + 1);
    }

    /**
     * Llena la tabla visual con los objetos de la lista de clientes.
     */
    private void LlenarTabla() {
        Vector<String> titulos = new Vector<>();
        titulos.addElement("ID");
        titulos.addElement("Nombre");
        titulos.addElement("Propietario");
        titulos.addElement("Teléfono");
        titulos.addElement("Email");

        Vector<Vector<String>> filas = new Vector<>();
        if (this.listaClientes != null) {
            for (Cliente c : this.listaClientes) {
                Vector<String> fila = new Vector<>();
                fila.addElement(c.getIdentificacion());
                fila.addElement(c.getNombre());
                fila.addElement(c.getPropietario());
                fila.addElement(c.getTelefono());
                fila.addElement(c.getEmail());
                filas.addElement(fila);
            }
        }

        DefaultTableModel modeloTabla = new DefaultTableModel(filas, titulos);
        this.tableClientes.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelClientes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        labelID = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelPropietario = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        textFieldPropietario = new javax.swing.JTextField();
        textFieldTelefono = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        buttonLimpiar = new javax.swing.JButton();
        buttonNuevo = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonBorrar = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        labelClientes.setText("Clientes");

        labelID.setText("ID:");

        labelNombre.setText("NOMBRE:");

        labelPropietario.setText("PROPIETARIO:");

        labelTelefono.setText("TELÉFONO:");

        labelEmail.setText("EMAIL:");

        buttonLimpiar.setText("Limpiar");
        buttonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLimpiarMouseClicked(evt);
            }
        });

        buttonNuevo.setText("Nuevo");
        buttonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNuevoMouseClicked(evt);
            }
        });

        buttonModificar.setText("Modificar");
        buttonModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModificarMouseClicked(evt);
            }
        });

        buttonBorrar.setText("Borrar");
        buttonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBorrarMouseClicked(evt);
            }
        });

        buttonSalir.setText("Salir");
        buttonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSalirMouseClicked(evt);
            }
        });

        ButtonSalvar.setText("Salvar");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nombre", "Propietario", "Teléfono", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelClientes)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelID)
                                    .addComponent(labelNombre)
                                    .addComponent(labelPropietario)
                                    .addComponent(labelTelefono)
                                    .addComponent(labelEmail))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(textFieldNombre)
                                    .addComponent(textFieldPropietario)
                                    .addComponent(textFieldTelefono)
                                    .addComponent(textFieldEmail))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelID)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPropietario)
                    .addComponent(textFieldPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalir)
                    .addComponent(ButtonSalvar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tableClientes.getSelectedRow();
        if (fila != -1) {
            textFieldID.setText(tableClientes.getValueAt(fila, 0).toString());
            textFieldNombre.setText(tableClientes.getValueAt(fila, 1).toString());
            textFieldPropietario.setText(tableClientes.getValueAt(fila, 2).toString());
            textFieldTelefono.setText(tableClientes.getValueAt(fila, 3).toString());
            textFieldEmail.setText(tableClientes.getValueAt(fila, 4).toString());
        }
    }

    private void buttonLimpiarMouseClicked(java.awt.event.MouseEvent evt) {
        textFieldID.setText(generarNuevoId());
        textFieldNombre.setText("");
        textFieldPropietario.setText("");
        textFieldTelefono.setText("");
        textFieldEmail.setText("");
        tableClientes.clearSelection();
    }

    private void buttonSalirMouseClicked(java.awt.event.MouseEvent evt) {
        buttonLimpiarMouseClicked(null);
        this.dispose();
    }

    private void buttonNuevoMouseClicked(java.awt.event.MouseEvent evt) {
        String id = generarNuevoId();
        String nombre = textFieldNombre.getText().trim();
        String propietario = textFieldPropietario.getText().trim();
        String telefono = textFieldTelefono.getText().trim();
        String email = textFieldEmail.getText().trim();

        if (nombre.isBlank() || propietario.isBlank() || telefono.isBlank() || email.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos");
            return;
        }

        for (Cliente c : listaClientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese nombre");
                return;
            }
        }

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setIdentificacion(id);
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setPropietario(propietario);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setEmail(email);

        this.listaClientes.add(nuevoCliente);
        LlenarTabla();
        buttonLimpiarMouseClicked(null);
    }

    private void buttonModificarMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tableClientes.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificarlo");
            return;
        }

        String id = tableClientes.getValueAt(fila, 0).toString();
        String nombre = textFieldNombre.getText().trim();
        String propietario = textFieldPropietario.getText().trim();
        String telefono = textFieldTelefono.getText().trim();
        String email = textFieldEmail.getText().trim();

        if (nombre.isBlank() || propietario.isBlank() || telefono.isBlank() || email.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos");
            return;
        }

        //validar que no exista otro cliente con el mismo nombre
        for (Cliente c : listaClientes) {
            if (!c.getIdentificacion().equalsIgnoreCase(id) && c.getNombre().equalsIgnoreCase(nombre)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe otro cliente con ese nombre");
                return;
            }
        }

        for (Cliente c : listaClientes) {
            if (c.getIdentificacion().equalsIgnoreCase(id)) {
                c.setNombre(nombre);
                c.setPropietario(propietario);
                c.setTelefono(telefono);
                c.setEmail(email);
                LlenarTabla();
                buttonLimpiarMouseClicked(null);
                return;
            }
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente no encontrado");
    }

    private void buttonBorrarMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tableClientes.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para borrarlo");
            return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea eliminar el cliente seleccionado?",
            "Confirmar eliminación",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );
        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        String id = tableClientes.getValueAt(fila, 0).toString();
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getIdentificacion().equalsIgnoreCase(id)) {
                listaClientes.remove(i);
                break;
            }
        }
        LlenarTabla();
        buttonLimpiarMouseClicked(null);
    }

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Salvar a archivo XML (por implementar)
        javax.swing.JOptionPane.showMessageDialog(this, "Guardado pendiente de implementar");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelClientes;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPropietario;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPropietario;
    private javax.swing.JTextField textFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
