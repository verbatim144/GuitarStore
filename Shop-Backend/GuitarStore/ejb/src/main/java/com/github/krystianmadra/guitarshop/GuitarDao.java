package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
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

    public List<GuitarEntity> getAll(){
        return em.createQuery("select g from GuitarEntity g", GuitarEntity.class).getResultList();
    }

    public Optional<GuitarCategoryEntity> getGuitarCategoryByName(String name){
        TypedQuery<GuitarCategoryEntity> query = em.createQuery("select g from GuitarCategoryEntity g where g.name = :name", GuitarCategoryEntity.class);
        query.setParameter("name", name);
        GuitarCategoryEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }

    public Optional<GuitarEntity> getGuitarByName(String name){
        TypedQuery<GuitarEntity> query = em.createQuery("select g from GuitarEntity g where g.name = :name", GuitarEntity.class);
        query.setParameter("name", name);
        GuitarEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }

    public void remove(long id) {
        GuitarEntity dbGuitar = getGuitarById(id).get();
        em.remove(dbGuitar);
    }

    public GuitarEntity update(GuitarEntity guitarEntity) {
        GuitarEntity dbGuitar = getGuitarById(guitarEntity.getId()).get();
        dbGuitar.update(guitarEntity);
        return em.merge(dbGuitar);
    }

    public Optional<GuitarEntity> getGuitarById(long id){
        return Optional.of(em.find(GuitarEntity.class, id));
    }

    public GuitarEntity addGuitar(GuitarEntity guitar) {
        GuitarCategoryEntity dbGC = getGuitarCategoryByName(guitar.getCategory().getName()).get();
        guitar.setCategory(dbGC);
        em.persist(guitar);

        return guitar;
    }
}
