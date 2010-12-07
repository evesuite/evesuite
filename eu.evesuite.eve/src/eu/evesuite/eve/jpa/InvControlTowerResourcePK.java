package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the invControlTowerResources database table.
 * 
 */
@Embeddable
public class InvControlTowerResourcePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private short controlTowerTypeID;

	private short resourceTypeID;

    public InvControlTowerResourcePK() {
    }
	public short getControlTowerTypeID() {
		return this.controlTowerTypeID;
	}
	public void setControlTowerTypeID(short controlTowerTypeID) {
		this.controlTowerTypeID = controlTowerTypeID;
	}
	public short getResourceTypeID() {
		return this.resourceTypeID;
	}
	public void setResourceTypeID(short resourceTypeID) {
		this.resourceTypeID = resourceTypeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvControlTowerResourcePK)) {
			return false;
		}
		InvControlTowerResourcePK castOther = (InvControlTowerResourcePK)other;
		return 
			(this.controlTowerTypeID == castOther.controlTowerTypeID)
			&& (this.resourceTypeID == castOther.resourceTypeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.controlTowerTypeID);
		hash = hash * prime + (this.resourceTypeID);
		
		return hash;
    }
}