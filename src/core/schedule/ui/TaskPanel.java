package core.schedule.ui;

import core.schedule.task.Task;
import core.utils.Hour;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import sas.swing.MultiLineLabel;
import sas.swing.plaf.MultiLineShadowUI;

/**
 *
 * @author kiira
 */
public class TaskPanel extends javax.swing.JPanel {

    private static final Color DEFAULT_COLOR = new Color( 254, 79, 79 );
    private Color baseColor;
    private Task task;
    private ScheduleUI scheduleUI;

    /** Creates new form TaskPanel */
    public TaskPanel( ScheduleUI ui, Task task, int hoursSize,
                      int timeFraction, Color color, int direction ) {
        this.initCommon( ui, task, hoursSize, timeFraction, color, direction );

        //seteamos el popup
        this.setComponentPopupMenu( jPMRealTask );

        //seteamos la descripción de la task y cambiamos el color del mismo
        this.jLDescription.setText( task.getDescription() );

        //asignamos en el tooltip los horarios reales
        this.setToolTipText( String.format( "Desde las %s hasta las %s",
                                            task.getInitHour(),
                                            task.getEndHour() ) );
    }

    public TaskPanel( ScheduleUI ui, Task task, int hoursSize, int timeFraction,
                      Color color ) {
        this( ui, task, hoursSize, timeFraction, color,
              SwingConstants.VERTICAL );
    }

    public TaskPanel( ScheduleUI ui, Task task, int hoursSize, int timeFraction ) {
        this( ui, task, hoursSize, timeFraction, DEFAULT_COLOR );
    }

    public TaskPanel( ScheduleUI ui, Hour init, Hour end, int hoursSize,
                      int timeFraction, int direction ) {
        this.initCommon( ui, new Task( init, end, "" ), hoursSize, timeFraction,
                         null, direction );
                
        //setamos el popup
        this.setComponentPopupMenu( jPMDummyTask );
    }

    public TaskPanel( ScheduleUI ui, Hour init, Hour end, int hoursSize,
                      int timeFraction ) {
        this( ui, init, end, hoursSize, timeFraction, SwingConstants.VERTICAL );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMRealTask = new javax.swing.JPopupMenu();
        jMIEliminar = new javax.swing.JMenuItem();
        jPMDummyTask = new javax.swing.JPopupMenu();
        jMIAgregar = new javax.swing.JMenuItem();
        jLDescription = new sas.swing.MultiLineLabel();

        jPMRealTask.setName("jPMRealTask"); // NOI18N

        jMIEliminar.setText("Eliminar");
        jMIEliminar.setName("jMIEliminar"); // NOI18N
        jMIEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEliminarActionPerformed(evt);
            }
        });
        jPMRealTask.add(jMIEliminar);

        jPMDummyTask.setName("jPMDummyTask"); // NOI18N

        jMIAgregar.setText("jMenuItem1");
        jMIAgregar.setName("jMIAgregar"); // NOI18N
        jMIAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAgregarActionPerformed(evt);
            }
        });
        jPMDummyTask.add(jMIAgregar);

        setLayout(new java.awt.BorderLayout());

        jLDescription.setUI( MultiLineShadowUI.labelUI );
        jLDescription.setForeground(java.awt.Color.white);
        jLDescription.setHorizontalTextAlignment(MultiLineLabel.CENTER);
        jLDescription.setName("jLDescription"); // NOI18N
        jLDescription.setVerticalTextAlignment(MultiLineLabel.CENTER);
        add(jLDescription, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jMIEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEliminarActionPerformed
        if ( JOptionPane.showConfirmDialog( (JComponent)scheduleUI,
                "¿Desea eliminar la Task?",
                "Eliminar Task",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE )
                == JOptionPane.YES_OPTION )
            this.scheduleUI.removeTask( this.task );
}//GEN-LAST:event_jMIEliminarActionPerformed

    private void jMIAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarActionPerformed
        JFrame parent = (JFrame)SwingUtilities.getWindowAncestor( this );
        
        NewTaskDialog dialog = new NewTaskDialog( parent, 
                this.task.getInitHour(), this.task.getEndHour() );
        
        dialog.setLocationRelativeTo( parent );
        dialog.setVisible( true );
    }//GEN-LAST:event_jMIAgregarActionPerformed

    private void initCommon( ScheduleUI ui, Task task, int hoursSize,
                             int timeFraction, Color color, int direction ) {
        if ( direction != SwingConstants.HORIZONTAL
             && direction != SwingConstants.VERTICAL )
            throw new IllegalArgumentException(
                    "Solo se puede especificar HORIZONTAL o VERTICAL"
                    + " como dirección." );

        initComponents();
        this.scheduleUI = ui;
        this.task = task;
        this.baseColor = color;

        //calculamos el size
        int size = Math.round(
                (float)task.getDurationInMinutes() * hoursSize / timeFraction );

        //según la dirección, creamos un borde y una diimensión diferente
        Dimension dim;
        Border border;

        if ( direction == SwingConstants.HORIZONTAL ) {
            dim = new Dimension( size, this.getPreferredSize().height );
            border = BorderFactory.createMatteBorder( 0, 0, 0, 1, Color.black );
        } else {
            dim = new Dimension( this.getPreferredSize().width, size );
            border = BorderFactory.createMatteBorder( 0, 0, 1, 0, Color.black );
        }

        //seteamos la diimensión y el borde
        this.setPreferredSize( dim );
        this.setBorder( border );
    }

    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );

        //si no hay task, no ponemos ningún color
        if ( this.baseColor == null )
            return;

        //casteamos el graphics
        Graphics2D g2 = (Graphics2D)g.create();

        //generamos el gradiente y lo asignamos        
        Color firstColor = this.baseColor.brighter();
        Color secondColor = this.baseColor.darker();

        Paint gradient = new GradientPaint(
                new Point( 0, this.getHeight() * 1 / 4 ), firstColor,
                new Point( 0, this.getHeight() ), secondColor );

        g2.setPaint( gradient );

        //pintamos
        g2.fillRect( 0, 0, this.getWidth(), this.getHeight() );

        //dibujamos un borde del color base
        g2.setPaint( this.baseColor );

        g2.drawLine( 0, 0, 0, this.getHeight() );
        g2.drawLine( 0, 0, this.getWidth(), 0 );
        g2.drawLine( 0, this.getHeight() - 2, this.getWidth(),
                     this.getHeight() - 2 );
        g2.drawLine( this.getWidth() - 1, 0, this.getWidth() - 1,
                     this.getHeight() );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sas.swing.MultiLineLabel jLDescription;
    private javax.swing.JMenuItem jMIAgregar;
    private javax.swing.JMenuItem jMIEliminar;
    private javax.swing.JPopupMenu jPMDummyTask;
    private javax.swing.JPopupMenu jPMRealTask;
    // End of variables declaration//GEN-END:variables
}
