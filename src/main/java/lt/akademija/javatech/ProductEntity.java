package lt.akademija.javatech;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    /*
     * TIP - pildant JSON, stulpelio pavadinimas turi sutapti ne su situo
     * pavadinimu (details), o turbut su Setteriu/Getteriu parametru
     * pavadinimais (details).
     */
    @OneToOne(cascade = CascadeType.ALL)
    private ProductDetailsEntity details;

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

    public ProductDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(ProductDetailsEntity details) {
        this.details = details;
    }

    public List<ProductSpecEntity> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<ProductSpecEntity> specifications) {
        this.specifications = specifications;
    }

}
