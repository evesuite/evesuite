package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the agtConfig database table.
 * 
 */
@Embeddable
public class AgtConfigPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int agentID;

	private String k;

    public AgtConfigPK() {
    }
	public int getAgentID() {
		return this.agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public String getK() {
		return this.k;
	}
	public void setK(String k) {
		this.k = k;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AgtConfigPK)) {
			return false;
		}
		AgtConfigPK castOther = (AgtConfigPK)other;
		return 
			(this.agentID == castOther.agentID)
			&& this.k.equals(castOther.k);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.agentID;
		hash = hash * prime + this.k.hashCode();
		
		return hash;
    }
}