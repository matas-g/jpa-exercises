package lt.akademija.javatech.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoryInterface repository;

    public ProductEntity save(ProductEntity p) {
        return repository.save(p);
    }
    
    public ProductEntity removeProductById(Long id) {
        return repository.removeProductById(id);
    }
    
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
        
    public List<ProductEntity> findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
