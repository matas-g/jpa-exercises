package lt.akademija.javatech;

import java.util.List;

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
    public List<ProductEntity> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/api/products")
    public ProductEntity save(@RequestBody ProductEntity p) {
        return service.save(p);
    }

    // ex01
    @GetMapping(value = "/api/products", params = { "title" })
    public List<ProductEntity> getProductsByName(@RequestParam String title) {
        return service.getProductsByTitle(title);
    }
}
