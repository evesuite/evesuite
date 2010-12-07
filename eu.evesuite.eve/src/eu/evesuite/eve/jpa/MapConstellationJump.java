package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapConstellationJumps database table.
 * 
 */
@Entity
@Table(name="mapConstellationJumps")
public class MapConstellationJump implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MapConstellationJumpPK id;

	private int fromRegionID;

	private int toRegionID;

    public MapConstellationJump() {
    }

	public MapConstellationJumpPK getId() {
		return this.id;
	}

	public void setId(MapConstellationJumpPK id) {
		this.id = id;
	}
	
	public int getFromRegionID() {
		return this.fromRegionID;
	}

	public void setFromRegionID(int fromRegionID) {
		this.fromRegionID = fromRegionID;
	}

	public int getToRegionID() {
		return this.toRegionID;
	}

	public void setToRegionID(int toRegionID) {
		this.toRegionID = toRegionID;
	}

}