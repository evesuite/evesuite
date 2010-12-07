package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the crpNPCCorporationResearchFields database table.
 * 
 */
@Embeddable
public class CrpNPCCorporationResearchFieldPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private short skillID;

	private int corporationID;

    public CrpNPCCorporationResearchFieldPK() {
    }
	public short getSkillID() {
		return this.skillID;
	}
	public void setSkillID(short skillID) {
		this.skillID = skillID;
	}
	public int getCorporationID() {
		return this.corporationID;
	}
	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrpNPCCorporationResearchFieldPK)) {
			return false;
		}
		CrpNPCCorporationResearchFieldPK castOther = (CrpNPCCorporationResearchFieldPK)other;
		return 
			(this.skillID == castOther.skillID)
			&& (this.corporationID == castOther.corporationID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.skillID);
		hash = hash * prime + this.corporationID;
		
		return hash;
    }
}