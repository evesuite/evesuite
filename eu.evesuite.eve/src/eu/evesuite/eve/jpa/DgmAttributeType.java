package eu.evesuite.eve.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the dgmAttributeTypes database table.
 * 
 */
@Entity
@Table(name="dgmAttributeTypes")
public class DgmAttributeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int attributeID;

	private String attributeName;

	private int categoryID;

	private double defaultValue;

	private String description;

	private String displayName;

	private int iconID;

	private boolean highIsGood;

	private boolean published;

	private boolean stackable;

	private int unitID;
	
	@OneToMany(mappedBy = "dgmAttributeType", fetch = FetchType.LAZY)	
	private Collection<DgmTypeAttribute> dgmTypeAttributes;	

    public Collection<DgmTypeAttribute> getDgmTypeAttributes() {
		return dgmTypeAttributes;
	}

	public void setDgmTypeAttributes(Collection<DgmTypeAttribute> dgmTypeAttributes) {
		this.dgmTypeAttributes = dgmTypeAttributes;
	}

	public DgmAttributeType() {
    }

	public int getAttributeID() {
		return this.attributeID;
	}

	public void setAttributeID(int attributeID) {
		this.attributeID = attributeID;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public double getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(double defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getIconID() {
		return this.iconID;
	}

	public void setIconID(int iconID) {
		this.iconID = iconID;
	}

	public boolean getHighIsGood() {
		return this.highIsGood;
	}

	public void setHighIsGood(boolean highIsGood) {
		this.highIsGood = highIsGood;
	}

	public boolean getPublished() {
		return this.published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean getStackable() {
		return this.stackable;
	}

	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

	public int getUnitID() {
		return this.unitID;
	}

	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}

}