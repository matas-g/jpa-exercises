package lt.akademija.javatech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.akademija.javatech.entity.ProductEntity;
import lt.akademija.javatech.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ProductEntity createOrUpdateProduct(@RequestBody ProductEntity product) {
        return service.save(product);
    }

    @DeleteMapping(params = { "id" })
    public ProductEntity removeProductById(@RequestParam Long id) {
        return service.removeProductById(id);
    }

    @GetMapping
    public Iterable<ProductEntity> findAllProducts() {
        return service.findAll();
    }

    @GetMapping(params = { "title" })
    public Iterable<ProductEntity> findProductsByTitle(@RequestParam String title) {
        return service.findByTitle(title);
    }

}
