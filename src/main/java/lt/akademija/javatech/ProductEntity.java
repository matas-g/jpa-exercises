package lt.akademija.javatech;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Klases pavadinimas = Lenteles pavadinimas
@Entity
public class ProductEntity {

    // stulpelis: id = pirminis raktas, generuojamas automatiškai
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // stulpelis: title
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
