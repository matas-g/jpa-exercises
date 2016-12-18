package lt.akademija.javatech.cart;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CartRepositoryInterface {
    
    public CartEntity save(CartEntity cart);
    
    public List<CartEntity> findAllCarts();
    
    public CartEntity findCartById(Long id);
    
}
