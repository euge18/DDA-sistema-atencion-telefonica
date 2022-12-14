/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.obligatorio_dda.Interfaz;

import com.mycompany.obligatorio_dda.Controladores.Mantenimientos.AppTrabajadorController;
import com.mycompany.obligatorio_dda.Controladores.Interfaces.VentanaTrabajador;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Trabajador;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AplicacionTrabajador extends javax.swing.JFrame implements VentanaTrabajador{
    private Trabajador trabajador;
    private AppTrabajadorController controlador;
    /**
     * Creates new form AplicacionTrabajador
     */
    public AplicacionTrabajador(Trabajador trabajador) {
        initComponents();
        this.trabajador = trabajador;
        this.controlador = new AppTrabajadorController(this, trabajador);
        mostrarDatosInicialesTrabajador();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombreTrabajador = new javax.swing.JLabel();
        lblSectorNumPuesto = new javax.swing.JLabel();
        lblLlamadasAtendidas = new javax.swing.JLabel();
        lblTiempoPromedio = new javax.swing.JLabel();
        lblNumLlamadasAtendidas = new javax.swing.JLabel();
        lblNumPromedioTiempo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblIndicadorEstadoLlamada = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        btnFinalizarLlamada = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Aplicacion para trabajador");

        lblNombreTrabajador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreTrabajador.setText("Nombre trabajador");

        lblSectorNumPuesto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSectorNumPuesto.setText("Sector y numero puesto");

        lblLlamadasAtendidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLlamadasAtendidas.setText("Llamadas atendidas");

        lblTiempoPromedio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTiempoPromedio.setText("Tiempo promedio");

        lblNumLlamadasAtendidas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNumLlamadasAtendidas.setText("0");

        lblNumPromedioTiempo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNumPromedioTiempo.setText("0");

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescripcion.setText("Descripcion:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblIndicadorEstadoLlamada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIndicadorEstadoLlamada.setText("Bienvenido");

        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCliente.setText("Cliente:");

        lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombreCliente.setText("Nombre cliente");

        btnFinalizarLlamada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizarLlamada.setText("Finalizar llamada");
        btnFinalizarLlamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarLlamadaActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo)
                            .addComponent(lblSectorNumPuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                            .addComponent(lblNombreTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblLlamadasAtendidas)
                                .addGap(39, 39, 39)
                                .addComponent(lblTiempoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(lblNumLlamadasAtendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNumPromedioTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(btnFinalizarLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblIndicadorEstadoLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1)))
                        .addGap(0, 62, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(lblCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTiempoPromedio)
                            .addComponent(lblLlamadasAtendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombreTrabajador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSectorNumPuesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumLlamadasAtendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumPromedioTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)))
                .addComponent(lblIndicadorEstadoLlamada)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(lblNombreCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarLlamada, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        boolean salir = controlador.salirAplicacion();
        if(salir){
            this.setVisible(false); 
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnFinalizarLlamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarLlamadaActionPerformed
        controlador.finalizarLlamada();
    }//GEN-LAST:event_btnFinalizarLlamadaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplicacionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AplicacionTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarLlamada;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblIndicadorEstadoLlamada;
    private javax.swing.JLabel lblLlamadasAtendidas;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreTrabajador;
    private javax.swing.JLabel lblNumLlamadasAtendidas;
    private javax.swing.JLabel lblNumPromedioTiempo;
    private javax.swing.JLabel lblSectorNumPuesto;
    private javax.swing.JLabel lblTiempoPromedio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getDescripcion() {
        return txtDescripcion.getText();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarDatosInicialesTrabajador() {
        int numPuesto = trabajador.getSector().obtenerPuestoTrabajador(trabajador).getNumeroPuesto();
        lblNombreTrabajador.setText(trabajador.getNombre());
        lblSectorNumPuesto.setText("Sector: " + trabajador.getSector().getNombre() + " | Puesto Nro. #" + numPuesto);
    }

    @Override
    public void mostrarMensajeLlamadaEnCurso(String mensaje) {
        lblIndicadorEstadoLlamada.setText("");
        lblIndicadorEstadoLlamada.setText(mensaje);
    }

    @Override
    public void mostrarNombreCliente(String nombre) {
        lblNombreCliente.setText("");
        lblNombreCliente.setText(nombre);
    }

    @Override
    public void mostrarCantidadLlamadasAtendidas(int cant) {
        lblNumLlamadasAtendidas.setText(Integer.toString(cant));
    }

    @Override
    public void limpiarPantalla() {
        txtDescripcion.setText("");
        lblNombreCliente.setText("");
        
    }

    @Override
    public void mostrarTiempoPromedioLlamadas(float cant) {
        lblNumPromedioTiempo.setText(Integer.toString((int)cant));
    }
}
