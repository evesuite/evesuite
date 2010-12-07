package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapJumps database table.
 * 
 */
@Entity
@Table(name="mapJumps")
public class MapJump implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int stargateID;

	private int celestialID;

    public MapJump() {
    }

	public int getStargateID() {
		return this.stargateID;
	}

	public void setStargateID(int stargateID) {
		this.stargateID = stargateID;
	}

	public int getCelestialID() {
		return this.celestialID;
	}

	public void setCelestialID(int celestialID) {
		this.celestialID = celestialID;
	}

}