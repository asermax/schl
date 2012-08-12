package core.events.task;

import core.events.Event;
import core.schedule.task.Task;

/**
 * La clase {@code TaskEvent}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public abstract class TaskEvent extends Event {

    private Task origin;

    public TaskEvent( Task origin, String description ) {
        super( description );
        this.origin = origin;
    }

    public TaskEvent( Task origin ) {
        this.origin = origin;
    }

    public Task getOrigin() {
        return origin;
    }

}//end clase TaskEvent
