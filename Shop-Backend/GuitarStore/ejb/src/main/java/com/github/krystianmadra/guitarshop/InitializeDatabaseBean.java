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
        GuitarCategoryEntity electric = new GuitarCategoryEntity(1l,"Electric");
        GuitarCategoryEntity classic = new GuitarCategoryEntity(2l,"Classic");
        GuitarCategoryEntity acoustic = new GuitarCategoryEntity(3l,"Acoustic");
        GuitarCategoryEntity bass = new GuitarCategoryEntity(4l,"Bass");

        List<OpinionEntity> opinionEntityList = new ArrayList<>();
        OpinionEntity op = new OpinionEntity(5l,5,"good good");
        opinionEntityList.add(new OpinionEntity(5l,5,"good good"));

        GuitarEntity sampleGuitar1 = new GuitarEntity(6l,"Electric sample", new BigDecimal(1200L), electric);
        GuitarEntity sampleGuitar2 = new GuitarEntity(7l,"Classic sample", new BigDecimal(1200L), classic);
        sampleGuitar2.setOpinionEntities(opinionEntityList);
        GuitarEntity sampleGuitar3 = new GuitarEntity(8l,"Acoustic sample", new BigDecimal(1200L), acoustic);
        GuitarEntity sampleGuitar4 = new GuitarEntity(9l,"Bass sample", new BigDecimal(1200L), bass);

        em.persist(op);
        em.persist(sampleGuitar1);
        em.persist(sampleGuitar2);
        em.persist(sampleGuitar3);
        em.persist(sampleGuitar4);
    }
}