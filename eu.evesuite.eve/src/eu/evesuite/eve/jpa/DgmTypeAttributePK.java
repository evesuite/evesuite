package eu.evesuite.eve.jpa;

import java.io.Serializable;

public class DgmTypeAttributePK implements Serializable {
	
	private static final long serialVersionUID = 5198585725874542361L;

	private int typeID;

	private int attributeID;

    public DgmTypeAttributePK() {
    }
	public int getTypeID() {
		return this.typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public int getAttributeID() {
		return this.attributeID;
	}
	public void setAttributeID(int attributeID) {
		this.attributeID = attributeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DgmTypeAttributePK)) {
			return false;
		}
		DgmTypeAttributePK castOther = (DgmTypeAttributePK)other;
		return 
			(this.typeID == castOther.typeID)
			&& (this.attributeID == castOther.attributeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.typeID);
		hash = hash * prime + (this.attributeID);
		
		return hash;
    }
}