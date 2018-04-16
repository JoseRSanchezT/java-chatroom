/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sistema30
 */
public class Main extends javax.swing.JFrame {
    private ServerSocket ss;
    private Socket s;
    private int chatcount=0;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    
    private class runServer extends Thread{
        @Override
        public void run(){
            try {
                ss=new ServerSocket(1206);
                s=ss.accept();
            } catch (IOException ex) {
                System.out.println("Esta esperando, no puede abrirse");
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            ChatDlg ser_chat=new ChatDlg(new Main(), false);
            
            ser_chat.setServerport(ss.getLocalPort());
            ser_chat.setS(s);
            ser_chat.setIsServer(true);
            ser_chat.setId(++chatcount);
            ser_chat.setVisible(true);
            newchatbtn.setEnabled(false);
            while(true){
                if(!ser_chat.isVisible()){
                   newchatbtn.setEnabled(true); 
                }
            }
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

        jToolBar1 = new javax.swing.JToolBar();
        newchatbtn = new javax.swing.JButton();
        newclientbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        newchatbtn.setText("Nuevo Servidor");
        newchatbtn.setFocusable(false);
        newchatbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newchatbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newchatbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newchatbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(newchatbtn);

        newclientbtn.setText("Nuevo chat");
        newclientbtn.setFocusable(false);
        newclientbtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newclientbtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newclientbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newclientbtnActionPerformed(evt);
            }
        });
        jToolBar1.add(newclientbtn);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(766, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newchatbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newchatbtnActionPerformed
        runServer ser=new runServer();
        ser.start();
        if(ser.getState()==Thread.State.WAITING){
            System.out.println(":v");
        }
    }//GEN-LAST:event_newchatbtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void newclientbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newclientbtnActionPerformed
        ChatDlg dlg=new ChatDlg(this, false);
        dlg.setIsServer(false);
        dlg.setId(++chatcount);
        dlg.setVisible(true);
    }//GEN-LAST:event_newclientbtnActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton newchatbtn;
    private javax.swing.JButton newclientbtn;
    // End of variables declaration//GEN-END:variables
}
