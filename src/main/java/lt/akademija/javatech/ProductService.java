package lt.akademija.javatech;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductEntity> getProducts() {
        return repository.getProducts();
    }

    @Transactional
    public ProductEntity save(ProductEntity p) {
        return repository.save(p);
    }
}
