package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Stateless
public class GuitarDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public GuitarDao() {
    }

    public Optional<GuitarEntity> getGuitarById(long id){
        TypedQuery<GuitarEntity> query = em.createQuery("select g from GuitarEntity g where g.id = :id", GuitarEntity.class);
        query.setParameter("id", id);
        GuitarEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }

    public Optional<GuitarEntity> getGuitarByName(String name){
        TypedQuery<GuitarEntity> query = em.createQuery("select g from GuitarEntity g where g.name = :name", GuitarEntity.class);
        query.setParameter("name", name);
        GuitarEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }


    public List<GuitarEntity> getAll(){
        return em.createQuery("select g from GuitarEntity g", GuitarEntity.class).getResultList();
    }

    public GuitarEntity addGuitar(GuitarEntity guitar) {
        em.persist(guitar);
        return guitar;
    }

    public void remove(long id) {
        GuitarEntity dbGuitar = getGuitarById(id).get();
        em.remove(dbGuitar);
    }

    public GuitarEntity update(GuitarEntity guitarEntity) {
        /* tez dziala
        Optional<GuitarEntity> dbGuitar = getAll().stream().filter(ent -> ent.getId().equals(guitarEntity.getId())).findFirst();
        dbGuitar.ifPresent(fromDb -> fromDb.update(guitarEntity));
        return dbGuitar.get();
        */
        GuitarEntity dbGuitar = getGuitarById(guitarEntity.getId()).get();
        dbGuitar.update(guitarEntity);
        GuitarEntity ret = em.merge(dbGuitar);
        return ret;
    }
}
