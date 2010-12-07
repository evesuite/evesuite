package eu.evesuite.eve.jpa;

import java.io.Serializable;

public class RamTypeRequirementPK implements Serializable {

	private static final long serialVersionUID = 6980688002708874249L;

	private int typeID;

	private int activityID;

	private int requiredTypeID;

    public RamTypeRequirementPK() {
    }
	public int getTypeID() {
		return this.typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getActivityID() {
		return this.activityID;
	}
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
	public int getRequiredTypeID() {
		return this.requiredTypeID;
	}
	public void setRequiredTypeID(int requiredTypeID) {
		this.requiredTypeID = requiredTypeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RamTypeRequirementPK)) {
			return false;
		}
		RamTypeRequirementPK castOther = (RamTypeRequirementPK)other;
		return 
			(this.typeID == castOther.typeID)
			&& (this.activityID == castOther.activityID)
			&& (this.requiredTypeID == castOther.requiredTypeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.typeID);
		hash = hash * prime + (this.activityID);
		hash = hash * prime + (this.requiredTypeID);
		
		return hash;
    }
}