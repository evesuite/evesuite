package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the mapRegionJumps database table.
 * 
 */
@Embeddable
public class MapRegionJumpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int fromRegionID;

	private int toRegionID;

    public MapRegionJumpPK() {
    }
	public int getFromRegionID() {
		return this.fromRegionID;
	}
	public void setFromRegionID(int fromRegionID) {
		this.fromRegionID = fromRegionID;
	}
	public int getToRegionID() {
		return this.toRegionID;
	}
	public void setToRegionID(int toRegionID) {
		this.toRegionID = toRegionID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MapRegionJumpPK)) {
			return false;
		}
		MapRegionJumpPK castOther = (MapRegionJumpPK)other;
		return 
			(this.fromRegionID == castOther.fromRegionID)
			&& (this.toRegionID == castOther.toRegionID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fromRegionID;
		hash = hash * prime + this.toRegionID;
		
		return hash;
    }
}