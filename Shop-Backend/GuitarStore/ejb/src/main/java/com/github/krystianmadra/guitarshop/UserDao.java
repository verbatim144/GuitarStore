package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.Role;
import com.github.krystianmadra.guitarshop.entities.ShoppingCartEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public UserDao(){
    }

    public List<UserEntity> getAllUsers(){
        return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

    public Optional<UserEntity> getUserWithCredentials(String username, String password){
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u where u.username = :username and u.password = :password", UserEntity.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        UserEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }

    public Optional<UserEntity> getUserById(Long id){
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u where u.id = :id", UserEntity.class);
        query.setParameter("id", id);
        UserEntity ret = query.getSingleResult();

        return Optional.of(ret);
    }

    public UserEntity updateToken(Long id, String token, LocalTime tokenExpirationDate) {
        UserEntity dbUser = getUserById(id).get();
        dbUser.updateToken(token, tokenExpirationDate);
        return em.merge(dbUser);
    }

    public void saveUser(UserEntity user) {
        em.persist(user);
    }

    public Optional<ShoppingCartEntity> getShoppingCartByUserId(Long id) {
        TypedQuery<ShoppingCartEntity> query = em.createQuery("select s from ShoppingCartEntity s where s.user.id = :id", ShoppingCartEntity.class);
        query.setParameter("id", id);

        ShoppingCartEntity ret = query.getSingleResult();
        return Optional.of(ret);
    }

    public void UpdateProductsList(ShoppingCartEntity shoppingCartEntity) {
        em.merge(shoppingCartEntity);
    }
}
