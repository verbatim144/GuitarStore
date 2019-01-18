package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private FavouritesEntity favourites;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private ShoppingCartEntity shoppingCart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OrderEntity> orders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<OpinionEntity> opinions;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserEntity(FavouritesEntity favourites,List<OpinionEntity> opinions, AddressEntity address, ShoppingCartEntity shoppingCart, String username, String password, String email) {
        this.favourites = favourites;
        this.shoppingCart = shoppingCart;
        this.opinions = opinions;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public List<OpinionEntity> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<OpinionEntity> opinions) {
        this.opinions = opinions;
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
