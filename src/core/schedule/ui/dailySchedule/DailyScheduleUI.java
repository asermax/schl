package core.schedule.ui.dailySchedule;

import core.schedule.DailySchedule;
import core.schedule.ui.TaskPanel;
import core.task.Task;
import core.utils.Hour;
import java.util.Iterator;

/**
 *
 * @author kiira
 */
public class DailyScheduleUI extends javax.swing.JPanel {

    private int hoursHeight;
    private int timeFraction;
    private DailySchedule schedule;

    /** Creates new form DailyScheduleUI */
    public DailyScheduleUI( DailySchedule schedule ) {
        this.schedule = schedule;
        this.hoursHeight = 100;
        this.timeFraction = 60;
        initComponents();

        //generamos los task panels
        initTasksPanel();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPMain = new javax.swing.JScrollPane();
        jPMain = new javax.swing.JPanel();
        jPTasks = new javax.swing.JPanel();
        hSLateral = new core.schedule.ui.HoursStrip( this.hoursHeight, this.timeFraction );

        setLayout(new java.awt.BorderLayout());

        jSPMain.setName("jSPMain"); // NOI18N

        jPMain.setName("jPMain"); // NOI18N
        jPMain.setLayout(new java.awt.BorderLayout());

        jPTasks.setName("jPTasks"); // NOI18N
        jPTasks.setLayout(new javax.swing.BoxLayout(jPTasks, javax.swing.BoxLayout.Y_AXIS));
        jPMain.add(jPTasks, java.awt.BorderLayout.CENTER);

        hSLateral.setName("hSLateral"); // NOI18N
        jPMain.add(hSLateral, java.awt.BorderLayout.WEST);

        jSPMain.setViewportView(jPMain);

        add(jSPMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void initTasksPanel() {
        Iterator<Task> iter = schedule.iterator();
        Task current;
        int diff, last = 0;

        while ( iter.hasNext() ) {
            //obtenemos la siguiente task
            current = iter.next();

            //creamos un task panel vacio por cada fracción de tiempo en el
            //espacio restante
            diff = current.getInitHour().getHourInMinutes() - last;

            this.fillSpace( diff, last );

            //creamos el panel para la task actual
            this.jPTasks.add( new TaskPanel(
                    current,
                    this.hoursHeight, this.timeFraction,
                    new java.awt.Color( new java.util.Random().
                    nextInt() ) ) );

            //seteamos last para la próxima ronda
            last = current.
                    getEndHour().getHourInMinutes();

        }

        //agregamos tasks panels para rellenar el resto de lugar
        diff = Hour.HOURS * Hour.MINS - last;

        this.fillSpace( diff, last );
    }

    private void fillSpace( int diff, int last ) {
        int height, irregular;

        //primero quitamos cualquier porción irregular al comienzo del espacio
        irregular = this.timeFraction - last % this.timeFraction;
        
        if ( irregular > 0 && irregular < diff ) {
            height = this.calculateHeight( irregular );

            diff -= irregular;

            this.jPTasks.add( new TaskPanel( height ) );
        }

        //continuamos agregando intervalos regulares para completar el espacio
        while ( diff > 0 ) {
            if ( diff > this.timeFraction )
                height = this.hoursHeight;
            else
                height = this.calculateHeight( diff );

            diff -= this.timeFraction;

            this.jPTasks.add( new TaskPanel( height ) );
        }
    }

    private int calculateHeight( int time ) {
        return Math.round( (float)time * this.hoursHeight / this.timeFraction );
    }

    public static void main( String[] args ) {
        javax.swing.JFrame frame = new javax.swing.JFrame();

        DailySchedule instance = new DailySchedule();

        instance.createTask( new Hour( 15 ), new Hour( 16 ), "Prueba1" );
        instance.createTask( new Hour( 15, 30 ), new Hour( 17 ), "Prueba2" );
        instance.createTask( new Hour( 16 ), new Hour( 17 ), "Prueba3" );
        instance.createTask( new Hour( 11 ), new Hour( 15 ), "Prueba4" );
        instance.createTask( new Hour( 17, 25 ), new Hour( 18, 3 ),
                             "Intervalo irregular" );
        instance.createTask( new Hour( 18, 11 ), new Hour( 19, 5 ),
                             "Intervalo irregular" );
        instance.createTask( new Hour( 21, 10 ), new Hour( 22, 7 ),
                             "Intervalo irregular" );

        frame.setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );
        frame.setSize( 800, 600 );
        frame.add( new DailyScheduleUI( instance ) );

        frame.setVisible( true );
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private core.schedule.ui.HoursStrip hSLateral;
    private javax.swing.JPanel jPMain;
    private javax.swing.JPanel jPTasks;
    private javax.swing.JScrollPane jSPMain;
    // End of variables declaration//GEN-END:variables
}
