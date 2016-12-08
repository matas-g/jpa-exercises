package lt.akademija.javatech;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/api/products")
    public List<ProductEntity> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/api/products")
    public ProductEntity save(ProductEntity p) {
        return service.save(p);
    }
}
