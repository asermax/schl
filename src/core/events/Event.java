package core.events;

import java.util.Date;

/**
 * La clase {@code Event}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public abstract class Event {

    private Date timestamp;
    private String description;

    public Event() {
        this( "" );
    }

    public Event( String description ) {
        this.description = description;
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

}//end clase Event
