package lt.akademija.javatech.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    // ex02
    // Uni-directional One to One
    /*
     * cascade padaro, kad visu tipu cia daromi pakeitimai atsispindetu ir
     * vaikiniame Entity. Vietoj ALL gali buti ir kiti tipai - MERGE, PERSIST,
     * ir t.t.
     * 
     * vienpusis sarysis is produkto i detales. ProductEntity lenteleje sukuria
     * nauja stulpeli DETAILS_ID - jame atsiranda nuoroda i ProductDetailsEntity
     * ID.
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DETAILS_ID")
    private ProductDetailsEntity productDetails;

    // ex03
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private List<ProductSpecEntity> specifications;
    
    // Getters and Setters
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

    public ProductDetailsEntity getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetailsEntity productDetails) {
        this.productDetails = productDetails;
    }

    public List<ProductSpecEntity> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<ProductSpecEntity> specifications) {
        this.specifications = specifications;
    }

}
