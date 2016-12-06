package lt.akademija.javatech.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/api/products")
    public Iterable<ProductEntity> products() {
        return service.findAll();
    }

    @GetMapping(value = "/api/products", params = {"title"})
    public Iterable<ProductEntity> getProductsByTitle(@RequestParam String title) {
        return service.findByTitle(title);
    }

    @PostMapping("/api/products")
    public ProductEntity createOrUpdateProduct(@RequestBody ProductEntity p) {
        return service.save(p);
    }
}
