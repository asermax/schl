/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.schedule;

import core.task.Task;
import core.utils.Hour;
import java.util.TreeSet;

/**
 *
 * @author a1
 */
public class DailySchedule {

    private TreeSet<Task> tasks;

    public DailySchedule() {
        this.tasks = new TreeSet<Task>();
    }

    public boolean createTask( Hour init, Hour end, String desc ) {
        Task newTask = new Task( init, end, desc );

        return this.addTask( newTask );
    }

    public boolean addTask( Task task ) {
        boolean res = this.isTimeAvailable( task.getInitHour(),
                                            task.getEndHour() );
        if ( res )
            this.tasks.add( task );

        return res;
    }

    private boolean isTimeAvailable( Hour initTime, Hour endTime ) {
        return !this.existTaskAtTime( initTime )
               && !this.existTaskAtTime( endTime );
    }

    public Task taskAtTime( Hour hour ) {
        Task finded = null;

        for ( Task t : this.tasks )
            if ( t.isInTime( hour ) ) {
                finded = t;
                break;
            } else if ( t.isAfter( hour ) )
                break;

        return finded;
    }

    public boolean existTaskAtTime( Hour time ) {
        return this.taskAtTime( time ) != null;
    }

    @Override
    public String toString() {
        return "DailySchedule{" + "tasks=" + tasks + '}';
    }

}
