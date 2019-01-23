package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
    private String token;
    private LocalTime tokenExpirationDate;

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
        role = Role.USER;
        favourites = new FavouritesEntity(this);
        shoppingCart = new ShoppingCartEntity(this);
        address = new AddressEntity(this);
    }

    public UserEntity(Long id) {
        this();
        this.id = id;
    }

    public UserEntity(String username, String password, String email) {
        this();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserEntity(Long id, String username, String password, String email) {
        this(username, password, email);
        this.id = id;
    }

    public UserEntity(FavouritesEntity favourites,List<OpinionEntity> opinions, AddressEntity address, ShoppingCartEntity shoppingCart, String username, String password, String email, String token) {
        this(username, password, email);
        this.favourites = favourites;
        this.shoppingCart = shoppingCart;
        this.opinions = opinions;
        this.address = address;
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

    public LocalTime getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(LocalTime tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public void updateToken(String token, LocalTime tokenExpirationDate) {
        this.token = token;
        this.tokenExpirationDate = tokenExpirationDate;
    }
}
