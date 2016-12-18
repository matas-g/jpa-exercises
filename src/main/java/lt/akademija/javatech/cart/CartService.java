package lt.akademija.javatech.cart;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepositoryInterface repository;
    
    public CartEntity save(CartEntity cart) {
        Date now = new Date();
        
        if (cart.getId() == null) {
            cart.setDateCreated(now);
            cart.setDateUpdated(now);
        } else {
            CartEntity oldCart = repository.findCartById(cart.getId());
            cart.setDateCreated(oldCart.getDateCreated());
            cart.setDateUpdated(now);
        }
        return repository.save(cart);
    }

    public List<CartEntity> findAllCarts() {
        return repository.findAllCarts();
    }

    public CartEntity findCartById(Long id) {
        return repository.findCartById(id);
    }
    
}
