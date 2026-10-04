package Ventanas;

import Conceptos.Servicio;
import Conceptos.Veterinario;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana modal para la gestión de Médicos Veterinarios (CRUD).
 * 
 * @author fuent
 */
public class VentanaVeterinarios extends javax.swing.JDialog {

    //arraylist veterinarios y servicios
    private ArrayList<Veterinario> listaVeterinarios;
    private ArrayList<Servicio> listaServicios;
    
    //archivo para guardar
    File archivoVeterinarios = new File("data\\veterinarios.xml");

    /**
     * Constructor que inicializa los componentes y carga las listas.
     */
    public VentanaVeterinarios(java.awt.Frame parent, boolean modal, ArrayList<Veterinario> listaVeterinarios, ArrayList<Servicio> listaServicios) {
        super(parent, modal);
        initComponents();
        this.listaVeterinarios = listaVeterinarios;
        this.listaServicios = listaServicios;
        this.textFieldID.setEditable(false);
        this.textFieldID.setText(generarNuevoId());
        LlenarTabla();
    }

    /**
     * Genera un nuevo ID secuencial automático para veterinarios.
     */
    private String generarNuevoId() {
        int maxId = 0;
        if (this.listaVeterinarios != null) {
            for (Veterinario v : this.listaVeterinarios) {
                try {
                    int idNum = Integer.parseInt(v.getIdentificacion().trim());
                    if (idNum > maxId) {
                        maxId = idNum;
                    }
                } catch (NumberFormatException e) {
                    // ignorar identificaciones no numéricas
                }
            }
        }
        return String.valueOf(maxId == 0 ? 200 : maxId + 1);
    }

