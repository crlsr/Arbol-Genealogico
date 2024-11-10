/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VENTANAS;

import JSON.LecturaJSON;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marco
 */
public class CARGAR_JSON extends javax.swing.JFrame {
    static LecturaJSON json;
    /**
     * Creates new form CARGAR_JSON
     */
    public CARGAR_JSON() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.json=json;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TITULO = new javax.swing.JLabel();
        CERRAR = new javax.swing.JButton();
        ICONO_JSON = new javax.swing.JLabel();
        INSTRUCCIONES = new javax.swing.JButton();
        CARGAR_JSON = new javax.swing.JButton();
        REGRESAR = new javax.swing.JButton();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARGAR JSON");
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TITULO.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TITULO.setForeground(new java.awt.Color(255, 255, 255));
        TITULO.setText("CARGAR JSON");
        getContentPane().add(TITULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        CERRAR.setBackground(new java.awt.Color(255, 0, 0));
        CERRAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CERRAR.setForeground(new java.awt.Color(255, 255, 255));
        CERRAR.setText("X");
        CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        ICONO_JSON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/JSON.png"))); // NOI18N
        getContentPane().add(ICONO_JSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 120, -1));

        INSTRUCCIONES.setBackground(new java.awt.Color(0, 0, 0));
        INSTRUCCIONES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        INSTRUCCIONES.setForeground(new java.awt.Color(255, 255, 255));
        INSTRUCCIONES.setText("INSTRUCCIONES");
        INSTRUCCIONES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSTRUCCIONESActionPerformed(evt);
            }
        });
        getContentPane().add(INSTRUCCIONES, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        CARGAR_JSON.setBackground(new java.awt.Color(0, 0, 0));
        CARGAR_JSON.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CARGAR_JSON.setForeground(new java.awt.Color(255, 255, 255));
        CARGAR_JSON.setText("CARGAR JSON");
        CARGAR_JSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARGAR_JSONActionPerformed(evt);
            }
        });
        getContentPane().add(CARGAR_JSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        REGRESAR.setBackground(new java.awt.Color(0, 0, 0));
        REGRESAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setText("REGRESAR");
        REGRESAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGRESARActionPerformed(evt);
            }
        });
        getContentPane().add(REGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/FONDO.png"))); // NOI18N
        getContentPane().add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CERRARActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CERRARActionPerformed

    public Image getIconImage() {
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/ICONO_TRONO.png"));
        return icono;
    }
    
    private void CARGAR_JSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARGAR_JSONActionPerformed
        try {
        JFileChooser finder = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos JSON", "json");
        finder.setFileFilter(filter);
        int response = finder.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            File selected = finder.getSelectedFile(); 
            if (json ==null){
                json=new LecturaJSON(selected);
                json.dataConstructor();
            }else{
                // this.json.changeJSON(selected, this.grafo);
            }
            if(json != null){
                JOptionPane.showMessageDialog(this, "El JSON se ha cargado correctamente");
            }
        }
        }    
        catch (Exception e){
           JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado!!!");
       }
    }//GEN-LAST:event_CARGAR_JSONActionPerformed

    private void REGRESARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGRESARActionPerformed
        if(json!=null){
            MENU M = new MENU();
            M.setVisible(true);
            this.setVisible(false);}
        else{
            JOptionPane.showMessageDialog(this, "Agregue un JSON");
        }
    }//GEN-LAST:event_REGRESARActionPerformed

    private void INSTRUCCIONESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSTRUCCIONESActionPerformed
        JOptionPane.showMessageDialog(this, "👤\n️"
                                        +"👤\n️");
    }//GEN-LAST:event_INSTRUCCIONESActionPerformed

    
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
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CARGAR_JSON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CARGAR_JSON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CARGAR_JSON;
    private javax.swing.JButton CERRAR;
    private javax.swing.JLabel FONDO;
    private javax.swing.JLabel ICONO_JSON;
    private javax.swing.JButton INSTRUCCIONES;
    private javax.swing.JButton REGRESAR;
    private javax.swing.JLabel TITULO;
    // End of variables declaration//GEN-END:variables
}
