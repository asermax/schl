package core.schedule.ui;

import core.schedule.task.Task;

/**
 * La interfaz {@code ScheduleUI}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public interface ScheduleUI {

    public void removeTask( Task task );
    public void addTask( Task task );

}
