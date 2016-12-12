package lt.akademija.javatech;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	// ex02
	/*
	 * cascade padaro, kad visu tipu cia daromi pakeitimai atsispindetu
	 * ir vaikiniame Entity. Vietoj ALL gali buti ir kiti tipai - MERGE,
	 * PERSIST, ir t.t.
	 * 
	 * vienpusis sarysis is produkto i detales.
	 * ProductEntity lenteleje sukuria nauja stulpeli DETAILS_ID - 
	 * 
	 * TODO neatsiranda nuoroda i ProductDetailsEntity.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetailsEntity details;

	@Column
	private String title;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductDetailsEntity getDetails() {
		return details;
	}

	public void setDetails(ProductDetailsEntity details) {
		this.details = details;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
