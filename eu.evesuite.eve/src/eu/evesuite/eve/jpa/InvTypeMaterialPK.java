package eu.evesuite.eve.jpa;

import java.io.Serializable;

public class InvTypeMaterialPK implements Serializable {
	
	private static final long serialVersionUID = -2695586247593923413L;

	private int typeID;

	private int materialTypeID;

    public InvTypeMaterialPK() {
    }
	public int getTypeID() {
		return this.typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getMaterialTypeID() {
		return this.materialTypeID;
	}
	public void setMaterialTypeID(int materialTypeID) {
		this.materialTypeID = materialTypeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvTypeMaterialPK)) {
			return false;
		}
		InvTypeMaterialPK castOther = (InvTypeMaterialPK)other;
		return 
			(this.typeID == castOther.typeID)
			&& (this.materialTypeID == castOther.materialTypeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.typeID);
		hash = hash * prime + (this.materialTypeID);
		
		return hash;
    }
}