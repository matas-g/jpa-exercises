package lt.akademija.javatech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_SPECIFICATION")
public class ProductSpecEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SPEC_NAME")
    private String key;

    @Column(name = "VALUE")
    private String value;

    /*
     * TODO - Bi-directional OneToMany/ManyToOne
     * 
     * @ManyToOne(cascade = CascadeType.ALL) private ProductEntity product;
     */

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
