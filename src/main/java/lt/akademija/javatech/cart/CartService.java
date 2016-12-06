package lt.akademija.javatech.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public CartEntity save(CartEntity c) {
        return repository.save(c);
    }

    @Transactional(readOnly = true)
    public List<CartEntity> findAll() {
        return repository.findAll();
    }
}
