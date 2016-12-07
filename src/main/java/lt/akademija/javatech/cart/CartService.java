package lt.akademija.javatech.cart;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    @Transactional
    public CartEntity save(CartEntity c) {
        Date now = new Date();
        if (c.getId() != null) {
            CartEntity oldCart = repository.find(c.getId());
            c.setCreatedOn(oldCart.getCreatedOn());
            c.setUpdatedOn(now);
        } else {
            c.setCreatedOn(now);
            c.setUpdatedOn(now);
        }
        return repository.save(c);
    }

    @Transactional(readOnly = true)
    public List<CartEntity> findAll() {
        return repository.findAll();
    }
}
