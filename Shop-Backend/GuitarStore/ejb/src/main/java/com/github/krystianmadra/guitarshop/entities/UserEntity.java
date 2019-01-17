package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @OneToOne
    private FavouritesEntity favourites;
    @OneToOne
    private ShoppingCartEntity shoppingCart;
    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;

    private String username;
    private String password;
    private String email;

    public UserEntity(FavouritesEntity favourites, List<OrderEntity> orders, ShoppingCartEntity shoppingCart, String username, String password, String email) {
        this.favourites = favourites;
        this.shoppingCart = shoppingCart;
        this.username = username;
        this.orders = orders;
        this.password = password;
        this.email = email;
    }

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public FavouritesEntity getFavourites() {
        return favourites;
    }

    public void setFavourites(FavouritesEntity favourites) {
        this.favourites = favourites;
    }

    public ShoppingCartEntity getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartEntity shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
