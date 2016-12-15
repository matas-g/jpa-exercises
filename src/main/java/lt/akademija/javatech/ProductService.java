package lt.akademija.javatech;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.ProductEntity;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoryInterface repository;

    @Transactional
    public ProductEntity save(ProductEntity p) {
        return repository.save(p);
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
        
    public List<ProductEntity> findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
