package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ramAssemblyLineTypeDetailPerCategory database table.
 * 
 */
@Embeddable
public class RamAssemblyLineTypeDetailPerCategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte assemblyLineTypeID;

	private byte categoryID;

    public RamAssemblyLineTypeDetailPerCategoryPK() {
    }
	public byte getAssemblyLineTypeID() {
		return this.assemblyLineTypeID;
	}
	public void setAssemblyLineTypeID(byte assemblyLineTypeID) {
		this.assemblyLineTypeID = assemblyLineTypeID;
	}
	public byte getCategoryID() {
		return this.categoryID;
	}
	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RamAssemblyLineTypeDetailPerCategoryPK)) {
			return false;
		}
		RamAssemblyLineTypeDetailPerCategoryPK castOther = (RamAssemblyLineTypeDetailPerCategoryPK)other;
		return 
			(this.assemblyLineTypeID == castOther.assemblyLineTypeID)
			&& (this.categoryID == castOther.categoryID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.assemblyLineTypeID);
		hash = hash * prime + (this.categoryID);
		
		return hash;
    }
}