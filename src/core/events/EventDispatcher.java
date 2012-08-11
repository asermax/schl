package core.events;

import core.events.task.TaskEvent;
import core.events.task.TaskEventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * La clase {@code EventDispatcher}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public class EventDispatcher {

    private static final EventDispatcher singleton = new EventDispatcher();
    private Map<Class<? extends TaskEvent>, Set<TaskEventListener>> registeredTaskListeners;

    public static EventDispatcher getInstance() {
        return singleton;
    }

    private EventDispatcher() {
        this.registeredTaskListeners = new HashMap<Class<? extends TaskEvent>, Set<TaskEventListener>>();
    }

    public void registerTaskEventListener( Class<? extends TaskEvent> eventType,
                                           TaskEventListener listener ) {
        if ( !this.registeredTaskListeners.containsKey( eventType ) )
            this.registeredTaskListeners.
                    put( eventType,
                         new HashSet<TaskEventListener>() );

        this.registeredTaskListeners.get( eventType ).add( listener );
    }

    public void fireTaskEvent( TaskEvent event ) {
        Set<TaskEventListener> listeners = this.registeredTaskListeners.get(
                event.getClass() );

        if ( listeners != null )
            for ( TaskEventListener listener : listeners )
                listener.taskEventPerformed( event );
    }

}
