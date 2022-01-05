package com.juanmansilla.tareas.dao;

import com.juanmansilla.tareas.entity.Tarea;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class TareaDAO implements ITareaDAO {

    @PersistenceContext
    public EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Tarea> getTareas() {
        String listado = "FROM Tarea as ta ORDER BY ta.idTarea";
        return (List<Tarea>) em.createQuery(listado).getResultList();
    }

    @Override
    public Tarea getTarea(int id_tarea) {
        return em.find(Tarea.class, id_tarea);
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        tarea.setFechaCreacion(new Date());
        em.persist(tarea);
        Tarea last = getLastInsertedTarea();
        return last;
    }

    @Override
    public Tarea updateTarea(int id_tarea, Tarea tarea) {
        Tarea tarea_db = getTarea(id_tarea);
        tarea_db.setDescripcion(tarea.getDescripcion());
        tarea_db.setVigente(tarea.getVigente());
        tarea_db.setFechaCreacion(tarea_db.getFechaCreacion());
        em.flush();

        Tarea update_tarea = getTarea(id_tarea);
        return update_tarea;
    }

    private Tarea getLastInsertedTarea(){
        String last = "from Tarea as ta order by ta.idTarea DESC";
        Query query = em.createQuery(last);
        query.setMaxResults(1);
        Tarea tarea = (Tarea)query.getSingleResult();
        return tarea;
    }

}
