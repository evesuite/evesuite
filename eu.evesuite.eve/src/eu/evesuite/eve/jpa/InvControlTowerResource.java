package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the invControlTowerResources database table.
 * 
 */
@Entity
@Table(name="invControlTowerResources")
public class InvControlTowerResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvControlTowerResourcePK id;

	private int factionID;

	private double minSecurityLevel;

	private byte purpose;

	private int quantity;

    public InvControlTowerResource() {
    }

	public InvControlTowerResourcePK getId() {
		return this.id;
	}

	public void setId(InvControlTowerResourcePK id) {
		this.id = id;
	}
	
	public int getFactionID() {
		return this.factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public double getMinSecurityLevel() {
		return this.minSecurityLevel;
	}

	public void setMinSecurityLevel(double minSecurityLevel) {
		this.minSecurityLevel = minSecurityLevel;
	}

	public byte getPurpose() {
		return this.purpose;
	}

	public void setPurpose(byte purpose) {
		this.purpose = purpose;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}