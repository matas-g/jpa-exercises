package lt.akademija.javatech;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.ProductEntity;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public ProductEntity save(ProductEntity p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            ProductEntity merged = em.merge(p);
            em.persist(merged);
            return merged;
        }
    }

    @Override
    public List<ProductEntity> findAll() {
        TypedQuery<ProductEntity> query = em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class);
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> findByTitle(String title) {
        TypedQuery<ProductEntity> query = em.createQuery("SELECT p FROM ProductEntity p WHERE title = :title", ProductEntity.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
