package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the agtResearchAgents database table.
 * 
 */
@Embeddable
public class AgtResearchAgentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int agentID;

	private int typeID;

    public AgtResearchAgentPK() {
    }
	public int getAgentID() {
		return this.agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public int getTypeID() {
		return this.typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AgtResearchAgentPK)) {
			return false;
		}
		AgtResearchAgentPK castOther = (AgtResearchAgentPK)other;
		return 
			(this.agentID == castOther.agentID)
			&& (this.typeID == castOther.typeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.agentID;
		hash = hash * prime + (this.typeID);
		
		return hash;
    }
}