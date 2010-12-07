package eu.evesuite.eve.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mapLandmarks database table.
 * 
 */
@Entity
@Table(name="mapLandmarks")
public class MapLandmark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short landmarkID;

	private String description;

	private short graphicID;

	private byte importance;

	private String landmarkName;

	private int locationID;

	private double radius;

	private String url2d;

	private double x;

	private double y;

	private double z;

    public MapLandmark() {
    }

	public short getLandmarkID() {
		return this.landmarkID;
	}

	public void setLandmarkID(short landmarkID) {
		this.landmarkID = landmarkID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getGraphicID() {
		return this.graphicID;
	}

	public void setGraphicID(short graphicID) {
		this.graphicID = graphicID;
	}

	public byte getImportance() {
		return this.importance;
	}

	public void setImportance(byte importance) {
		this.importance = importance;
	}

	public String getLandmarkName() {
		return this.landmarkName;
	}

	public void setLandmarkName(String landmarkName) {
		this.landmarkName = landmarkName;
	}

	public int getLocationID() {
		return this.locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getUrl2d() {
		return this.url2d;
	}

	public void setUrl2d(String url2d) {
		this.url2d = url2d;
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