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


    public List<ProductEntity> getProducts() {
        Query q = em.createQuery("select p from ProductEntity p");
        return q.getResultList();
    }

    public ProductEntity save(ProductEntity p) {
        em.persist(p);
        return p;
    }
}
