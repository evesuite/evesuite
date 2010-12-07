package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ramAssemblyLineStations database table.
 * 
 */
@Entity
@Table(name="ramAssemblyLineStations")
public class RamAssemblyLineStation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RamAssemblyLineStationPK id;

	private int ownerID;

	private byte quantity;

	private int regionID;

	private int solarSystemID;

	private short stationTypeID;

    public RamAssemblyLineStation() {
    }

	public RamAssemblyLineStationPK getId() {
		return this.id;
	}

	public void setId(RamAssemblyLineStationPK id) {
		this.id = id;
	}
	
	public int getOwnerID() {
		return this.ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public byte getQuantity() {
		return this.quantity;
	}

	public void setQuantity(byte quantity) {
		this.quantity = quantity;
	}

	public int getRegionID() {
		return this.regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public short getStationTypeID() {
		return this.stationTypeID;
	}

	public void setStationTypeID(short stationTypeID) {
		this.stationTypeID = stationTypeID;
	}

}