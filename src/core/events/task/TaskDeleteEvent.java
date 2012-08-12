package core.events.task;

import core.schedule.task.Task;

/**
 * La clase {@code TaskDeleteEvent}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public class TaskDeleteEvent extends TaskCrudEvent {

    public TaskDeleteEvent( Task origin, String description ) {
        super( origin, description );
    }

    public TaskDeleteEvent( Task origin ) {
        super( origin );
    }

}
