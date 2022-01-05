package com.juanmansilla.tareas.services;

import com.juanmansilla.tareas.entity.Tarea;

import java.util.List;

public interface ITareaService {

    List<Tarea> getTareas();

    Tarea createTarea(Tarea tarea);

    Tarea updateTarea(int id_tarea, Tarea tarea);

    Tarea getTarea(int id_tarea);

}
