package com.github.krystianmadra.guitarshop;

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

    public List<UserEntity> getAllUsers(){
        return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

    public UserEntity updateToken(Long id, String token, LocalTime tokenExpirationDate) {
        UserEntity dbUser = getUserById(id).get();
        dbUser.updateToken(token, tokenExpirationDate);
        UserEntity ret = em.merge(dbUser);
        return ret;
    }

    public void saveUserID(UserEntity user) {
        em.persist(user);
    }
}
