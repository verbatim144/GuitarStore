package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FAVOURITES")
public class FavouritesEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne
    private UserEntity user;

    @ManyToMany
    private Set<GuitarEntity> guitars;

    public FavouritesEntity() {
        guitars = new HashSet<GuitarEntity>();
    }

    public FavouritesEntity(UserEntity user) {
        this();
        this.user = user;
    }

    public FavouritesEntity(Long id, UserEntity user, Set<GuitarEntity> guitars) {
        this();
        this.id = id;
        this.user = user;
        this.guitars = guitars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<GuitarEntity> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<GuitarEntity> guitars) {
        this.guitars = guitars;
    }
}
