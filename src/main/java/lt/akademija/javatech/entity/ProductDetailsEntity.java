/*
 * ex02
 */
package lt.akademija.javatech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PRODUCT_DETAILS")
public class ProductDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DETAILS")
    private String details;

    // Bi-directional One to One
    /*
     * 1. I vaikine Entity pridedam tevines Entity objekta
     * 
     * !!! Pridejus jo getters ir setters prasideda Stack Overflow !!! - turbut
     * to galima isvengt papildant metodus Controller/Service/Repository.
     * 
     * 2. Pridedam anotacija OneToOne su "mappedBy".
     * 
     * mappedBy reikalinga tik dvipusiam (Bi-directional) rysiui.
     * 
     * Prie mappedBy turi buti nurodytas tevineje Entity klaseje sukurto
     * ProductDetails objekto pavadinimas.
     */

    /*
     * TODO - kaip suprast?:
     * "Using mappedBy, If we only call person.getDocuments().add(document),
     * the foreign key in ID_DOCUMENTS will NOT be linked to the new document,
     * because this is not the owning /tracked side of the relation!
     * 
     * To link the document to the new person, you need to explicitly call
     * document.setPerson(person), because that is the owning side of the relation.
     * (IdDocument - owning entity)"
     */
    
    // TIP: stulpelis neatvaizduojamas kai naudojama mappedBy.
    // @OneToOne(mappedBy = "productDetails", cascade = CascadeType.ALL)
    
    // Andriaus Sareika 1-N N-1 bi-directional sprendimas (anotacijos)
    // jis naudojo ir setters / getters - ar jie tikrai cia reikalingi?
    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
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
