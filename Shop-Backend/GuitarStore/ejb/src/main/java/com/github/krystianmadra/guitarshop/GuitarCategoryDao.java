package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Stateless
public class GuitarCategoryDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public GuitarCategoryDao() {
    }

    public Optional<GuitarCategoryEntity> getGuitarCategoryByName(String name){
        TypedQuery<GuitarCategoryEntity> query = em.createQuery("select new GuitarCategoryEntity(g.id) from GuitarCategoryEntity g where g.name = :name", GuitarCategoryEntity.class);
        query.setParameter("name", name);

        GuitarCategoryEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }
/*
    public Optional<GuitarCategoryEntity> getGuitarCategoryById(long id){
        TypedQuery<GuitarCategoryEntity> query = em.createQuery("select new GuitarCategoryEntity(g.id) from GuitarCategoryEntity g where g.id = :id", GuitarCategoryEntity.class);
        query.setParameter("id", id);

        GuitarCategoryEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }
    */
}
