package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dgmTypeEffects database table.
 * 
 */
@Embeddable
public class DgmTypeEffectPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private short typeID;

	private short effectID;

    public DgmTypeEffectPK() {
    }
	public short getTypeID() {
		return this.typeID;
	}
	public void setTypeID(short typeID) {
		this.typeID = typeID;
	}
	public short getEffectID() {
		return this.effectID;
	}
	public void setEffectID(short effectID) {
		this.effectID = effectID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DgmTypeEffectPK)) {
			return false;
		}
		DgmTypeEffectPK castOther = (DgmTypeEffectPK)other;
		return 
			(this.typeID == castOther.typeID)
			&& (this.effectID == castOther.effectID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.typeID);
		hash = hash * prime + (this.effectID);
		
		return hash;
    }
}