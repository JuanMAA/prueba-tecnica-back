package com.juanmansilla.tareas.services;


import com.juanmansilla.tareas.dao.*;
import com.juanmansilla.tareas.entity.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private ITareaDAO dao;

    @Override
    public List<Tarea> getTareas() {
        return dao.getTareas();
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        return dao.createTarea(tarea);
    }

    @Override
    public Tarea updateTarea(int id_tarea, Tarea tarea) {
        return dao.updateTarea(id_tarea, tarea);
    }

    @Override
    public Tarea getTarea(int id_tarea) {
        return dao.getTarea(id_tarea);
    }

}
