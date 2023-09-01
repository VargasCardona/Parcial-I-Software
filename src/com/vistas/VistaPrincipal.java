package com.vistas;

import com.controladores.ControladorGeneral;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaPrincipal extends javax.swing.JFrame {

	ControladorGeneral controlador;

	public VistaPrincipal() {
		controlador = new ControladorGeneral();

		this.setLocationRelativeTo(null);
		setTitle("Buscar Productos");

		initComponents();

		actualizarTabla("");
		tblEmpresas.setDefaultEditor(Object.class, null); // Evitar ediciones en la tabla
		tblEmpresas.getTableHeader().setEnabled(false); // Evitar reorganizaciones de Headers en la tabla
		tblEmpresas.setCellSelectionEnabled(false); // Evitar selecciones en la tabla
	}

	public void actualizarTabla(String where) {
		try {
			DefaultTableModel modelo = new DefaultTableModel();
			tblEmpresas.setModel(modelo);

			ResultSet rs = null;

			if (where.isEmpty()) {
				rs = controlador.listarTabla();
			} else {
				rs = controlador.buscarCoincidencias(where);
			}

			ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
			int cantidadColumnas = rsMd.getColumnCount();

			modelo.addColumn("Nit:");
			modelo.addColumn("Nombre:");
			modelo.addColumn("Años en servicio:");
			modelo.addColumn("Numero de Empleados:");
			modelo.addColumn("Cantidad de Sedes:");
			modelo.addColumn("Servicio Ofrecido:");
			modelo.addColumn("Fundador:");

			int[] anchos = {10, 10, 50, 50, 50, 50, 50};
			for (int i = 0; i < tblEmpresas.getColumnCount(); i++) {
				tblEmpresas.getColumnModel().getColumn(i).setPreferredWidth(anchos[1]);
			}

			Object[] filas = new Object[cantidadColumnas];
			while (rs.next()) {
				for (int i = 0; i < cantidadColumnas; i++) {
					filas[i] = rs.getObject(i + 1);
				}
				modelo.addRow(filas);
			}

			if (modelo.getRowCount() == 0) {
				lblResultados.setText("No se han encontrado coincidencias");
			} else {
				lblResultados.setText(" ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpresas = new javax.swing.JTable();
        lblResultados = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAniosServicio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCantidadSedes = new javax.swing.JTextField();
        txtNumeroEmpleados = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtServicioOfrecido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNombreFundador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar por NIT");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 750, 50));

        tblEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpresas);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 750, 150));

        lblResultados.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblResultados.setForeground(new java.awt.Color(255, 0, 0));
        lblResultados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultados.setText("{Resultados}");
        bg.add(lblResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 750, 20));

        txtNit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNitKeyReleased(evt);
            }
        });
        bg.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 720, 20));

        jLabel3.setText("NIT:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, 20));
        bg.add(lblNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, 20));

        jLabel5.setText("Numero Empleados:");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel6.setText("Años en servicio:");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel7.setText("Cantidad Sedes:");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));
        bg.add(txtAniosServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 200, -1));
        bg.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 200, -1));
        bg.add(txtCantidadSedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 200, -1));
        bg.add(txtNumeroEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 200, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        bg.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 100, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        bg.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 100, -1));

        btnRegistrar.setText("Registrar nueva Empresa");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        bg.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 240, -1));

        jLabel8.setText("Nombre:");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel9.setText("Nit:");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel10.setText("Servicio Ofrecido:");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, -1));
        bg.add(txtServicioOfrecido, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 200, -1));

        jLabel11.setText("Nombre Fundador:");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));
        bg.add(txtNombreFundador, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitKeyReleased
		if (!txtNit.getText().equals("")) {
			actualizarTabla(txtNit.getText());
		} else {
			actualizarTabla("");
		}
    }//GEN-LAST:event_txtNitKeyReleased

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
		try {
			controlador.actualizarTabla(lblNit.getText(),
					txtNombre.getText(),
					txtAniosServicio.getText(),
					txtNumeroEmpleados.getText(),
					txtCantidadSedes.getText(),
					txtServicioOfrecido.getText(),
					txtNombreFundador.getText());

			actualizarTabla("");

			JOptionPane.showMessageDialog(null, "La empresa se actualizo con exito");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
		try {
			controlador.eliminarTabla(lblNit.getText());

			txtNit.setText("");
			actualizarTabla("");

			limpiarCampos();
			JOptionPane.showMessageDialog(null, "Se ha eliminado con exito");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
		VistaRegistrar vista = new VistaRegistrar(this);
		vista.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpresasMouseClicked
		String nit = String.valueOf(tblEmpresas.getValueAt(tblEmpresas.getSelectedRow(), 0));
		try {

			ResultSet rs = controlador.consultarNit(nit);
			ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();

			int cantidadColumnas = rsMd.getColumnCount();

			Object[] filas = new Object[cantidadColumnas];
			while (rs.next()) {
				for (int i = 0; i < cantidadColumnas; i++) {
					filas[i] = rs.getObject(i + 1);
				}
			}

			lblNit.setText((String) filas[0]);
			txtNombre.setText((String) filas[1]);
			txtAniosServicio.setText(String.valueOf((Integer) filas[2]));
			txtNumeroEmpleados.setText(String.valueOf((Integer) filas[3]));
			txtCantidadSedes.setText(String.valueOf((Integer) filas[4]));
			txtServicioOfrecido.setText((String) filas[5]);
			txtNombreFundador.setText((String) filas[6]);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
    }//GEN-LAST:event_tblEmpresasMouseClicked

	private void limpiarCampos() {
		lblNit.setText("");
		txtNombre.setText("");
		txtAniosServicio.setText("");
		txtNumeroEmpleados.setText("");
		txtCantidadSedes.setText("");
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JTable tblEmpresas;
    private javax.swing.JTextField txtAniosServicio;
    private javax.swing.JTextField txtCantidadSedes;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreFundador;
    private javax.swing.JTextField txtNumeroEmpleados;
    private javax.swing.JTextField txtServicioOfrecido;
    // End of variables declaration//GEN-END:variables
}
