package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ramInstallationTypeContents database table.
 * 
 */
@Embeddable
public class RamInstallationTypeContentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private short installationTypeID;

	private byte assemblyLineTypeID;

    public RamInstallationTypeContentPK() {
    }
	public short getInstallationTypeID() {
		return this.installationTypeID;
	}
	public void setInstallationTypeID(short installationTypeID) {
		this.installationTypeID = installationTypeID;
	}
	public byte getAssemblyLineTypeID() {
		return this.assemblyLineTypeID;
	}
	public void setAssemblyLineTypeID(byte assemblyLineTypeID) {
		this.assemblyLineTypeID = assemblyLineTypeID;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RamInstallationTypeContentPK)) {
			return false;
		}
		RamInstallationTypeContentPK castOther = (RamInstallationTypeContentPK)other;
		return 
			(this.installationTypeID == castOther.installationTypeID)
			&& (this.assemblyLineTypeID == castOther.assemblyLineTypeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + (this.installationTypeID);
		hash = hash * prime + (this.assemblyLineTypeID);
		
		return hash;
    }
}