package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapSolarSystemJumps database table.
 * 
 */
@Entity
@Table(name="mapSolarSystemJumps")
@IdClass(MapSolarSystemJumpPK.class)
public class MapSolarSystemJump implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int fromSolarSystemID;

	@Id
	private int toSolarSystemID;
	
	private int fromConstellationID;

	private int fromRegionID;

	private int toConstellationID;

	private int toRegionID;
	
	@ManyToOne
	@JoinColumn(name="fromSolarSystemID", insertable=false, updatable=false)
	private MapSolarSystem fromMapSolarSystem;

	@ManyToOne
	@JoinColumn(name="toSolarSystemID", insertable=false, updatable=false)
	private MapSolarSystem toMapSolarSystem;

    public MapSolarSystem getFromMapSolarSystem() {
		return fromMapSolarSystem;
	}

	public void setFromMapSolarSystem(MapSolarSystem fromMapSolarSystem) {
		this.fromMapSolarSystem = fromMapSolarSystem;
	}

	public MapSolarSystem getToMapSolarSystem() {
		return toMapSolarSystem;
	}

	public void setToMapSolarSystem(MapSolarSystem toMapSolarSystem) {
		this.toMapSolarSystem = toMapSolarSystem;
	}

	public MapSolarSystemJump() {
    }

	public int getFromSolarSystemID() {
		return fromSolarSystemID;
	}


	public void setFromSolarSystemID(int fromSolarSystemID) {
		this.fromSolarSystemID = fromSolarSystemID;
	}


	public int getToSolarSystemID() {
		return toSolarSystemID;
	}


	public void setToSolarSystemID(int toSolarSystemID) {
		this.toSolarSystemID = toSolarSystemID;
	}


	public int getFromConstellationID() {
		return this.fromConstellationID;
	}

	public void setFromConstellationID(int fromConstellationID) {
		this.fromConstellationID = fromConstellationID;
	}

	public int getFromRegionID() {
		return this.fromRegionID;
	}

	public void setFromRegionID(int fromRegionID) {
		this.fromRegionID = fromRegionID;
	}

	public int getToConstellationID() {
		return this.toConstellationID;
	}

	public void setToConstellationID(int toConstellationID) {
		this.toConstellationID = toConstellationID;
	}

	public int getToRegionID() {
		return this.toRegionID;
	}

	public void setToRegionID(int toRegionID) {
		this.toRegionID = toRegionID;
	}

}