/*
 * ex02
 */
package lt.akademija.javatech;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String details;

    // Bi-directional One to One
    /*
     * 1. I vaikine Entity pridedam tevines Entity objekta
     *    
     *    !!! Pridejus jo getters ir setters prasideda Stack Overflow !!!
     *    - turbut to galima isvengt sukurus ProductDetails objektu sukurimo
     *      metodus Controller/Service/Repository.
     *      
     * 2. Pridedam anotacija OneToOne su "mappedBy".
     * 
     * mappedBy reikalinga tik dvipusiam (Bi-directional) rysiui.
     * 
     * Prie mappedBy turi buti nurodytas tevineje Entity klaseje sukurto
     * ProductDetails objekto pavadinimas.
     */
    @OneToOne(mappedBy = "pDetails", cascade = CascadeType.ALL)
    private ProductEntity product;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
