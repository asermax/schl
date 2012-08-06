package core.utils;

/**
 * La clase {@code Hour} representa un momento del día, especificado a partir
 * de la hora del día y la cantidad de minutos.
 * @author kiira
 * @version 1.0
 */
public final class Hour implements Comparable<Hour> {

    /** Cantidad de horas en un día. */
    public static final int HOURS = 24;
    /** Cantidad de minutos en una hora. */
    public static final int MINS = 60;
    /** Hora definida para este horario. */
    private int hours;
    /** Cantidad de minutos pasada la hora, definido para este horario. */
    private int minutes;

    /**
     * Inicializa el horario a las 00:00
     */
    public Hour() {
    }

    /**
     * Inicializa el horario a la hora indicada, sin sumar minutos.
     * @param hour hora del horario.
     */
    public Hour( int hour ) {
        this.setHours( hour );
    }

    /**
     * Inicializa el horario indicando hora y cantida de minutos pasada la hora.
     * @param hour hora del horario.
     * @param minutes cantidad de minutos pasado de la hora.
     */
    public Hour( int hour, int minutes ) {
        this.setHours( hour );
        this.setMinutes( minutes );
    }

    /**
     * Devuelve la hora de este horario.
     * @return hora del horario.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Permite asignar la hora de este horario.
     * @param hour hora a asignar.
     * @throws IllegalArgumentException si el horario esta fuera del rango 
     * válido de horas (entre 0 y 23).
     */
    public void setHours( int hour ) {
        if ( hour < 0 || hour >= Hour.HOURS )
            throw new IllegalArgumentException(
                    "La hora debe ser un valor entre 0 y 23." );

        this.hours = hour;
    }

    /**
     * Devuelve la cantidad de minutos pasado de la hora del horario.
     * @return cantidad de minutos pasados de la hora.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Permite asignar la cantidad de minutos pasados de la hora del horaio.
     * @param minutes cantidad de minutos a asignar.
     */
    public void setMinutes( int minutes ) {
        if ( minutes < 0 || minutes >= Hour.MINS )
            throw new IllegalArgumentException(
                    "Los minutos deben ser un valor entre 0 y 59." );

        this.minutes = minutes;
    }

    /**
     * Devuelve el horario en cantidad de minutos desde las 00:00
     * @return cantidad de minutos desde las 00:00
     */
    public int getHourInMinutes() {
        return this.hours * 60 + this.minutes;
    }

    /**
     * Suma una cantidad de minutos al horario.
     * @param minutes cantidad de minutos a agregar.
     */
    public void addMins( int minutes ) {
        this.minutes += minutes;

        while ( this.minutes >= Hour.MINS ) {
            this.addHours( 1 );
            this.minutes -= Hour.MINS;
        }
    }

    /**
     * Suma una cantidad de horas al horario.
     * @param hours cantidad de horas a agregar.
     */
    public void addHours( int hours ) {
        this.hours += hours;

        while ( this.hours >= Hour.HOURS )
            this.hours -= Hour.HOURS;
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public int compareTo( Hour hour ) {
        int res = this.hours - hour.hours;

        if ( res == 0 )
            res = this.minutes - hour.minutes;

        return res;
    }

    /**
     * Devuelve la representeación de este horario en el formato HH:MM.
     * @return representación en forma de {@code String} de este horario.
     */
    @Override
    public String toString() {
        return String.format( "%02d:%02d", this.hours, this.minutes );
    }

}
