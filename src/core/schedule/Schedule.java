package core.schedule;

import core.task.Task;

/**
 * La interfaz {@code Schedule}
 * @author kiira
 * @version 1.0, Aug 10, 2012
 */
public abstract class Schedule implements Iterable<Task> {

    /**
     * Permite agregar una tarea al schedule.
     * @param task tarea a agregar.
     * @return {@code true} si la tarea se pudo asignar correctamente (si el 
     * período indicado por la tarea no esta ocupado); 
     * {@code false} si la tarea no se pudo asignar correctamente.
     */
    public abstract boolean addTask( Task task );

    /**
     * Permite eliminar una tarea del schedule.
     * @param task tarea a eliminar.
     * @return {@code true} si la tarea se pudo eliminar correctamente (si el 
     * la tarea existe en el schedule); 
     * {@code false} si la tarea no se eliminó correctamente.
     */
    public abstract boolean removeTask( Task task );

}
