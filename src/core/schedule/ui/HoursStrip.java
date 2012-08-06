/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.schedule.ui;

import core.utils.Hour;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author kiira
 */
public class HoursStrip extends javax.swing.JPanel {

    /** Creates new form HoursStrip */
    public HoursStrip( int hoursHeight, int timeFraction ) {
        initComponents();

        //creamos los labels
        int repetitions = Hour.HOURS * Hour.MINS / timeFraction;
        Hour h = new Hour();
        JLabel label;
        Dimension dim;

        for ( int i = 0; i < repetitions; i++ ) {
            //agregamos el label
            label = new JLabel( h.toString() );
            label.setVerticalAlignment( JLabel.CENTER );
            
            dim = new Dimension( label.getPreferredSize().width, hoursHeight);
            label.setMaximumSize( dim );
            label.setPreferredSize( dim );

            this.jPMain.add( label );

            h.addMins( timeFraction );
        }

    }

    public HoursStrip( int hoursHeight ) {
        this( hoursHeight, 60 );
    }

    public HoursStrip() {
        this( 150 );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMain = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPMain.setName("jPMain"); // NOI18N
        jPMain.setLayout(new javax.swing.BoxLayout(jPMain, javax.swing.BoxLayout.Y_AXIS));
        add(jPMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPMain;
    // End of variables declaration//GEN-END:variables
}
