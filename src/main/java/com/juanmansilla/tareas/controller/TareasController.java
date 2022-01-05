package com.juanmansilla.tareas.controller;

import com.juanmansilla.tareas.entity.Tarea;
import com.juanmansilla.tareas.services.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:3000")
@RequestMapping("tareas")
public class TareasController {

    @Autowired
    private ITareaService service;

    @GetMapping("tareas")
    public ResponseEntity<List<Tarea>> getBooks(){
        List<Tarea> books = service.getTareas();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("tarea/{id_tarea}")
    public ResponseEntity<Tarea> getBook(@PathVariable("id_tarea") Integer id){
        Tarea tarea = service.getTarea(id);
        return new ResponseEntity<>(tarea, HttpStatus.OK);
    }

    @PostMapping("tarea")
    public ResponseEntity<Tarea> createBook(@RequestBody Tarea tarea){
        Tarea new_tarea = service.createTarea(tarea);
        return new ResponseEntity<>(new_tarea, HttpStatus.OK);
    }

    @PutMapping("tarea/{id_tarea}")
    public ResponseEntity<Tarea> updateBook(@PathVariable("id_tarea") int id, @RequestBody Tarea tarea){
        Tarea update_tarea = service.updateTarea(id, tarea);
        return new ResponseEntity<>(update_tarea, HttpStatus.OK);
    }

}
