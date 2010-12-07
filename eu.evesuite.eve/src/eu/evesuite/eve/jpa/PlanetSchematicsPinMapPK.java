package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the planetSchematicsPinMap database table.
 * 
 */
@Embeddable
public class PlanetSchematicsPinMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private short schematicID;

	private short pinTypeID;

    public PlanetSchematicsPinMapPK() {
    }
	public short getSchematicID() {
		return this.schematicID;
	}
	public void setSchematicID(short schematicID) {
		this.schematicID = schematicID;
	}
	public short getPinTypeID() {
		return this.pinTypeID;
	}
	public void setPinTypeID(short pinTypeID) {
		this.pinTypeID = pinTypeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlanetSchematicsPinMapPK)) {
			return false;
		}
		PlanetSchematicsPinMapPK castOther = (PlanetSchematicsPinMapPK)other;
		return 
			(this.schematicID == castOther.schematicID)
			&& (this.pinTypeID == castOther.pinTypeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.schematicID);
		hash = hash * prime + (this.pinTypeID);
		
		return hash;
    }
}