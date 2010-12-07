package eu.evesuite.eve.jpa;

import java.io.Serializable;

public class PlanetSchematicsTypeMapPK implements Serializable {
	
	private static final long serialVersionUID = -1505453970896567743L;

	private int schematicID;

	private int typeID;

    public PlanetSchematicsTypeMapPK() {
    }
    
	public int getSchematicID() {
		return this.schematicID;
	}
	
	public void setSchematicID(int schematicID) {
		this.schematicID = schematicID;
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
		if (!(other instanceof PlanetSchematicsTypeMapPK)) {
			return false;
		}
		PlanetSchematicsTypeMapPK castOther = (PlanetSchematicsTypeMapPK)other;
		return 
			(this.schematicID == castOther.getSchematicID())
			&& (this.typeID == castOther.getTypeID());

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.schematicID);
		hash = hash * prime + (this.typeID);
		
		return hash;
    }

	@Override
	public String toString() {
		return "PlanetSchematicsTypeMapPK [schematicID=" + schematicID
				+ ", typeID=" + typeID + "]";
	}
}