package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Singleton
@Startup
public class InitializeDatabaseBean {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @PostConstruct
    public void init(){
        GuitarCategoryEntity electric = new GuitarCategoryEntity();
        electric.setName("Electric");

        GuitarEntity sampleGuitar = new GuitarEntity();
        sampleGuitar.setName("Ibanez I-700");
        sampleGuitar.setPrice(new BigDecimal(1200L));

        em.persist(electric);
        em.persist(sampleGuitar);
    }
}
