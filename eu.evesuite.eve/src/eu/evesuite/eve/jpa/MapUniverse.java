package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapUniverse database table.
 * 
 */
@Entity
@Table(name="mapUniverse")
public class MapUniverse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int universeID;

	private double radius;

	private String universeName;

	private double x;

	private double xMax;

	private double xMin;

	private double y;

	private double yMax;

	private double yMin;

	private double z;

	private double zMax;

	private double zMin;

    public MapUniverse() {
    }

	public int getUniverseID() {
		return this.universeID;
	}

	public void setUniverseID(int universeID) {
		this.universeID = universeID;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getUniverseName() {
		return this.universeName;
	}

	public void setUniverseName(String universeName) {
		this.universeName = universeName;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getXMax() {
		return this.xMax;
	}

	public void setXMax(double xMax) {
		this.xMax = xMax;
	}

	public double getXMin() {
		return this.xMin;
	}

	public void setXMin(double xMin) {
		this.xMin = xMin;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getYMax() {
		return this.yMax;
	}

	public void setYMax(double yMax) {
		this.yMax = yMax;
	}

	public double getYMin() {
		return this.yMin;
	}

	public void setYMin(double yMin) {
		this.yMin = yMin;
	}

	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getZMax() {
		return this.zMax;
	}

	public void setZMax(double zMax) {
		this.zMax = zMax;
	}

	public double getZMin() {
		return this.zMin;
	}

	public void setZMin(double zMin) {
		this.zMin = zMin;
	}

}