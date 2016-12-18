package lt.akademija.javatech.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService service;
    
    @PostMapping
    public CartEntity save(@RequestBody CartEntity cart) {
        return service.save(cart);
    }

    @GetMapping
    public List<CartEntity> findAllCarts() {
        return service.findAllCarts();
    }

    @GetMapping(params = {"id"})
    public CartEntity findCartById(@RequestParam Long id) {
        return service.findCartById(id);
    }
    
}
