package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCartEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @OneToOne(mappedBy = "shoppingCart")
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<GuitarEntity> products;

    public ShoppingCartEntity(Long id, UserEntity user, Set<GuitarEntity> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCartEntity() {
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<GuitarEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<GuitarEntity> products) {
        this.products = products;
    }
}
