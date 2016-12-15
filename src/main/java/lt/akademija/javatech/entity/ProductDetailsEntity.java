/*
 * ex02
 */
package lt.akademija.javatech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	 * !!! Pridejus jo getters ir setters prasideda Stack Overflow !!!
	 * 
	 * 2. Pridedam anotacija OneToOne su "mappedBy".
	 * mappedBy reikalinga tik dvipusiam (Bi-directional) rysiui.
	 * 
	 * Prie mappedBy turi buti nurodytas tevineje Entity klaseje sukurto
	 * ProductDetails objekto pavadinimas.
	 */

	
	// One to One Bi-directional
	
	// Andriaus Sareikos 1-N N-1 bi-directional sprendimas (anotacijos):
	// jis naudojo ir setters / getters - ar jie tikrai cia reikalingi?
	// @OneToOne(cascade = CascadeType.ALL)
	// @JsonBackReference

	// @OneToOne(mappedBy = "productDetails")
	// private ProductEntity product;

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
