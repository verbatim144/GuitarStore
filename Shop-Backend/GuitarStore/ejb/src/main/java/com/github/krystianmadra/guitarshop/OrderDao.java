package com.github.krystianmadra.guitarshop;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.Set;

@Stateless
public class OrderDao {

    @EJB
    private UserDao userDao;

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public Optional<OrderEntity> add(OrderEntity order) {
        UserEntity user = userDao.getUserById(order.getUser().getId()).get();
        Set<GuitarEntity> guitarEntities = order.getGuitars();
        order.setUser(user);

        em.persist(guitarEntities);
        em.persist(order);
        return Optional.of(order);
    }
}
