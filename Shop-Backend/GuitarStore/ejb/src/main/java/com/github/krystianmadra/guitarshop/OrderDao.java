package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Stateless
public class OrderDao {

    @EJB
    private UserDao userDao;

    @EJB
    private GuitarDao guitarDao;


    public List<OrderEntity> getAllOrders(){
        return em.createQuery("select u from OrderEntity u", OrderEntity.class).getResultList();
    }


    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public Optional<OrderEntity> add(OrderEntity order) {
        UserEntity user = userDao.getUserByName(order.getUser().getUsername()).get();
        order.setUser(user);

        Set<GuitarEntity> guitars = new HashSet<>();

        for(GuitarEntity guitar : order.getGuitars()){
            Optional<GuitarEntity> ret = guitarDao.findById(guitar.getId());
            guitars.add(ret.get());
        }

        order.setGuitars(guitars);

        em.persist(order);
        return Optional.of(order);
    }
}
