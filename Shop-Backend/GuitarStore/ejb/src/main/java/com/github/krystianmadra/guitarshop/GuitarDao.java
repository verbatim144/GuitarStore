package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Stateless
public class GuitarDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public GuitarDao() {
    }

    public List<GuitarEntity> findAll(){
        return em.createQuery("select g from GuitarEntity g", GuitarEntity.class).getResultList();
    }

    public Optional<GuitarEntity> findByName(String name){
        try{
            TypedQuery<GuitarEntity> query = em
                    .createQuery("select g from GuitarEntity g where g.name = :name", GuitarEntity.class);
            query.setParameter("name", name);
            GuitarEntity ret = query.getSingleResult();

            return Optional.of(ret);
        } catch(NoResultException e) {
            return Optional.empty();
        }
    }

    public void remove(long id) {
        Optional<GuitarEntity> ret = findById(id);
        ret.ifPresent(guitarEntity -> em.remove(guitarEntity));
    }

    public Optional<GuitarEntity> update(GuitarEntity guitarEntity) {
        Optional<GuitarEntity> ret = findById(guitarEntity.getId());
        if(ret.isPresent()){
            GuitarEntity updated = ret.get(); // being edited, english..

            updated.update(guitarEntity);
            em.merge(updated);

            return Optional.of(updated);
        }
        return Optional.empty();
    }

    public Optional<GuitarEntity> findById(long id){
        if (em.find(GuitarEntity.class, id) == null){
            return Optional.empty();
        }
        else return Optional.of(em.find(GuitarEntity.class, id));
    }

    public Optional<GuitarEntity> add(GuitarEntity guitar) {
        List<GuitarEntity> guitars = findAll();
        if(guitars.contains(guitar)){
            return Optional.empty();
        }
        GuitarCategoryEntity category = guitars.stream()
                .filter(g -> g.getCategory().getName().equals(guitar.getCategory().getName()))
                .findFirst().get().getCategory();
        guitar.setCategory(category);
        em.persist(guitar);

        return Optional.of(guitar);
    }
}