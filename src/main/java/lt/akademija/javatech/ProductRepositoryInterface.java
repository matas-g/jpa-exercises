package lt.akademija.javatech;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.ProductEntity;

@Transactional(readOnly = true)
public interface ProductRepositoryInterface {

    ProductEntity save(ProductEntity p);

    List<ProductEntity> findAll();

    List<ProductEntity> findByTitle(String title);

}