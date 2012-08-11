package core.events.task;

import java.util.EventListener;

/**
 * La interfaz {@code TaskEventListener}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public interface TaskEventListener extends EventListener {

    void taskEventPerformed( TaskEvent event );

}
