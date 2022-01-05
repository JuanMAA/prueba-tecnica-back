package com.juanmansilla.tareas.dao;

import com.juanmansilla.tareas.entity.Tarea;

import java.util.List;

public interface ITareaDAO {

    List<Tarea> getTareas();

    Tarea getTarea(int id_tarea);

    Tarea createTarea(Tarea tarea);

    Tarea updateTarea(int id_tarea, Tarea tarea);

}
