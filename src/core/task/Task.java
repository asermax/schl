package core.task;

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
        this.initHour = initHour;
        this.endHour = endHour;
        this.description = description;
    }

    /**
     * Devuelve el horario de inicio de la tarea.
     * @return horario de inicio de la tarea.
     */
    public Hour getInitHour() {
        return initHour;
    }

    /**
     * Devuelve el horario de fin de la tarea.
     * @return horario de fin de la tarea.
     */
    public Hour getEndHour() {
        return endHour;
    }

    /**
     * Devuelve la descripción de la tarea.
     * @return descripción de la tarea.
     */
    public String getDescription() {
        return description;
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
    public boolean isInTime( Hour hour ) {
        return this.initHour.compareTo( hour ) < 0
               && this.endHour.compareTo( hour ) > 0;
    }

    /**
     * Inidica si elhorario indicado por parámetro esta dispuesto "luego" de
     * finalizada la tarea.
     * @param hour horario el cual se desea saber si esta dispuesto "luego" de 
     * finalizada la tarea.
     * @return {@code true} si el horario esta dispuesto luego de finalizada
     * la tarea.;
     * {@code false} en caso contrario.
     */
    public boolean isAfter( Hour hour ) {
        return this.endHour.compareTo( hour ) <= 0;
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
