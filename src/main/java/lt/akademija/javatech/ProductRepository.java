package lt.akademija.javatech;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private EntityManager em;


    public ProductEntity save(ProductEntity p) {
        em.persist(p);
        return p;
    }

    public List<ProductEntity> findAll() {
        return em.createQuery("SELECT p from ProductEntity p").getResultList();
    }

    public List<ProductEntity> findByTitle(String title) {
        Query q = em.createQuery("SELECT p FROM ProductEntity p WHERE p.title = :title");
        q.setParameter("title", title);
        return q.getResultList();
    }
}
