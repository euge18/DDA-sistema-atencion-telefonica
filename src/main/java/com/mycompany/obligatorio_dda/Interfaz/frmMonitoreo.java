/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.obligatorio_dda.Interfaz;

import com.mycompany.obligatorio_dda.Controladores.Mantenimientos.MantMonitoreoController;
import com.mycompany.obligatorio_dda.Controladores.Interfaces.VentanaMantMonitoreo;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Llamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Sector;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public class frmMonitoreo extends javax.swing.JFrame implements VentanaMantMonitoreo{

    
    private MantMonitoreoController controlador;
    /**
     * Creates new form frmMonitoreo
     */
    public frmMonitoreo() {
        initComponents();
        this.controlador = new MantMonitoreoController(this);
        controlador.listarLlamadas();
        mostrarSectorSeleccionado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstSectores = new javax.swing.JList<>();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLlmadas = new javax.swing.JList<>();
        btnSalir = new javax.swing.JButton();
        lblSector = new javax.swing.JLabel();
        lblSectoresTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstSectores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSectoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstSectores);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setText("Aplicación de Monitoreo");

        jScrollPane2.setViewportView(lstLlmadas);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblSector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSector.setText("Sector Seleccionado:");

        lblSectoresTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSectoresTitulo.setText("Sectores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addComponent(lblSector))
                        .addComponent(lblTitulo)
                        .addComponent(lblSectoresTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblSectoresTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void lstSectoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSectoresValueChanged
          controlador.listarLlamadas();
          mostrarSectorSeleccionado();
    }//GEN-LAST:event_lstSectoresValueChanged

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
            java.util.logging.Logger.getLogger(frmMonitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMonitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMonitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMonitoreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMonitoreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblSectoresTitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Object> lstLlmadas;
    private javax.swing.JList<Object> lstSectores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarSectores(ArrayList<Sector> sectores) {
        Sector sectorTodos = new Sector(-1, "<Todos los Sectores>");
        ArrayList<Sector> sectoresListado = new ArrayList<Sector>();
        sectoresListado.add(sectorTodos);
        for (Sector s : sectores){
            sectoresListado.add(s);
        }
        lstSectores.setListData((sectoresListado.toArray()));
    }

    @Override
    public void mostrarLlamadas(ArrayList<Llamada> llamadas) {
        Llamada llamadaEncabezado = new Llamada(-1, "# llamda | Estado | Inicio | Fin | # puesto | Trabajador | Duración | Costo | Cliente | Saldo");
        ArrayList<Llamada> llamadasAListar = new ArrayList<Llamada>();
        llamadasAListar.add(llamadaEncabezado);
        for (Llamada l : llamadas){
            llamadasAListar.add(l);
        }
        lstLlmadas.setListData((llamadasAListar.toArray()));
    }

    @Override
    public Sector obtenerSectorSeleccionado() {
        if (lstSectores.getSelectedIndex() >= 0) {
            return (Sector) lstSectores.getSelectedValue();
        }
        return null;
    }
    
    public void mostrarSectorSeleccionado(){
        Sector sectorSelected = obtenerSectorSeleccionado();
        if (sectorSelected==null){
            lblSector.setText("Sector Seleccionado: Ninguno");
        } else {
            lblSector.setText("Sector Seleccionado: " + sectorSelected.getNombre());
        }
    }

}
