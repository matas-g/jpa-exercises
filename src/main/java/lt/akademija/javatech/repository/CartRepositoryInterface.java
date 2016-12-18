package lt.akademija.javatech.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import lt.akademija.javatech.entity.CartEntity;

@Transactional(readOnly = true)
public interface CartRepositoryInterface {
    
    public CartEntity save(CartEntity cart);
    
    public List<CartEntity> findAllCarts();
    
    public CartEntity findCartById(Long id);
    
}
