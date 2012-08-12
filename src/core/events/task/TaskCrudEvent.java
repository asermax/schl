package core.events.task;

import core.schedule.task.Task;

/**
 * La clase {@code TaskCrudEvent}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public abstract class TaskCrudEvent extends TaskEvent {

    public TaskCrudEvent( Task origin, String description ) {
        super( origin, description );
    }

    public TaskCrudEvent( Task origin ) {
        super( origin );
    }

}//end clase TaskCrudEvent