    /**
     * Llena la tabla visual con los veterinarios y el resumen de servicios validados.
     */
    private void LlenarTabla() {
        // Encabezados de las columnas de la tabla
        Vector<String> titulos = new Vector<>();
        titulos.addElement("ID");
        titulos.addElement("Nombre");
        titulos.addElement("Puesto");
        titulos.addElement("Servicios Validados");

        // Estructura para almacenar las filas de datos
        Vector<Vector<String>> filas = new Vector<>();
        
        // Poblado de filas con la información de cada persona
        if (this.listaVeterinarios != null) {
            for (Veterinario v : this.listaVeterinarios) {
                Vector<String> fila = new Vector<>();
                fila.addElement(v.getIdentificacion());
                fila.addElement(v.getNombre());
                fila.addElement(v.getPuesto());
                int cantServicios = (v.getListaServicios() != null) ? v.getListaServicios().size() : 0;
                fila.addElement(cantServicios + " servicio(s)");
                filas.addElement(fila);
            }
        }

        // Asignación del modelo de datos a la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(filas, titulos);
        this.tableVeterinarios.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelVeterinarios = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        labelID = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelPuesto = new javax.swing.JLabel();
        labelServicios = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        textFieldPuesto = new javax.swing.JTextField();
        buttonVerServicios = new javax.swing.JButton();
        buttonLimpiar = new javax.swing.JButton();
        buttonNuevo = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonBorrar = new javax.swing.JButton();
        buttonSalir = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeterinarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Médicos Veterinarios");

        labelVeterinarios.setText("Médicos Veterinarios");

        labelID.setText("ID:");

        labelNombre.setText("NOMBRE:");

        labelPuesto.setText("PUESTO:");

        labelServicios.setText("SERVICIOS:");

        buttonVerServicios.setText("Ver / Editar Servicios");
        buttonVerServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerServiciosActionPerformed(evt);
            }
        });

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
        ButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSalvarMouseClicked(evt);
            }
        });
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        tableVeterinarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Puesto", "Servicios Validados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVeterinarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVeterinariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVeterinarios);

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
                            .addComponent(labelVeterinarios)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelID)
                                    .addComponent(labelNombre)
                                    .addComponent(labelPuesto)
                                    .addComponent(labelServicios))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(textFieldNombre)
                                    .addComponent(textFieldPuesto)
                                    .addComponent(buttonVerServicios, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
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
                .addComponent(labelVeterinarios)
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
                    .addComponent(labelPuesto)
                    .addComponent(textFieldPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelServicios)
                    .addComponent(buttonVerServicios)
                    .addComponent(buttonBorrar))
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

    private void ButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSalvarMouseClicked
        //guardar en archivo xml
        Util.GuardadorXML.guardarVeterinarios(listaVeterinarios, archivoVeterinarios);
        javax.swing.JOptionPane.showMessageDialog(this, "Se guardo correctamente");
    }//GEN-LAST:event_ButtonSalvarMouseClicked

    private void tableVeterinariosMouseClicked(java.awt.event.MouseEvent evt) {
        //obtener row
        int fila = tableVeterinarios.getSelectedRow();
        
        //Actualizo los textfields
        if (fila != -1) {
            textFieldID.setText(tableVeterinarios.getValueAt(fila, 0).toString());
            textFieldNombre.setText(tableVeterinarios.getValueAt(fila, 1).toString());
            textFieldPuesto.setText(tableVeterinarios.getValueAt(fila, 2).toString());
        }
    }

    private void buttonLimpiarMouseClicked(java.awt.event.MouseEvent evt) {
        //limpia los textfiel y la tabla
        textFieldID.setText(generarNuevoId());
        textFieldNombre.setText("");
        textFieldPuesto.setText("");
        tableVeterinarios.clearSelection();
    }

    private void buttonSalirMouseClicked(java.awt.event.MouseEvent evt) {
        //Limpia y sale
        buttonLimpiarMouseClicked(null);
        this.dispose();
    }

    private void buttonNuevoMouseClicked(java.awt.event.MouseEvent evt) {
        //obtener valores de la tabla
        String id = generarNuevoId();
        String nombre = textFieldNombre.getText().trim();
        String puesto = textFieldPuesto.getText().trim();

        //validaciones
        if (nombre.isBlank() || puesto.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos");
            return;
        }

        //validar que no exista otro veterinario con el mismo nombre
        for (Veterinario v : listaVeterinarios) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un veterinario con ese nombre");
                return;
            }
        }

        //creacion nuevo veterinario
        Veterinario nuevoVeterinario = new Veterinario();
        nuevoVeterinario.setIdentificacion(id);
        nuevoVeterinario.setNombre(nombre);
        nuevoVeterinario.setPuesto(puesto);

        //añado el veterinario y actualizo la tabla
        this.listaVeterinarios.add(nuevoVeterinario);
        LlenarTabla();
        buttonLimpiarMouseClicked(null);
    }

    private void buttonModificarMouseClicked(java.awt.event.MouseEvent evt) {
        //obtener row
        int fila = tableVeterinarios.getSelectedRow();
        
        //validaciones
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un veterinario para modificarlo");
            return;
        }

        //obtengo los valores 
        String id = tableVeterinarios.getValueAt(fila, 0).toString();
        String nombre = textFieldNombre.getText().trim();
        String puesto = textFieldPuesto.getText().trim();

        //validaciones
        if (nombre.isBlank() || puesto.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos");
            return;
        }

        //validar que no exista otro veterinario con el mismo nombre
        for (Veterinario v : listaVeterinarios) {
            if (!v.getIdentificacion().equalsIgnoreCase(id) && v.getNombre().equalsIgnoreCase(nombre)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe otro veterinario con ese nombre");
                return;
            }
        }

        //encontrar veterinario
        for (Veterinario v : listaVeterinarios) {
            if (v.getIdentificacion().equalsIgnoreCase(id)) {
                v.setNombre(nombre);
                v.setPuesto(puesto);
                LlenarTabla();
                buttonLimpiarMouseClicked(null);
                return;
            }
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Veterinario no encontrado");
    }

    private void buttonBorrarMouseClicked(java.awt.event.MouseEvent evt) {
        //obtener row
        int fila = tableVeterinarios.getSelectedRow();
        
        //validar seleccion
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un veterinario para borrarlo");
            return;
        }

        //confirmar eliminacion
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea eliminar el médico veterinario seleccionado?",
            "Confirmar eliminación",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );
        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        //eliminar veterinario de la lista
        String id = tableVeterinarios.getValueAt(fila, 0).toString();
        for (int i = 0; i < listaVeterinarios.size(); i++) {
            if (listaVeterinarios.get(i).getIdentificacion().equalsIgnoreCase(id)) {
                listaVeterinarios.remove(i);
                break;
            }
        }
        
        //actualizar tabla y limpiar
        LlenarTabla();
        buttonLimpiarMouseClicked(null);
    }

    private void buttonVerServiciosActionPerformed(java.awt.event.ActionEvent evt) {
        //obtener row
        int fila = tableVeterinarios.getSelectedRow();
        
        //validar seleccion
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un veterinario para ver o editar sus servicios");
            return;
        }

        //buscar veterinario seleccionado
        String id = tableVeterinarios.getValueAt(fila, 0).toString();
        Veterinario vetSeleccionado = null;
        for (Veterinario v : this.listaVeterinarios) {
            if (v.getIdentificacion().equalsIgnoreCase(id)) {
                vetSeleccionado = v;
                break;
            }
        }

        //abrir ventana de dialogo para seleccionar servicios
        if (vetSeleccionado != null) {
            DialogServiciosValidados dialog = new DialogServiciosValidados(this, true, vetSeleccionado, this.listaServicios);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
            LlenarTabla();
        }
    }

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        //guardar en archivo xml
        Util.GuardadorXML.guardarVeterinarios(listaVeterinarios, "data/veterinarios.xml");
        javax.swing.JOptionPane.showMessageDialog(this, "Se guardó correctamente");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JButton buttonBorrar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JButton buttonVerServicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPuesto;
    private javax.swing.JLabel labelServicios;
    private javax.swing.JLabel labelVeterinarios;
    private javax.swing.JTable tableVeterinarios;
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPuesto;
    // End of variables declaration//GEN-END:variables
}
