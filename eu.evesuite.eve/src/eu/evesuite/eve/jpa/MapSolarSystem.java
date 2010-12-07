package eu.evesuite.eve.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the mapSolarSystems database table.
 */
@Entity
@Table(name = "mapSolarSystems")
public class MapSolarSystem extends EntityAbstract {

	private static final long serialVersionUID = -3256444087647000943L;

	@Id
	private int solarSystemID;

	private boolean border;

	private boolean constellation;

	private int constellationID;

	private boolean corridor;

	private int factionID;

	private boolean fringe;

	private boolean hub;

	private boolean international;

	private double luminosity;

	private double radius;

	private boolean regional;

	private int regionID;

	private double security;

	private String securityClass;

	private String solarSystemName;

	private int sunTypeID;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "constellationID", insertable=false, updatable=false)
	private MapConstellation mapConstellation;

	@ManyToOne
	@JoinColumn(name = "factionID", insertable=false, updatable=false)
	private ChrFaction chrFaction;

	@OneToMany(mappedBy="fromMapSolarSystem")
	@JoinColumn(name="solarSystemID")
	private Collection<MapSolarSystemJump> fromSolarSystemJumps;
	
	@OneToMany(mappedBy="toMapSolarSystem")
	@JoinColumn(name="solarSystemID")
	private Collection<MapSolarSystemJump> toSolarSystemJumps;
	
	@ManyToMany
	@JoinTable(name="mapSolarSystemJumps", 
			joinColumns=@JoinColumn(name="fromSolarSystemID"), 
			inverseJoinColumns=@JoinColumn(name="toSolarSystemID"))
	private Collection<MapSolarSystem> toSolarSystems;
	
	@ManyToMany
	@JoinTable(name="mapSolarSystemJumps", 
			joinColumns=@JoinColumn(name="toSolarSystemID"), 
			inverseJoinColumns=@JoinColumn(name="fromSolarSystemID"))
	private Collection<MapSolarSystem> fromSolarSystems;
	
	public Collection<MapSolarSystem> getToSolarSystems() {
		return toSolarSystems;
	}

	public Collection<MapSolarSystem> getFromSolarSystems() {
		return fromSolarSystems;
	}

	public void setFromSolarSystems(Collection<MapSolarSystem> fromSolarSystems) {
		this.fromSolarSystems = fromSolarSystems;
	}

	public void setToSolarSystems(Collection<MapSolarSystem> toSolarSystems) {
		this.toSolarSystems = toSolarSystems;
	}

	public Collection<MapSolarSystemJump> getFromSolarSystemJumps() {
		return fromSolarSystemJumps;
	}

	public void setFromSolarSystemJumps(
			Collection<MapSolarSystemJump> fromSolarSystemJumps) {
		this.fromSolarSystemJumps = fromSolarSystemJumps;
	}

	public Collection<MapSolarSystemJump> getToSolarSystemJumps() {
		return toSolarSystemJumps;
	}

	public void setToSolarSystemJumps(
			Collection<MapSolarSystemJump> toSolarSystemJumps) {
		this.toSolarSystemJumps = toSolarSystemJumps;
	}

	public MapRegion getMapRegion() {
		return mapRegion;
	}

	public void setMapRegion(MapRegion mapRegion) {
		this.mapRegion = mapRegion;
	}

	public MapConstellation getMapConstellation() {
		return mapConstellation;
	}

	public void setMapConstellation(MapConstellation mapConstellation) {
		this.mapConstellation = mapConstellation;
	}

	public ChrFaction getChrFaction() {
		return chrFaction;
	}

	public void setChrFaction(ChrFaction chrFaction) {
		this.chrFaction = chrFaction;
	}

	public MapSolarSystem() {
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public boolean getBorder() {
		return this.border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public boolean getConstellation() {
		return this.constellation;
	}

	public void setConstellation(boolean constellation) {
		this.constellation = constellation;
	}

	public int getConstellationID() {
		return this.constellationID;
	}

	public void setConstellationID(int constellationID) {
		this.constellationID = constellationID;
	}

	public boolean getCorridor() {
		return this.corridor;
	}

	public void setCorridor(boolean corridor) {
		this.corridor = corridor;
	}

	public int getFactionID() {
		return this.factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public boolean getFringe() {
		return this.fringe;
	}

	public void setFringe(boolean fringe) {
		this.fringe = fringe;
	}

	public boolean getHub() {
		return this.hub;
	}

	public void setHub(boolean hub) {
		this.hub = hub;
	}

	public boolean getInternational() {
		return this.international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public double getLuminosity() {
		return this.luminosity;
	}

	public void setLuminosity(double luminosity) {
		this.luminosity = luminosity;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean getRegional() {
		return this.regional;
	}

	public void setRegional(boolean regional) {
		this.regional = regional;
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

	public String getSecurityClass() {
		return this.securityClass;
	}

	public void setSecurityClass(String securityClass) {
		this.securityClass = securityClass;
	}

	public String getSolarSystemName() {
		return this.solarSystemName;
	}

	public void setSolarSystemName(String solarSystemName) {
		this.solarSystemName = solarSystemName;
	}

	public int getSunTypeID() {
		return this.sunTypeID;
	}

	public void setSunTypeID(int sunTypeID) {
		this.sunTypeID = sunTypeID;
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
		result = prime * result + solarSystemID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MapSolarSystem))
			return false;
		MapSolarSystem other = (MapSolarSystem) obj;
		if (solarSystemID != other.getSolarSystemID())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MapSolarSystem [solarSystemID=" + solarSystemID + ", border="
				+ border + ", constellation=" + constellation
				+ ", constellationID=" + constellationID + ", corridor="
				+ corridor + ", factionID=" + factionID + ", fringe=" + fringe
				+ ", hub=" + hub + ", international=" + international
				+ ", luminosity=" + luminosity + ", radius=" + radius
				+ ", regional=" + regional + ", regionID=" + regionID
				+ ", security=" + security + ", securityClass=" + securityClass
				+ ", solarSystemName=" + solarSystemName + ", sunTypeID="
				+ sunTypeID + ", x=" + x + ", xMax=" + xMax + ", xMin=" + xMin
				+ ", y=" + y + ", yMax=" + yMax + ", yMin=" + yMin + ", z=" + z
				+ ", zMax=" + zMax + ", zMin=" + zMin + ", mapRegion="
				+ mapRegion + ", mapConstellation=" + mapConstellation
				+ ", chrFaction=" + chrFaction + ", fromSolarSystemJumps="
				+ fromSolarSystemJumps + ", toSolarSystemJumps="
				+ toSolarSystemJumps + ", toSolarSystems=" + toSolarSystems
				+ ", fromSolarSystems=" + fromSolarSystems + "]";
	}
}