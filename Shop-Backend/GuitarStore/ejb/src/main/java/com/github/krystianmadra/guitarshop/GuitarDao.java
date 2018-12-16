package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Stateless
public class GuitarDao {

    private final Set<GuitarEntity> guitars = new HashSet<>();

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public GuitarDao() {
    }

    public Optional<GuitarEntity> getGuitarById(long id){
        TypedQuery<GuitarEntity> query = em.createQuery("select new GuitarEntity(g.id) from GuitarEntity g where g.id = :id", GuitarEntity.class);
        query.setParameter("id", id);

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
        guitars.remove(new GuitarEntity(id));
    }

    public GuitarEntity update(GuitarEntity guitarEntity) {
        GuitarEntity dbGuitar = getGuitarById(guitarEntity.getId()).get();
        dbGuitar.update(guitarEntity);
        GuitarEntity ret = em.merge(guitarEntity);
        return ret;
    }

}
