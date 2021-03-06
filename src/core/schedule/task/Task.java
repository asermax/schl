package core.schedule.task;

import core.events.EventDispatcher;
import core.events.task.TaskDeleteEvent;
import core.utils.Hour;

/**
 * La clase {@code Task} representa una tarea a realizar en un momento 
 * determinado del día.
 * @author kiira
 * @version 1.0
 */
public class Task implements Comparable<Task> {

    /** Horario de inicio de la tarea. */
    private Hour initHour;
    /** Horario de fin de la tarea. */
    private Hour endHour;
    /** Descripción de la tarea. */
    private String description;

    /**
     * Inicializa la tarea de manera completa, indicando sus horarios de inicio
     * y fin, y su descripción.
     * @param initHour horario de inicio de la tarea.
     * @param endHour horario de fin de la tarea.
     * @param description descripción de la tarea.
     */
    public Task( Hour initHour, Hour endHour, String description ) {
        if ( initHour.isAfter( endHour ) )
            throw new IllegalArgumentException(
                    "La hora inicial debe ser menor de la hora final." );
        
        this.initHour = new Hour( initHour );
        this.endHour = new Hour( endHour );
        this.description = description;
    }

    /**
     * Devuelve el horario de inicio de la tarea.
     * @return horario de inicio de la tarea.
     */
    public Hour getInitHour() {
        return new Hour( initHour );
    }

    /**
     * Devuelve el horario de fin de la tarea.
     * @return horario de fin de la tarea.
     */
    public Hour getEndHour() {
        return new Hour( endHour );
    }

    /**
     * Devuelve la descripción de la tarea.
     * @return descripción de la tarea.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Devuelve la duración de esta tarea en cantidad de minutos.
     * @return duración de la tarea en minutos.
     */
    public int getDurationInMinutes() {
        return this.endHour.toMinutes() - this.initHour.toMinutes();
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public int compareTo( Task task ) {
        return this.initHour.compareTo( task.initHour );
    }

    /**
     * Inidica si el tiempo durante el cual transcurrirá esta tarea comprende
     * el horario indicado.
     * @param hour horario el cual se desea saber si está comprendido en el 
     * periodo durante el cual transcurrirá la tarea.
     * @return {@code true} si el horario se encuentra comprendido dentro del
     * periodo durante el cual transcurrirá la tarea.;
     * {@code false} en caso contrario.
     */
    public boolean isTranscurringAt( Hour hour ) {
        return this.initHour.compareTo( hour ) < 0
               && this.endHour.compareTo( hour ) > 0;
    }

    /**
     * Inidica si el horario indicado por parámetro esta dispuesto "luego" de
     * finalizada la tarea.
     * @param hour horario el cual se desea saber si esta dispuesto "luego" de 
     * finalizada la tarea.
     * @return {@code true} si el horario esta dispuesto "luego" de finalizada
     * la tarea.;
     * {@code false} en caso contrario.
     */
    public boolean isBefore( Hour hour ) {
        return this.endHour.isBefore( hour );
    }

    /**
     * Inidica si elhorario indicado por parámetro esta dispuesto "antes" de
     * iniciada la tarea.
     * @param hour horario el cual se desea saber si esta dispuesto "antes" de 
     * iniciada la tarea.
     * @return {@code true} si el horario esta dispuesto "antes" de iniciada
     * la tarea.;
     * {@code false} en caso contrario.
     */
    public boolean isAfter( Hour hour ) {
        return this.initHour.isAfter( hour );
    }

    public void delete() {
        EventDispatcher.getInstance().fireTaskEvent(
                new TaskDeleteEvent( this, "Eliminando Task" ) );
    }

    /**
     * Devuelve la representación de esta tarea en forma de {@code String}, 
     * mostrando su descripción, hora de inicio y de fin.
     * @return representación en forma de {@code String} de esta tarea.
     */
    @Override
    public String toString() {
        return String.format( "Tarea: %s; Inicio: %s; Fin: %s",
                              this.description, this.initHour,
                              this.endHour );
    }

}
