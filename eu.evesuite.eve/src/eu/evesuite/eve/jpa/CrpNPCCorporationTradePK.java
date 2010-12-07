package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the crpNPCCorporationTrades database table.
 * 
 */
@Embeddable
public class CrpNPCCorporationTradePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int corporationID;

	private short typeID;

    public CrpNPCCorporationTradePK() {
    }
	public int getCorporationID() {
		return this.corporationID;
	}
	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
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
		if (!(other instanceof CrpNPCCorporationTradePK)) {
			return false;
		}
		CrpNPCCorporationTradePK castOther = (CrpNPCCorporationTradePK)other;
		return 
			(this.corporationID == castOther.corporationID)
			&& (this.typeID == castOther.typeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.corporationID;
		hash = hash * prime + (this.typeID);
		
		return hash;
    }
}