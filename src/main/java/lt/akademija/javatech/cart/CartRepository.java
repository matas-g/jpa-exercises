package lt.akademija.javatech.cart;

import javax.persistence.EntityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    @Autowired
    private EntityManager em;

    public CartEntity find(Long id) {
        return em.find(CartEntity.class, id);
    }

    public CartEntity save(CartEntity c) {
        if (c.getId() == null) {
            em.persist(c);
            return c;
        } else {
            CartEntity merged = em.merge(c);
            em.persist(merged);
            return merged;
        }
    }

    public List<CartEntity> findAll() {
        return em.createQuery("SELECT c from CartEntity c").getResultList();
    }
}
