package lt.akademija.javatech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
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
     * nauja stulpeli PRODUCTDETAILS_ID (PRODUCT_DETAILS_ID)
     * - jame atsiranda nuoroda i ProductDetailsEntity ID.
     */
    
    /*
     * TODO - pazaist / pasibandyt Bi-directional
     * @JsonManagedReference - reikalingas kai Bi-directional
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_DETAILS_ID")
    private ProductDetailsEntity productDetails;

    
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

}
