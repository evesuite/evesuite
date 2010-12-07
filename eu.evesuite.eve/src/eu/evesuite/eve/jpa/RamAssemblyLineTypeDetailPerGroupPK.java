package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ramAssemblyLineTypeDetailPerGroup database table.
 * 
 */
@Embeddable
public class RamAssemblyLineTypeDetailPerGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte assemblyLineTypeID;

	private short groupID;

    public RamAssemblyLineTypeDetailPerGroupPK() {
    }
	public byte getAssemblyLineTypeID() {
		return this.assemblyLineTypeID;
	}
	public void setAssemblyLineTypeID(byte assemblyLineTypeID) {
		this.assemblyLineTypeID = assemblyLineTypeID;
	}
	public short getGroupID() {
		return this.groupID;
	}
	public void setGroupID(short groupID) {
		this.groupID = groupID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RamAssemblyLineTypeDetailPerGroupPK)) {
			return false;
		}
		RamAssemblyLineTypeDetailPerGroupPK castOther = (RamAssemblyLineTypeDetailPerGroupPK)other;
		return 
			(this.assemblyLineTypeID == castOther.assemblyLineTypeID)
			&& (this.groupID == castOther.groupID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.assemblyLineTypeID);
		hash = hash * prime + (this.groupID);
		
		return hash;
    }
}