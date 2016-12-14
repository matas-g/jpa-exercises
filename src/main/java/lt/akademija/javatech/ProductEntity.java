package lt.akademija.javatech;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Klases pavadinimas = Lenteles pavadinimas, jei nenaudojama @Table anotacija su name.
@Entity
@Table(name = "products")
public class ProductEntity {

    // stulpelis: id = pirminis raktas, generuojamas automatiškai
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    // stulpelis: title
    @Column(name = "title")
    private String title;

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
}
