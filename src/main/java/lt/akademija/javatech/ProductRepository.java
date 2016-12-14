package lt.akademija.javatech;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.ProductDetailsEntity;
import lt.akademija.javatech.entity.ProductEntity;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

    @Autowired
    private EntityManager em;

    // POST
    /*
     * Visu repository pagrindas turetu buti Interface.
     * 
     * @Transactional - reikalingas visoms CREATE, UPDATE, DELETE operacijoms;
     * @Transactional(readOnly=true) - reikalingas READ operacijoms;
     * 
     * Optimalus naudojimas:
     * - uzdeti "@Transactional(readOnly=true)" ant Repository Interface. Taip visi
     *      implementuojanciu Repository klasiu metodai tampa readOnly is DB;
     * - prie visu C,U,D metodu Repository klasese butina prideti "@Transactional",
     *      kad butu perrasyta Interface anotacija ir, kad metodai galetu veikti.
     */
    @Override
    @Transactional
    public ProductEntity save(ProductEntity p) {
        em.persist(p);
        return p;
    }

    @Override
    @Transactional
    public ProductDetailsEntity saveDetails(ProductDetailsEntity d) {
        em.persist(d);
        return d;
    }

    // GET
    @Override
    public List<ProductEntity> findAll() {
        TypedQuery<ProductEntity> query = em.createQuery("SELECT p from ProductEntity p", ProductEntity.class);
        return query.getResultList();
    }

    @Override
    public List<ProductEntity> findByTitle(String title) {
        TypedQuery<ProductEntity> query = em.createQuery("SELECT p FROM ProductEntity p WHERE p.title = :title", ProductEntity.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
    
}
