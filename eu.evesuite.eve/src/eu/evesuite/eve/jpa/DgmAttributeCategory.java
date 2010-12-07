package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dgmAttributeCategories database table.
 * 
 */
@Entity
@Table(name="dgmAttributeCategories")
public class DgmAttributeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte categoryID;

	private String categoryDescription;

	private String categoryName;

    public DgmAttributeCategory() {
    }

	public byte getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryDescription() {
		return this.categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}