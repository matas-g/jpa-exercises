package lt.akademija.javatech.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

import lt.akademija.javatech.cart.CartEntity;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    private ProductDetailsEntity details;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductSpecEntity> specifications;
    @ManyToMany(mappedBy = "products")
    private List<CartEntity> carts;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(ProductDetailsEntity details) {
        this.details = details;
    }
}
