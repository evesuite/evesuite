package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ramAssemblyLineStations database table.
 * 
 */
@Embeddable
public class RamAssemblyLineStationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int stationID;

	private byte assemblyLineTypeID;

    public RamAssemblyLineStationPK() {
    }
	public int getStationID() {
		return this.stationID;
	}
	public void setStationID(int stationID) {
		this.stationID = stationID;
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
		if (!(other instanceof RamAssemblyLineStationPK)) {
			return false;
		}
		RamAssemblyLineStationPK castOther = (RamAssemblyLineStationPK)other;
		return 
			(this.stationID == castOther.stationID)
			&& (this.assemblyLineTypeID == castOther.assemblyLineTypeID);

    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.stationID;
		hash = hash * prime + (this.assemblyLineTypeID);
		
		return hash;
    }
}