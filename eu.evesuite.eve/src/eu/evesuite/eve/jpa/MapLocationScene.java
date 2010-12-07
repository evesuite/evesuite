package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapLocationScenes database table.
 * 
 */
@Entity
@Table(name="mapLocationScenes")
public class MapLocationScene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int locationID;

	private byte sceneID;

    public MapLocationScene() {
    }

	public int getLocationID() {
		return this.locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public byte getSceneID() {
		return this.sceneID;
	}

	public void setSceneID(byte sceneID) {
		this.sceneID = sceneID;
	}

}