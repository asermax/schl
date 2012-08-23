package core.schedule.ui;

import core.utils.Hour;
import javax.swing.AbstractSpinnerModel;

/**
 *
 * @author kiira
 */
public class SpinnerHourModel extends AbstractSpinnerModel {

    private Hour currentHour;
    
    public SpinnerHourModel( Hour initHour ) {
        currentHour = initHour;
    }
    
    @Override
    public Object getValue() {
        return this.currentHour;
    }

    @Override
    public void setValue( Object obj ) {
        Hour hour = null;
        
        if ( obj instanceof Hour )
            hour = (Hour)obj;
        else if ( obj instanceof String )
            hour = Hour.parseHour( (String)obj );
        
        this.currentHour = (Hour) hour;
    }

    @Override
    public Object getNextValue() {
        this.currentHour.addMins( 1 );
        
        if ( this.currentHour.getHours() == 24 )
            this.currentHour = new Hour();
        
        return new Hour( this.currentHour );
    }

    @Override
    public Object getPreviousValue() {
        this.currentHour.addMins( -1 );
        
        if ( this.currentHour.getHours() == 0 
                && this.currentHour.getMinutes() == 0 )
            this.currentHour = new Hour( 24 );
        
        return new Hour( this.currentHour );
    }
    
}
