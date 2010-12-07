package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapDenormalize database table.
 * 
 */
@Entity
@Table(name="mapDenormalize")
public class MapDenormalize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int itemID;

	private byte celestialIndex;

	private int constellationID;

	private short groupID;

	private String itemName;

	private int orbitID;

	private byte orbitIndex;

	private double radius;

	private int regionID;

	private double security;

	private int solarSystemID;

	private short typeID;

	private double x;

	private double y;

	private double z;

    public MapDenormalize() {
    }

	public int getItemID() {
		return this.itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public byte getCelestialIndex() {
		return this.celestialIndex;
	}

	public void setCelestialIndex(byte celestialIndex) {
		this.celestialIndex = celestialIndex;
	}

	public int getConstellationID() {
		return this.constellationID;
	}

	public void setConstellationID(int constellationID) {
		this.constellationID = constellationID;
	}

	public short getGroupID() {
		return this.groupID;
	}

	public void setGroupID(short groupID) {
		this.groupID = groupID;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getOrbitID() {
		return this.orbitID;
	}

	public void setOrbitID(int orbitID) {
		this.orbitID = orbitID;
	}

	public byte getOrbitIndex() {
		return this.orbitIndex;
	}

	public void setOrbitIndex(byte orbitIndex) {
		this.orbitIndex = orbitIndex;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getRegionID() {
		return this.regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public double getSecurity() {
		return this.security;
	}

	public void setSecurity(double security) {
		this.security = security;
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public short getTypeID() {
		return this.typeID;
	}

	public void setTypeID(short typeID) {
		this.typeID = typeID;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}