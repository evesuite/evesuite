package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eveUnits database table.
 * 
 */
@Entity
@Table(name="eveUnits")
public class EveUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte unitID;

	private String description;

	private String displayName;

	private String unitName;

    public EveUnit() {
    }

	public byte getUnitID() {
		return this.unitID;
	}

	public void setUnitID(byte unitID) {
		this.unitID = unitID;
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

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

}