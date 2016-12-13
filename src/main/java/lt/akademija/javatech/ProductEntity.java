package lt.akademija.javatech;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @OneToOne(cascade = CascadeType.ALL)
    private ProductDetailsEntity pDetails;

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

    public ProductDetailsEntity getpDetails() {
        return pDetails;
    }

    public void setpDetails(ProductDetailsEntity pDetails) {
        this.pDetails = pDetails;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
