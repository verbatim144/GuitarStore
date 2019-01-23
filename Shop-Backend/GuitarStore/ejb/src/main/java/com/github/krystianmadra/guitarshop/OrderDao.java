package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderDao {

    @EJB
    private UserDao userDao;

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public void addOrder(OrderEntity order) {
        UserEntity user = userDao.getUserById(order.getUser().getId()).get();
        order.setUser(user);

        em.persist(order);
    }
}
