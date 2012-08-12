/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.schedule;

import core.schedule.task.Task;
import core.utils.Hour;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kiira
 */
public class DailyScheduleTest {

    public DailyScheduleTest() {
    }

    /**
     * Test of createTask method, of class DailySchedule.
     */
    @Test
    public void testCreateTask() {
        System.out.println( "createTask" );

        DailySchedule instance = new DailySchedule();

        assert ( instance.
                createTask( new Hour( 15 ), new Hour( 16 ), "Prueba1" ) );
        assert ( !instance.
                createTask( new Hour( 15, 30 ), new Hour( 17 ), "Prueba2" ) );
        assert ( instance.
                createTask( new Hour( 16 ), new Hour( 17 ), "Prueba3" ) );
        assert ( instance.
                createTask( new Hour( 11 ), new Hour( 15 ), "Prueba4" ) );
        assert ( !instance.
                createTask( new Hour( 10 ), new Hour( 15, 15 ), "Prueba5" ) );

    }

    /**
     * Test of addTask method, of class DailySchedule.
     */
    @Test
    public void testAddTask() {
        System.out.println( "addTask" );
        DailySchedule instance = new DailySchedule();

        assert ( instance.
                addTask( new Task( new Hour( 15 ), new Hour( 16 ), "Prueba1" ) ) );
        assert ( !instance.
                addTask(
                new Task( new Hour( 15, 30 ), new Hour( 17 ), "Prueba2" ) ) );
        assert ( instance.
                addTask( new Task( new Hour( 16 ), new Hour( 17 ), "Prueba3" ) ) );
        assert ( instance.
                addTask( new Task( new Hour( 11 ), new Hour( 15 ), "Prueba4" ) ) );
    }

    /**
     * Test of taskAtTime method, of class DailySchedule.
     */
    @Test
    public void testTaskAtTime() {
        System.out.println( "taskAtTime" );
        Hour hour = new Hour( 15 );
        Task task = new Task( new Hour( 14 ), new Hour( 15, 30 ), "Prueba" );
        DailySchedule instance = new DailySchedule();
        Task expResult = task;
        instance.addTask( task );
        Task result = instance.taskAtTime( hour );
        assertEquals( expResult, result );
    }

    @Test
    public void testToString() {
        System.out.println( "toString" );

        DailySchedule instance = new DailySchedule();
        instance.createTask( new Hour( 15 ), new Hour( 16 ), "Prueba1" );
        instance.createTask( new Hour( 15, 30 ), new Hour( 17 ), "Prueba2" );
        instance.createTask( new Hour( 16 ), new Hour( 17 ), "Prueba3" );
        instance.createTask( new Hour( 11 ), new Hour( 15 ), "Prueba4" );

        System.out.println( instance );

    }

}
