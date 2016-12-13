package lt.akademija.javatech.reports;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.stream.IntStream;

import lt.akademija.javatech.cart.CartEntity;
import lt.akademija.javatech.cart.CartService;
import lt.akademija.javatech.product.ProductEntity;
import lt.akademija.javatech.product.ProductService;
import lt.akademija.javatech.product.ProductSpecEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class TestData {

    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private TransactionTemplate template;

    @PostConstruct
    public void preloadData() {
        template.execute(t -> {
            addToCart(createProduct("Dell", true), 5);
            addToCart(createProduct("ShouldNotBeReturnedNoSpec", false), 20);
            addToCart(createProduct("HP", true), 89);
            addToCart(createProduct("ShouldNotBeReturnedNotInCart", true), 0);
            addToCart(createProduct("Šilelis", true), 789);
            return null;
        });
    }

    private void addToCart(ProductEntity p, Integer times) {
        IntStream.range(0, times).forEach( a -> addToCart(p));
    }

    private CartEntity addToCart(ProductEntity p) {
        CartEntity c = new CartEntity();
        c.setProducts(new ArrayList<>());
        c.getProducts().add(p);
        return cartService.save(c);
    }

    private ProductEntity createProduct(String title, boolean addSpec) {
        ProductEntity p = new ProductEntity();
        p.setSpecifications(new ArrayList<>());
        if (addSpec) {
            ProductSpecEntity spec = new ProductSpecEntity();
            spec.setKey("monitorType");
            spec.setValue("LCD");
            p.getSpecifications().add(spec);
        }
        p.setTitle(title);
        return productService.save(p);
    }
}
