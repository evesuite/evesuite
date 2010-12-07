package eu.evesuite.eve.jpa;

import java.io.Serializable;

public class MapSolarSystemJumpPK implements Serializable {
	
	private static final long serialVersionUID = 1303850555092314831L;

	private int fromSolarSystemID;

	private int toSolarSystemID;

    public MapSolarSystemJumpPK() {
    }
    
	public int getFromSolarSystemID() {
		return this.fromSolarSystemID;
	}
	
	public void setFromSolarSystemID(int fromSolarSystemID) {
		this.fromSolarSystemID = fromSolarSystemID;
	}
	
	public int getToSolarSystemID() {
		return this.toSolarSystemID;
	}
	
	public void setToSolarSystemID(int toSolarSystemID) {
		this.toSolarSystemID = toSolarSystemID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MapSolarSystemJumpPK)) {
			return false;
		}
		MapSolarSystemJumpPK castOther = (MapSolarSystemJumpPK)other;
		return 
			(this.fromSolarSystemID == castOther.getFromSolarSystemID())
			&& (this.toSolarSystemID == castOther.getToSolarSystemID());

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fromSolarSystemID;
		hash = hash * prime + this.toSolarSystemID;
		
		return hash;
    }
}