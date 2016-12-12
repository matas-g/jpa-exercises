package lt.akademija.javatech;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private EntityManager em;

    public List<ProductEntity> getProducts() {
        Query q = em.createQuery("select p from ProductEntity p");
        return q.getResultList();
    }

    public ProductEntity save(ProductEntity p) {
        em.persist(p);
        return p;
    }

    // ex01
    public List<ProductEntity> getProductsByTitle(String title) {
        Query q = em.createQuery("SELECT p FROM ProductEntity p WHERE p.title = :title");
        q.setParameter("title", title);
        return q.getResultList();
    }
}
