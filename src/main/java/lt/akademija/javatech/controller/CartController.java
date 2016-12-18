package lt.akademija.javatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.akademija.javatech.entity.CartEntity;
import lt.akademija.javatech.service.CartService;

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
