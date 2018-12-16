package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

@Startup
@Singleton
public class GuitarDao {

    private final Set<GuitarEntity> guitars = new HashSet<>();

    public GuitarDao() {
    }


    @PostConstruct
    void init(){
        guitars.add(new GuitarEntity(1l, "Ibanez 740", 1199.99));
        guitars.add(new GuitarEntity(2l, "Yamaha C30M", 530.0));
        guitars.add(new GuitarEntity(3l, "Yamaha F310P", 730.99));
    }

    public Optional<GuitarEntity> getGuitarById(long id){
        return guitars.stream().filter(e -> e.getId() == id).findFirst();
    }

    public List<GuitarEntity> getAll(){
        return new ArrayList(guitars);
    }

    public GuitarEntity addGuitar(GuitarEntity guitar){
        guitar.setId((long) (guitars.size()+1));
        guitars.add(guitar);
        return guitar;
    }

    public GuitarEntity editGuitar(GuitarEntity guitar){
        GuitarEntity fromDB = guitars.stream().filter(e -> e.getId() == guitar.getId()).findFirst().get();
        fromDB.update(guitar);
        return fromDB;
    }

    public void remove(long id) {
        guitars.remove(new GuitarEntity(id));
    }

    public GuitarEntity update(GuitarEntity guitar) {
        Optional<GuitarEntity> guitarFromDatabase = guitars.stream().filter(ent -> ent.getId().equals(guitar.getId())).findFirst();
        guitarFromDatabase.ifPresent(fromDb -> fromDb.update(guitar));
        return guitarFromDatabase.get();
    }
}
