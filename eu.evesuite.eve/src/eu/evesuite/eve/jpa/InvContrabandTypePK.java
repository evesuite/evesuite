package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the invContrabandTypes database table.
 * 
 */
@Embeddable
public class InvContrabandTypePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int factionID;

	private short typeID;

    public InvContrabandTypePK() {
    }
	public int getFactionID() {
		return this.factionID;
	}
	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}
	public short getTypeID() {
		return this.typeID;
	}
	public void setTypeID(short typeID) {
		this.typeID = typeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvContrabandTypePK)) {
			return false;
		}
		InvContrabandTypePK castOther = (InvContrabandTypePK)other;
		return 
			(this.factionID == castOther.factionID)
			&& (this.typeID == castOther.typeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.factionID;
		hash = hash * prime + (this.typeID);
		
		return hash;
    }
}