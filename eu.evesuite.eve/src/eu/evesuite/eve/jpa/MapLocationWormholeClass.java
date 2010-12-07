package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapLocationWormholeClasses database table.
 * 
 */
@Entity
@Table(name="mapLocationWormholeClasses")
public class MapLocationWormholeClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int locationID;

	private byte wormholeClassID;

    public MapLocationWormholeClass() {
    }

	public int getLocationID() {
		return this.locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public byte getWormholeClassID() {
		return this.wormholeClassID;
	}

	public void setWormholeClassID(byte wormholeClassID) {
		this.wormholeClassID = wormholeClassID;
	}

}