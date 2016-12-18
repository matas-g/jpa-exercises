package lt.akademija.javatech.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProductRepositoryInterface {

    ProductEntity save(ProductEntity p);

    ProductEntity removeProductById(Long id);
    
    List<ProductEntity> findAll();

    List<ProductEntity> findByTitle(String title);

}