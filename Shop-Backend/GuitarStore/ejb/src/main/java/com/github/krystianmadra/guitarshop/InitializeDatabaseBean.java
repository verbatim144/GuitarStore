package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.OpinionEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class InitializeDatabaseBean {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @PostConstruct
    public void init(){
        GuitarCategoryEntity electric = new GuitarCategoryEntity("Electric");
        GuitarCategoryEntity classic = new GuitarCategoryEntity("Classic");
        GuitarCategoryEntity acoustic = new GuitarCategoryEntity("Acoustic");
        GuitarCategoryEntity bass = new GuitarCategoryEntity("Bass");

        GuitarEntity sampleGuitar1 = new GuitarEntity("ElectricS", 1200L, 2,"Lorem Ipsum", electric);
        GuitarEntity sampleGuitar2 = new GuitarEntity("ClassicS", 1200L, 2,"Lorem Ipsum",classic);
        GuitarEntity sampleGuitar3 = new GuitarEntity("AcousticS", 1200L, 2,"Lorem Ipsum",acoustic);
        GuitarEntity sampleGuitar4 = new GuitarEntity("BassS", 1200L,2,"Lorem Ipsum", bass);

        em.persist(sampleGuitar1);
        em.persist(sampleGuitar2);
        em.persist(sampleGuitar3);
        em.persist(sampleGuitar4);
    }
}