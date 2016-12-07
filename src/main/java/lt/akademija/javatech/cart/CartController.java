package lt.akademija.javatech.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/api/carts")
    public Iterable<CartEntity> carts() {
        return service.findAll();
    }

    @PostMapping("/api/carts")
    public CartEntity createOrUpdateProduct(@RequestBody CartEntity c) {
        return service.save(c);
    }
}
