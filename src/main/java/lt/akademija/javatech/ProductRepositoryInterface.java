package lt.akademija.javatech;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.ProductEntity;

@Transactional(readOnly = true)
public interface ProductRepositoryInterface {

    public ProductEntity save(ProductEntity p);
    
    public List<ProductEntity> findAll();
    public List<ProductEntity> findByTitle(String title);
    
}
