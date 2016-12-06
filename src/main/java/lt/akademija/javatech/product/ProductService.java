package lt.akademija.javatech.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductEntity save(ProductEntity p) {
        return repository.save(p);
    }

    @Transactional(readOnly = true)
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ProductEntity> findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
