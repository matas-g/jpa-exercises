package lt.akademija.javatech.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.CartEntity;

@Repository
public class CartRepository implements CartRepositoryInterface {

    @Autowired
    private EntityManager em;
    
    @Transactional
    @Override
    public CartEntity save(CartEntity cart) {
        if (cart.getId() == null) {
            em.persist(cart);
            return cart;
        } else {
            CartEntity mergedCart = em.merge(cart);
            em.persist(mergedCart);
            return mergedCart;
        }
    }

    @Override
    public List<CartEntity> findAllCarts() {
        TypedQuery<CartEntity> query = em.createQuery("SELECT c from CartEntity c", CartEntity.class);
        return query.getResultList();
    }

    @Override
    public CartEntity findCartById(Long id) {
        return em.find(CartEntity.class, id);
    }
    
}
