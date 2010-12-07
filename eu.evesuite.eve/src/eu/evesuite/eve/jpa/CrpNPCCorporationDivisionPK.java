package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the crpNPCCorporationDivisions database table.
 * 
 */
@Embeddable
public class CrpNPCCorporationDivisionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int corporationID;

	private byte divisionID;

    public CrpNPCCorporationDivisionPK() {
    }
	public int getCorporationID() {
		return this.corporationID;
	}
	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}
	public byte getDivisionID() {
		return this.divisionID;
	}
	public void setDivisionID(byte divisionID) {
		this.divisionID = divisionID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrpNPCCorporationDivisionPK)) {
			return false;
		}
		CrpNPCCorporationDivisionPK castOther = (CrpNPCCorporationDivisionPK)other;
		return 
			(this.corporationID == castOther.corporationID)
			&& (this.divisionID == castOther.divisionID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.corporationID;
		hash = hash * prime + (this.divisionID);
		
		return hash;
    }
}