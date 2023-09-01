package com.vistas;

import com.controladores.ControladorGeneral;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaRegistrar extends javax.swing.JFrame {

	ControladorGeneral controlador;
	VistaPrincipal vistaPrincipal;

	public VistaRegistrar(VistaPrincipal vistaPrincipal) {
		controlador = new ControladorGeneral();
		this.vistaPrincipal = vistaPrincipal;

		this.setLocationRelativeTo(null);
		setTitle("Registrar Producto");

		initComponents();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar unicamente la ventana actual
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAniosServicio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNumeroSedes = new javax.swing.JTextField();
        txtNumeroEmpleados = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreFundador = new javax.swing.JTextField();
        txtServicioOfrecido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Empresa");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 50));

        jLabel4.setText("Nombre:");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel5.setText("Numero de Empleados:");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setText("Años en servicio:");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel7.setText("Numero de Sedes:");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        bg.add(txtAniosServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 240, -1));
        bg.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 240, -1));
        bg.add(txtNumeroSedes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 240, -1));
        bg.add(txtNumeroEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 240, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        bg.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 340, 30));

        jLabel8.setText("Servicio Ofrecido:");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel9.setText("Nombre Fundador:");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));
        bg.add(txtNombreFundador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 240, -1));
        bg.add(txtServicioOfrecido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
		try {
			controlador.insertarTabla(txtNombre.getText(),
					txtAniosServicio.getText(),
					txtNumeroEmpleados.getText(),
					txtNumeroSedes.getText(),
					txtServicioOfrecido.getText(),
					txtNombreFundador.getText());

			this.dispose();
			vistaPrincipal.actualizarTabla("");
			JOptionPane.showMessageDialog(null, "Empresa Registrada");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
    }//GEN-LAST:event_btnRegistrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAniosServicio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreFundador;
    private javax.swing.JTextField txtNumeroEmpleados;
    private javax.swing.JTextField txtNumeroSedes;
    private javax.swing.JTextField txtServicioOfrecido;
    // End of variables declaration//GEN-END:variables
}
