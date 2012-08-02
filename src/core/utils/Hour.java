package core.utils;
/**
 *
 * @author a1
 */
public final class Hour implements Comparable<Hour> {

    private static final int HOURS = 24;
    private static final int MINS = 60;
    private int hour;
    private int minutes;

    public Hour() {
    }

    public Hour( int hour ) {
        this.setHour( hour );
    }

    public Hour( int hour, int minutes ) {
        this.setHour( hour );
        this.setMinutes( minutes );
    }

    public int getHour() {
        return hour;
    }

    public void setHour( int hour ) {
        if ( hour < 0 || hour >= Hour.HOURS )
            throw new IllegalArgumentException( 
                    "La hora debe ser un valor entre 0 y 23." );
        
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes( int minutes ) {
        if ( minutes < 0 || minutes >= Hour.MINS )
            throw new IllegalArgumentException( 
                    "Los minutos deben ser un valor entre 0 y 59." );
        
        this.minutes = minutes;
    }

    @Override
    public int compareTo( Hour hour ) {
        int res = this.hour - hour.hour;
        
        if ( res == 0 )
            res = this.minutes - hour.minutes;
        
        return res;
    }

    @Override
    public String toString() {
        return "Hour{" + "hour=" + hour + ", minutes=" + minutes + '}';
    }

}
