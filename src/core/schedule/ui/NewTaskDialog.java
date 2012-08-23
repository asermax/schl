/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewTaskDialog.java
 *
 * Created on 22-ago-2012, 20:58:04
 */
package core.schedule.ui;

import core.schedule.task.Task;
import core.utils.Hour;
import javax.swing.JFrame;

/**
 *
 * @author a1
 */
public class NewTaskDialog extends javax.swing.JDialog {
    /** Creates new form NewTaskDialog */
    public NewTaskDialog( JFrame parent, Hour init, Hour end ) {
        super( parent, true );
        initComponents();
        
        //set the spinners models
        this.jSpinner1.setModel( new SpinnerHourModel( init ) );
        this.jSpinner2.setModel( new SpinnerHourModel( end ) );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jBClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        jPMain.setName("jPMain"); // NOI18N
        jPMain.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("jLabel1");
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPMain.add(jLabel1, gridBagConstraints);

        jTextField1.setText("jTextField1");
        jTextField1.setName("jTextField1"); // NOI18N
        jPMain.add(jTextField1, new java.awt.GridBagConstraints());

        jLabel2.setText("jLabel2");
        jLabel2.setName("jLabel2"); // NOI18N
        jPMain.add(jLabel2, new java.awt.GridBagConstraints());

        jLabel3.setText("jLabel3");
        jLabel3.setName("jLabel3"); // NOI18N
        jPMain.add(jLabel3, new java.awt.GridBagConstraints());

        jSpinner1.setName("jSpinner1"); // NOI18N
        jPMain.add(jSpinner1, new java.awt.GridBagConstraints());

        jSpinner2.setName("jSpinner2"); // NOI18N
        jPMain.add(jSpinner2, new java.awt.GridBagConstraints());

        jBClose.setText("Close");
        jBClose.setName("jBClose"); // NOI18N
        jBClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCloseActionPerformed(evt);
            }
        });
        jPMain.add(jBClose, new java.awt.GridBagConstraints());

        getContentPane().add(jPMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCloseActionPerformed

    public Task getNewTask() {
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPMain;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
