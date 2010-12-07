package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crtCategories database table.
 * 
 */
@Entity
@Table(name="crtCategories")
public class CrtCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte categoryID;

	private String categoryName;

	private String description;

    public CrtCategory() {
    }

	public byte getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}