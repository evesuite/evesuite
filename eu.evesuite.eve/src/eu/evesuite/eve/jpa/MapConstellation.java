package eu.evesuite.eve.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the mapConstellations database table.
 * 
 */
@Entity
@Table(name = "mapConstellations")
public class MapConstellation extends EntityAbstract {

	private static final long serialVersionUID = -2388161628550272044L;

	@Id
	private int constellationID;

	private String constellationName;

	private int factionID;

	private double radius;

	private int regionID;

	private double x;

	private double xMax;

	private double xMin;

	private double y;

	private double yMax;

	private double yMin;

	private double z;

	private double zMax;

	private double zMin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regionID", insertable=false, updatable=false)
	private MapRegion mapRegion;

	@OneToMany(mappedBy = "mapConstellation", fetch = FetchType.LAZY)
	private Collection<MapSolarSystem> mapSolarSystems;

	@ManyToOne
	@JoinColumn(name = "factionID", insertable=false, updatable=false)
	private ChrFaction chrFaction;

	public MapRegion getMapRegion() {
		return mapRegion;
	}

	public void setMapRegion(MapRegion mapRegion) {
		this.mapRegion = mapRegion;
	}

	public Collection<MapSolarSystem> getMapSolarSystems() {
		return mapSolarSystems;
	}

	public void setMapSolarSystems(Collection<MapSolarSystem> mapSolarSystems) {
		this.mapSolarSystems = mapSolarSystems;
	}

	public ChrFaction getChrFaction() {
		return chrFaction;
	}

	public void setChrFaction(ChrFaction chrFaction) {
		this.chrFaction = chrFaction;
	}

	public MapConstellation() {
	}

	public int getConstellationID() {
		return this.constellationID;
	}

	public void setConstellationID(int constellationID) {
		this.constellationID = constellationID;
	}

	public String getConstellationName() {
		return this.constellationName;
	}

	public void setConstellationName(String constellationName) {
		this.constellationName = constellationName;
	}

	public int getFactionID() {
		return this.factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + constellationID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MapConstellation)) {
			return false;
		}
		MapConstellation other = (MapConstellation) obj;
		if (regionID != other.getConstellationID()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MapConstellation [constellationID=" + constellationID
				+ ", constellationName=" + constellationName + ", factionID="
				+ factionID + ", radius=" + radius + ", regionID=" + regionID
				+ ", x=" + x + ", xMax=" + xMax + ", xMin=" + xMin + ", y=" + y
				+ ", yMax=" + yMax + ", yMin=" + yMin + ", z=" + z + ", zMax="
				+ zMax + ", zMin=" + zMin + "]";
	}

}